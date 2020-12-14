package com.example.rickandmortycharacters.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.example.rickandmortycharacters.R;

import java.util.List;

public class CharacterAdapter extends ArrayAdapter<CharacterState> {

    private LayoutInflater inflater;
    private int laoyut;
    private List<CharacterState> characterStates;

    public CharacterAdapter(@NonNull Context context, int resource, @NonNull List<CharacterState> objects) {
        super(context, resource, objects);

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

        CharacterState states = characterStates.get(position);
        //ImageView = states.Image
        characterName.setText(states.getName());
        characterOrigin.setText(states.getOriginName());

        return view;
    }
}
