package id.ac.itn.gibolapps.utils;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import net.danlew.android.joda.JodaTimeAndroid;

import org.joda.time.DateTime;
import org.joda.time.Duration;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import id.ac.itn.gibolapps.R;
import id.ac.itn.gibolapps.worker.CheckSchedule;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings, new SettingsFragment())
                    .commit();
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    public static class SettingsFragment extends PreferenceFragmentCompat implements Preference.OnPreferenceChangeListener {
        private static final String TAG = SettingsActivity.class.getSimpleName();
        private String schedule_reminder;

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
            schedule_reminder = this.getResources().getString(R.string.schedule_reminder_key);
            findPreference(schedule_reminder).setOnPreferenceChangeListener(this);
        }

        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {
            String key = preference.getKey();
            boolean isOn = (boolean) newValue;
            if (key.equals(schedule_reminder)) {
                if (isOn) {
                    setSchedule_reminder();
                } else {
                    WorkManager.getInstance(requireContext()).cancelAllWorkByTag("MATCH_SCHEDULE");
                }
                return true;
            }
            return false;
        }

        private static Constraints getConstraint() {
            return new Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build();
        }

        private void setSchedule_reminder() {
            Calendar dueDate = Calendar.getInstance();
            Calendar currentDate = Calendar.getInstance();
            // Set Execution around 08:00:00 AM
            dueDate.set(Calendar.HOUR_OF_DAY, 8);
            dueDate.set(Calendar.MINUTE, 0);
            dueDate.set(Calendar.SECOND, 0);
            if (dueDate.before(currentDate)) {
                dueDate.add(Calendar.HOUR_OF_DAY, 24);
            }
            long timeDiff = dueDate.getTimeInMillis() - currentDate.getTimeInMillis();
            Log.d(TAG, "setSchedule_reminder: " + currentDate.getTime().toString() + " - delay " + timeDiff);
            PeriodicWorkRequest checkScheduleWorker = new PeriodicWorkRequest.Builder(CheckSchedule.class,24,TimeUnit.HOURS)
                    .setConstraints(getConstraint())
                    .addTag("MATCH_SCHEDULE")
                    .setInitialDelay(timeDiff, TimeUnit.MILLISECONDS)
                    .build();
            WorkManager.getInstance(requireContext()).enqueue(checkScheduleWorker);
        }
    }
}