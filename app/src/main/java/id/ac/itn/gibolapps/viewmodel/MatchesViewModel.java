package id.ac.itn.gibolapps.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.ac.itn.gibolapps.BuildConfig;
import id.ac.itn.gibolapps.api.ApiClient;
import id.ac.itn.gibolapps.model.MatchesList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchesViewModel extends ViewModel {
    private static final String TAG = MatchesViewModel.class.getSimpleName();
    MutableLiveData<MatchesList> matchesList;

    public MutableLiveData<MatchesList> getMatchesList() {
        if (matchesList == null) {
            matchesList = new MutableLiveData<>();
            setMatchesList();
        }
        return matchesList;
    }

    private void setMatchesList() {
        ApiClient.getInstance().getApi().getMatchesList("2001", BuildConfig.APIToken)
                .enqueue(new Callback<MatchesList>() {
                    @Override
                    public void onResponse(Call<MatchesList> call, Response<MatchesList> response) {
                        if (response.isSuccessful()) {
                            if (response.body().getCount() < 1) {
                                setScheduledMatchesList();
                            } else {
                                matchesList.postValue(response.body());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<MatchesList> call, Throwable t) {

                    }
                });
    }

    private void setScheduledMatchesList() {
        ApiClient.getInstance().getApi().getScheduledMatchesList("2001", "SCHEDULED", BuildConfig.APIToken)
                .enqueue(new Callback<MatchesList>() {
                    @Override
                    public void onResponse(Call<MatchesList> call, Response<MatchesList> response) {
                        matchesList.postValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<MatchesList> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                    }
                });
    }

    public void onRefresh() {
        if (matchesList != null) {
            setMatchesList();
        }
    }
}
