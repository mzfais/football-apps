package id.ac.itn.gibolapps.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.ac.itn.gibolapps.BuildConfig;
import id.ac.itn.gibolapps.api.ApiClient;
import id.ac.itn.gibolapps.model.MatchDetailsMD;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchDetailsViewModel extends ViewModel {

    private static final String TAG = MatchDetailsViewModel.class.getSimpleName();
    int matchId;
    MutableLiveData<MatchDetailsMD> matchDetails;

    public MatchDetailsViewModel(int matchId) {
        this.matchId = matchId;
    }

    public MutableLiveData<MatchDetailsMD> getMatchDetails() {
        if (matchDetails == null) {
            matchDetails = new MutableLiveData<>();
            setMatchDetails();
        }
        return matchDetails;
    }

    public void setMatchDetails() {
        ApiClient.getInstance().getApi().getMatchesDetails(this.matchId, BuildConfig.APIToken)
                .enqueue(new Callback<MatchDetailsMD>() {
                    @Override
                    public void onResponse(Call<MatchDetailsMD> call, Response<MatchDetailsMD> response) {
                        if (response.isSuccessful()) {
                            matchDetails.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<MatchDetailsMD> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                    }
                });
    }
}
