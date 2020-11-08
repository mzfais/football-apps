package id.ac.itn.gibolapps.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import id.ac.itn.gibolapps.R;
import id.ac.itn.gibolapps.adapter.MatchesAdapter;
import id.ac.itn.gibolapps.model.MatchesList;
import id.ac.itn.gibolapps.viewmodel.MatchesViewModel;

public class HomeFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private MatchesViewModel matchesViewModel;
    private MatchesAdapter adapter;
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
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        srl = view.findViewById(R.id.homeSwipe);
        srl.setOnRefreshListener(this);
        progressBar = view.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        final RecyclerView rv = view.findViewById(R.id.matchesRv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        matchesViewModel = new ViewModelProvider(getActivity()).get(MatchesViewModel.class);
        matchesViewModel.getMatchesList().observe(getViewLifecycleOwner(), new Observer<MatchesList>() {
            @Override
            public void onChanged(MatchesList matchesList) {
                adapter = new MatchesAdapter(getActivity(), matchesList.getMatches());
                adapter.notifyDataSetChanged();
                rv.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);
                if (matchesList.getCount() < 1) {
                    Toast.makeText(getActivity(), "No Champions League Matches Scheduled!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onRefresh() {
        progressBar.setVisibility(View.VISIBLE);
        srl.setRefreshing(true);
        matchesViewModel.onRefresh();
        srl.setRefreshing(false);
    }
}