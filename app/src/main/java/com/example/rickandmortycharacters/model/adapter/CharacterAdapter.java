package com.example.rickandmortycharacters.model.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rickandmortycharacters.R;
import com.example.rickandmortycharacters.model.retrofit.model.CharacterList.CharacterResults;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<CharacterResults> states;

    public CharacterAdapter(Context context, List<CharacterResults> states){
        this.inflater = LayoutInflater.from(context);
        this.states = states;
    }

    @NonNull
    @Override
    public CharacterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.character_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterAdapter.ViewHolder holder, int position) {
        CharacterResults state = states.get(position);
        holder.characterName.setText(state.getName());
        holder.characterOrigin.setText(state.getOrigin().getName());
        holder.characterStatus.setText(state.getStatus());
        if (state.getStatus().equals("Alive")){
            holder.characterStatus.setTextColor(Color.rgb(0, 255, 0));
        } else
            if (state.getStatus().equals("Dead")){
                holder.characterStatus.setTextColor(Color.rgb(255, 0, 0));
            } else
            {
                holder.characterStatus.setTextColor(Color.rgb(0,0, 0));
            }
        Picasso.with(inflater.getContext()).load(state.getImage()).into(holder.characterImage);
    }

    @Override
    public int getItemCount() {
        return states.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView characterImage;
        private TextView characterName, characterOrigin, characterStatus;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            characterImage = (ImageView) itemView.findViewById(R.id.character_image);
            characterName = (TextView) itemView.findViewById(R.id.character_name);
            characterOrigin = (TextView) itemView.findViewById(R.id.character_origin);
            characterStatus = (TextView) itemView.findViewById(R.id.character_status);
        }
    }
}
