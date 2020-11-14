package id.ac.itn.gibolapps.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;

import java.util.List;

import id.ac.itn.gibolapps.R;
import id.ac.itn.gibolapps.model.TableItem;
import id.ac.itn.gibolapps.model.Team;

public class StandingTeamAdapter extends RecyclerView.Adapter<StandingTeamAdapter.ViewHolder> {

    Context mtcx;
    List<TableItem> itemList;

    public StandingTeamAdapter(List<TableItem> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.mtcx = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewGroup root;
        View view = layoutInflater.inflate(R.layout.team_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TableItem tableItem = itemList.get(position);
        Team team = tableItem.getTeam();
        holder.tvPos.setText(String.valueOf(tableItem.getPosition()));
        holder.tvTeamName.setText(String.valueOf(team.getName()));
        GlideToVectorYou.init().with(mtcx).load(Uri.parse(team.getCrestUrl()), holder.ivLogo);
        holder.tvPlay.setText(String.valueOf(tableItem.getPlayedGames()));
        holder.tvWon.setText(String.valueOf(tableItem.getWon()));
        holder.tvDraw.setText(String.valueOf(tableItem.getDraw()));
        holder.tvLoss.setText(String.valueOf(tableItem.getLost()));
        holder.tvGd.setText(String.valueOf(tableItem.getGoalDifference()));
        holder.tvPts.setText(String.valueOf(tableItem.getPoints()));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvPos, tvTeamName, tvPlay, tvWon, tvDraw, tvLoss, tvGd, tvPts;
        ImageView ivLogo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPos = itemView.findViewById(R.id.tvPosTeam);
            tvTeamName = itemView.findViewById(R.id.tvTeamName);
            tvPlay = itemView.findViewById(R.id.tvPlayedGames);
            tvWon = itemView.findViewById(R.id.tvWon);
            tvDraw = itemView.findViewById(R.id.tvDraw);
            tvLoss = itemView.findViewById(R.id.tvLoss);
            tvGd = itemView.findViewById(R.id.tvGd);
            tvPts = itemView.findViewById(R.id.tvPts);
            ivLogo = itemView.findViewById(R.id.imageView);
        }
    }
}
