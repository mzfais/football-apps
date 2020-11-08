package id.ac.itn.gibolapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import id.ac.itn.gibolapps.model.MatchDetailsMD;
import id.ac.itn.gibolapps.utils.DateConverter;
import id.ac.itn.gibolapps.viewmodel.MatchDetailsVMFactory;
import id.ac.itn.gibolapps.viewmodel.MatchDetailsViewModel;

public class MatchDetailsActivity extends AppCompatActivity {
    public static final String MATCH_ID = "matchId";
    private TextView tvHomeTeam, tvAwayTeam, tvScore, tvStageInfo, tvDate, tvVenue;
    private TextView tvHomeWins, tvAwayWins, tvHomeDraws, tvAwayDraws, tvHomeLosses, tvAwayLosses;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_details);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Match Details");
        }
        tvHomeTeam = findViewById(R.id.tvHomeTeam);
        tvAwayTeam = findViewById(R.id.tvAwayTeam);
        tvScore = findViewById(R.id.tvScore);
        tvStageInfo = findViewById(R.id.tvStageInfo);
        tvDate = findViewById(R.id.tvKickOffTime);
        tvVenue = findViewById(R.id.tvVenue);
        tvHomeWins = findViewById(R.id.tvHomeWins);
        tvAwayWins = findViewById(R.id.tvAwayWins);
        tvHomeDraws = findViewById(R.id.tvHomeDraws);
        tvAwayDraws = findViewById(R.id.tvAwayDraws);
        tvHomeLosses = findViewById(R.id.tvHomeLosses);
        tvAwayLosses = findViewById(R.id.tvAwayLosses);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        final int matchId = getIntent().getIntExtra(MATCH_ID, 0);
        final DateConverter dc = new DateConverter();
        ImageView uclCover = findViewById(R.id.uclCover);
        uclCover.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_anim));
        ConstraintLayout detilLayout = findViewById(R.id.detailItem);
        detilLayout.setAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_up));
        MatchDetailsViewModel mvm = new ViewModelProvider(this,
                new MatchDetailsVMFactory(matchId)).get(MatchDetailsViewModel.class);
        mvm.getMatchDetails().observe(this, new Observer<MatchDetailsMD>() {
            @Override
            public void onChanged(MatchDetailsMD matchDetailsMD) {
                tvHomeTeam.setText(matchDetailsMD.getMatch().getHomeTeam().getName());
                tvAwayTeam.setText(matchDetailsMD.getMatch().getAwayTeam().getName());
                String score = String.valueOf(matchDetailsMD.getMatch().getScore().getFullTime().getHomeTeam())
                        + " : " + String.valueOf(matchDetailsMD.getMatch().getScore().getFullTime().getAwayTeam());

                tvScore.setText(score);
                tvStageInfo.setText("Matchday " + String.valueOf(matchDetailsMD.getMatch().getMatchday()));
                tvDate.setText(dc.UtcToLocal(matchDetailsMD.getMatch().getUtcDate(), "dd/MM/yyyy HH:mm"));
                tvVenue.setText(matchDetailsMD.getMatch().getVenue());
                if (matchDetailsMD.getHead2head() != null) {
                    tvHomeWins.setText(String.valueOf(matchDetailsMD.getHead2head().getHomeTeam().getWins()));
                    tvAwayWins.setText(String.valueOf(matchDetailsMD.getHead2head().getAwayTeam().getWins()));
                    tvHomeDraws.setText(String.valueOf(matchDetailsMD.getHead2head().getHomeTeam().getDraws()));
                    tvAwayDraws.setText(String.valueOf(matchDetailsMD.getHead2head().getAwayTeam().getDraws()));
                    tvHomeLosses.setText(String.valueOf(matchDetailsMD.getHead2head().getHomeTeam().getLosses()));
                    tvAwayLosses.setText(String.valueOf(matchDetailsMD.getHead2head().getAwayTeam().getLosses()));
                }
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}