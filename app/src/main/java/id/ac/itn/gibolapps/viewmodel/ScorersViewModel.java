package id.ac.itn.gibolapps.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.ac.itn.gibolapps.BuildConfig;
import id.ac.itn.gibolapps.api.ApiClient;
import id.ac.itn.gibolapps.model.ScorersList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScorersViewModel extends ViewModel {
    private static final String TAG = "ScorersViewModel";
    MutableLiveData<ScorersList> scorersList;

    public MutableLiveData<ScorersList> getScorersList() {
        if (scorersList == null) {
            scorersList = new MutableLiveData<>();
            setScorersList();
        }
        return scorersList;
    }

    private void setScorersList() {
        ApiClient.getInstance().getApi().getScorersList("2001", BuildConfig.APIToken)
                .enqueue(new Callback<ScorersList>() {
                    @Override
                    public void onResponse(Call<ScorersList> call, Response<ScorersList> response) {
                        Log.d(TAG, "onResponse: "+response.body().getCount());
                        if (response.isSuccessful()) {
                            scorersList.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<ScorersList> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                    }
                });
    }

    public void onRefresh() {
        if (scorersList.getValue() != null) {
            setScorersList();
        }
    }
}
