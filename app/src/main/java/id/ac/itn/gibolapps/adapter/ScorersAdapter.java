package id.ac.itn.gibolapps.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.itn.gibolapps.R;
import id.ac.itn.gibolapps.model.ScorersItem;

public class ScorersAdapter extends RecyclerView.Adapter<ScorersAdapter.ScorersViewHolder> {
    private static final String TAG = ScorersAdapter.class.getSimpleName();
    private Context mctx;
    private List<ScorersItem> scoreList;

    public ScorersAdapter(Context mctx, List<ScorersItem> scoreList) {
        this.mctx = mctx;
        this.scoreList = scoreList;
    }

    public List<ScorersItem> getScoreList() {
        return scoreList;
    }

    public void setMatchesList(List<ScorersItem> scoreList) {
        this.scoreList = scoreList;
    }

    @NonNull
    @Override
    public ScorersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.mctx).inflate(R.layout.player_list_item, parent, false);
        return new ScorersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScorersViewHolder holder, int position) {
        ScorersItem score = getScoreList().get(position);
        holder.tvPlayerTeam.setText(score.getTeam().getName());
        holder.tvPlayerName.setText(score.getPlayer().getName());
        holder.tvTotal.setText(String.valueOf(score.getNumberOfGoals()));
    }

    @Override
    public int getItemCount() {
        return scoreList.size();
    }

    public class ScorersViewHolder extends RecyclerView.ViewHolder {
        private TextView tvPlayerTeam, tvPlayerName, tvTotal;

        public ScorersViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPlayerTeam = itemView.findViewById(R.id.tvPlayerTeam);
            tvPlayerName = itemView.findViewById(R.id.tvPlayerName);
            tvTotal = itemView.findViewById(R.id.tvTotal);
        }
    }
}
