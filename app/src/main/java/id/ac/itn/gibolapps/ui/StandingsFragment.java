package id.ac.itn.gibolapps.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import id.ac.itn.gibolapps.R;
import id.ac.itn.gibolapps.adapter.StandingListAdapter;
import id.ac.itn.gibolapps.model.StandingList;
import id.ac.itn.gibolapps.viewmodel.StandingViewModel;


public class StandingsFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    RecyclerView mainRv;
    StandingListAdapter standingListAdapter;
    StandingViewModel svm;
    SwipeRefreshLayout srl;
    ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_standings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar = view.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        srl = view.findViewById(R.id.standingSwipe);
        srl.setOnRefreshListener(this);
        mainRv = view.findViewById(R.id.mainStandingRv);
        svm = new ViewModelProvider(getActivity()).get(StandingViewModel.class);
        svm.getStandingList().observe(getViewLifecycleOwner(), new Observer<StandingList>() {
            @Override
            public void onChanged(StandingList standingList) {
                standingListAdapter = new StandingListAdapter(standingList.getStandings());
                standingListAdapter.notifyDataSetChanged();
                mainRv.setAdapter(standingListAdapter);
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onRefresh() {
        srl.setRefreshing(true);
        progressBar.setVisibility(View.VISIBLE);
        svm.onRefresh();
        srl.setRefreshing(false);
    }
}