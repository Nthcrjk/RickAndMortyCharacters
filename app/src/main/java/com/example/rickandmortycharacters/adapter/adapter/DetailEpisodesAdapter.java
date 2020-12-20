package com.example.rickandmortycharacters.adapter.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rickandmortycharacters.R;
import com.example.rickandmortycharacters.model.retrofit.model.EpisodItem.EpisodeItem;

import java.util.List;

public class DetailEpisodesAdapter extends RecyclerView.Adapter<DetailEpisodesAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<EpisodeItem> states;

    public DetailEpisodesAdapter(Context context, List<EpisodeItem> states){
        this.states = states;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.e("gaf", "onCreatedViewHolder");
        View view = inflater.inflate(R.layout.episode_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EpisodeItem state = states.get(position);
        Log.e("gaf", "onBindViewHolder");
        holder.bind(state.getId());
        holder.episode.setText(state.getEpisode());
        holder.air_date.setText(state.getAir_date());
    }

    @Override
    public int getItemCount() {
        return states.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{
        private int idOfEpisode;
        private TextView episode, air_date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.e("gaf", "ViewHolder");
            episode = (TextView) itemView.findViewById(R.id.episode_name);
            air_date = (TextView) itemView.findViewById(R.id.episode_air_date);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //START new ACTIVITY BY idOfEpisode
                }
            });
        }
        public void bind(int id){
            idOfEpisode = id;
        }
    }


}
