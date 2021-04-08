package com.maulanakurnia.agentvalorant.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.maulanakurnia.agentvalorant.R;
import com.maulanakurnia.agentvalorant.model.AgentModel;
import com.maulanakurnia.agentvalorant.ui.DetailActivity;

import java.util.ArrayList;

public class AgentAdapter extends RecyclerView.Adapter<AgentAdapter.AgentViewHolder> {
    private ArrayList<AgentModel> listAgent;
    private Context context;

    public AgentAdapter(ArrayList<AgentModel> dataList, Context context) {
        this.listAgent = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public AgentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_card_recyclerview, parent, false);
        return new AgentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AgentViewHolder holder, int position) {
        String image    = listAgent.get(position).getImage();
        String name     = listAgent.get(position).getName();
        String role     = listAgent.get(position).getRole();
        String summary  = listAgent.get(position).getSummary();

        Glide.with(holder.itemView.getContext())
            .load(listAgent.get(position).getImage())
            .into(holder.image);

        holder.name.setText(name);
        holder.role.setText(role);
        holder.summary.setText(summary);

        try {

            holder.btnPreview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openDetailActivity(image, name, role, summary);
                }
            });

            holder.btnShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    shareAgent(name, summary);
                }
            });
        }catch (Exception e) {
            Log.d("DetailActivity", "MyErr : " + e);
        }
    }

    @Override
    public int getItemCount() {
        return (listAgent != null) ? listAgent.size() : 0;
    }


    public static class AgentViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView name, role, summary;
        private final Button btnPreview, btnShare;

        public AgentViewHolder(View itemView) {
            super(itemView);
            image      = (ImageView) itemView.findViewById(R.id.agent_image);
            name       = (TextView) itemView.findViewById(R.id.agent_name);
            role       = (TextView) itemView.findViewById(R.id.agent_role);
            summary    = (TextView) itemView.findViewById(R.id.agent_summary);
            btnPreview = (Button) itemView.findViewById(R.id.btnPreview);
            btnShare   = (Button) itemView.findViewById(R.id.btnShare);
        }
    }

    public void openDetailActivity(@NonNull String ...agent) {
        Intent i = new Intent(context, DetailActivity.class);
        i.putExtra("IMAGE_KEY", agent[0]);
        i.putExtra("NAME_KEY", agent[1]);
        i.putExtra("ROLE_KEY", agent[2]);
        i.putExtra("SUMMARY_KEY", agent[3]);
        context.startActivity(i);
    }

    public void shareAgent(@NonNull String ...agent) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, agent[0] + "\n\n" + agent[1]);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        context.startActivity(shareIntent);
    }
}
