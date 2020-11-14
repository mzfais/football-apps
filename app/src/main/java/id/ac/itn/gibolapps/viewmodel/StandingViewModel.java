package id.ac.itn.gibolapps.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.ac.itn.gibolapps.BuildConfig;
import id.ac.itn.gibolapps.api.ApiClient;
import id.ac.itn.gibolapps.model.StandingList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StandingViewModel extends ViewModel {
    private static final String TAG = StandingViewModel.class.getSimpleName();
    MutableLiveData<StandingList> standingList;

    public MutableLiveData<StandingList> getStandingList() {
        if (standingList == null) {
            standingList = new MutableLiveData<>();
            setStandingList();
        }
        return standingList;
    }

    public void setStandingList() {
        ApiClient.getInstance().getApi().getStandingList("2001", "TOTAL", BuildConfig.APIToken)
                .enqueue(new Callback<StandingList>() {
                    @Override
                    public void onResponse(Call<StandingList> call, Response<StandingList> response) {
                        if (response.isSuccessful()) {
                            standingList.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<StandingList> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                    }
                });
    }

    public void onRefresh() {
        if (standingList.getValue() != null) {
            setStandingList();
        }
    }
}
