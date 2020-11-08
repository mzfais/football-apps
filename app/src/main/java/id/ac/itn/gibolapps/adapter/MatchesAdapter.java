package id.ac.itn.gibolapps.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.itn.gibolapps.MatchDetailsActivity;
import id.ac.itn.gibolapps.R;
import id.ac.itn.gibolapps.model.MatchesItem;
import id.ac.itn.gibolapps.utils.DateConverter;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.MatchViewHolder> {

    private Context mtcx;
    private List<MatchesItem> matchesItemList;
    DateConverter dc = new DateConverter();

    public MatchesAdapter(Context mtcx, List<MatchesItem> matchesItemList) {
        this.mtcx = mtcx;
        this.matchesItemList = matchesItemList;
    }

    public List<MatchesItem> getMatchesItemList() {
        return matchesItemList;
    }

    public void setMatchesItemList(List<MatchesItem> matchesItemList) {
        this.matchesItemList = matchesItemList;
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.mtcx).inflate(R.layout.matches_item, parent, false);
        return new MatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
        MatchesItem matchesItem = getMatchesItemList().get(position);
        holder.tvGroupInfo.setText(matchesItem.getGroup().toUpperCase() + ": MATCHDAY - " + String.valueOf(matchesItem.getMatchday()));
        holder.tvDateInfo.setText(dc.UtcToLocal(matchesItem.getUtcDate()));
        holder.tvHomeName.setText(matchesItem.getHomeTeam().getName());
        holder.tvAwayName.setText(matchesItem.getAwayTeam().getName());
        holder.tvHomeScore.setText((matchesItem.getStatus().equals("SCHEDULED") ? "-" : String.valueOf(matchesItem.getScore().getFullTime().getHomeTeam())));
        holder.tvAwayScore.setText((matchesItem.getStatus().equals("SCHEDULED") ? "-" : String.valueOf(matchesItem.getScore().getFullTime().getAwayTeam())));

    }

    @Override
    public int getItemCount() {
        return matchesItemList.size();
    }

    public class MatchViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvGroupInfo, tvDateInfo, tvHomeName, tvAwayName, tvHomeScore, tvAwayScore;

        public MatchViewHolder(@NonNull View itemView) {
            super(itemView);
            tvGroupInfo = itemView.findViewById(R.id.tvGroupInfo);
            tvDateInfo = itemView.findViewById(R.id.tvDateInfo);
            tvHomeName = itemView.findViewById(R.id.tvHomeName);
            tvAwayName = itemView.findViewById(R.id.tvAwayName);
            tvHomeScore = itemView.findViewById(R.id.tvHomeScore);
            tvAwayScore = itemView.findViewById(R.id.tvAwayScore);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int id = getMatchesItemList().get(getAdapterPosition()).getId();
            Intent detail = new Intent(mtcx, MatchDetailsActivity.class);
            detail.putExtra(MatchDetailsActivity.MATCH_ID, id);
            mtcx.startActivity(detail);
        }
    }
}
