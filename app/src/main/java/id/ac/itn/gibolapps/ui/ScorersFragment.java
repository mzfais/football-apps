package id.ac.itn.gibolapps.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import id.ac.itn.gibolapps.R;
import id.ac.itn.gibolapps.adapter.ScorersAdapter;
import id.ac.itn.gibolapps.model.ScorersList;
import id.ac.itn.gibolapps.viewmodel.ScorersViewModel;

public class ScorersFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = ScorersFragment.class.getSimpleName();
    ScorersViewModel scorersViewModel;
    private ScorersAdapter scorersAdapter;
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
        return inflater.inflate(R.layout.fragment_scorers, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar = view.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        srl = view.findViewById(R.id.scorerSwipeRefresh);
        srl.setOnRefreshListener(this);
        final RecyclerView rvScorer = view.findViewById(R.id.scorersRv);
        scorersViewModel = new ViewModelProvider(getActivity()).get(ScorersViewModel.class);
        scorersViewModel.getScorersList().observe(getViewLifecycleOwner(), new Observer<ScorersList>() {
            @Override
            public void onChanged(ScorersList scorersList) {
                scorersAdapter = new ScorersAdapter(getActivity(), scorersList.getScorers());
                scorersAdapter.notifyDataSetChanged();
                rvScorer.setAdapter(scorersAdapter);
                progressBar.setVisibility(View.GONE);
                Log.d(TAG, "onChanged: " + scorersList.getCount());
            }
        });

    }

    @Override
    public void onRefresh() {
        srl.setRefreshing(true);
        progressBar.setVisibility(View.VISIBLE);
        scorersViewModel.onRefresh();
        srl.setRefreshing(false);
    }
}