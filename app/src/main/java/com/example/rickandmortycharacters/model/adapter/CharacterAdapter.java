package com.example.rickandmortycharacters.model.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.example.rickandmortycharacters.R;
import com.example.rickandmortycharacters.model.retrofit.model.CharacterList.CharacterResults;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class CharacterAdapter extends ArrayAdapter<CharacterResults> {

    private LayoutInflater inflater;
    private int laoyut;
    private List<CharacterResults> characterStates;
    private Context context;

    public CharacterAdapter(@NonNull Context context, int resource, @NonNull List<CharacterResults> objects) {
        super(context, resource, objects);
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.laoyut = resource;
        this.characterStates = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(laoyut, parent, false);

        ImageView characterImage = (ImageView) view.findViewById(R.id.character_image);
        TextView characterName = (TextView) view.findViewById(R.id.character_name);
        TextView characterOrigin = (TextView) view.findViewById(R.id.character_origin);
        TextView characterStatus = (TextView) view.findViewById(R.id.character_status);

        CharacterResults states = characterStates.get(position);

        Picasso.with(context).load(states.getImage()).into(characterImage);
        characterName.setText(states.getName());
        characterOrigin.setText(states.getOrigin().getName());

        if(states.getStatus().equals("Dead")){
            characterStatus.setTextColor(Color.rgb(255, 0, 0));
        } else
            if (states.getStatus().equals("Alive")){
                characterStatus.setTextColor(Color.rgb(0, 255, 0));
            } else
            {
                characterStatus.setTextColor(Color.rgb(200, 200, 0));
            }

        characterStatus.setText(states.getStatus());

        return view;
    }

}
