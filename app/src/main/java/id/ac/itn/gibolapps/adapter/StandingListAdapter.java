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
import id.ac.itn.gibolapps.model.StandingsItem;

public class StandingListAdapter extends RecyclerView.Adapter<StandingListAdapter.ViewHolder> {
    List<StandingsItem> standingItemList;

    public StandingListAdapter(List<StandingsItem> standingItemList) {
        this.standingItemList = standingItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.header_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StandingsItem standingsItem = this.standingItemList.get(position);
        holder.tvGroupName.setText(standingsItem.getGroup().replace("_", " "));
        StandingTeamAdapter standingTeamAdapter = new StandingTeamAdapter(standingsItem.getTable());
        holder.teamListRV.setAdapter(standingTeamAdapter);
    }

    @Override
    public int getItemCount() {
        return standingItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvGroupName;
        RecyclerView teamListRV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvGroupName = itemView.findViewById(R.id.tvGroupName);
            teamListRV = itemView.findViewById(R.id.teamListRv);
        }
    }
}
