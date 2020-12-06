package id.ac.itn.gibolapps.worker;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.util.Date;
import id.ac.itn.gibolapps.BuildConfig;
import id.ac.itn.gibolapps.MainActivity;
import id.ac.itn.gibolapps.R;
import id.ac.itn.gibolapps.api.ApiClient;
import id.ac.itn.gibolapps.model.MatchesList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static id.ac.itn.gibolapps.Gibol.CHANNEL_ID;

public class CheckSchedule extends Worker {
    private static final String TAG = CheckSchedule.class.getSimpleName();

    public CheckSchedule(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        getSchedule();
        return Result.success();
    }

    private void getSchedule() {
        Log.d(TAG, "getSchedule: do a request to server to check ucl schedule");
        ApiClient.getInstance().getApi().getScheduledMatchesList("2001","SCHEDULED", BuildConfig.APIToken)
                .enqueue(new Callback<MatchesList>() {
                    @Override
                    public void onResponse(Call<MatchesList> call, Response<MatchesList> response) {
                        if (response.isSuccessful()) {
                            if (response.body().getCount() > 0) {
                                try {
                                    Log.d(TAG, "onResponse: ditemukan jadwal hari ini");
                                    showNotification("See today's match schedule");
                                } catch (Exception e) {
                                    Log.d(TAG, "onResponse: " + e.getMessage());
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<MatchesList> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                    }
                });
    }

    private void showNotification(String s) {
        Log.d(TAG, "showNotification: Tampilkan notifikasi");
        Context context = getApplicationContext();
        Bitmap icon = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
        final int NOTIFICATION_ID = (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);
        Intent intent = new Intent(context, MainActivity.class);
        intent.setAction(context.getString(R.string.app_name));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        Notification notification = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setContentTitle("Hi...")
                .setContentText(s)
                .setLargeIcon(icon)
                .setSmallIcon(R.drawable.ic_notify)
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setAutoCancel(true)
                .build();

        NotificationManagerCompat mNotificationManager = NotificationManagerCompat.from(context);
        if (mNotificationManager != null) {
            mNotificationManager.notify(NOTIFICATION_ID, notification);
        }
    }
}
