package id.ac.itn.gibolapps.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MatchDetailsVMFactory implements ViewModelProvider.Factory {
    int matchId = 0;

    public MatchDetailsVMFactory(int matchId) {
        this.matchId = matchId;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MatchDetailsViewModel(this.matchId);
    }
}
