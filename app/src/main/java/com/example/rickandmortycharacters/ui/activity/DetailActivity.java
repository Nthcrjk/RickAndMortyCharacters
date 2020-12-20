package com.example.rickandmortycharacters.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rickandmortycharacters.R;
import com.example.rickandmortycharacters.adapter.adapter.DetailEpisodesAdapter;
import com.example.rickandmortycharacters.model.retrofit.model.Detail.DetailCharacter;
import com.example.rickandmortycharacters.model.retrofit.model.EpisodItem.EpisodeItem;
import com.example.rickandmortycharacters.presentations.presenter.DetailLocationPresenter;
import com.example.rickandmortycharacters.presentations.presenter.DetailPresenter;
import com.example.rickandmortycharacters.presentations.view.DetailView;
import com.squareup.picasso.Picasso;

import java.util.List;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class DetailActivity extends MvpAppCompatActivity implements DetailView {

    @InjectPresenter
    DetailPresenter presenter;

    Context myContext;

    private DetailEpisodesAdapter adapter = null;
    private LinearLayoutManager manager;
    private RecyclerView episodeRecyclerView;
    private ImageView detailImage;
    private TextView detailName, detailStatus, detailSpecies, detailGender,
            detailType, detailOrigin, detailLocation;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acrivity_detail);

        myContext = this;

        detailImage = (ImageView) findViewById(R.id.detail_image);
        detailName = (TextView) findViewById(R.id.detail_name);
        detailOrigin = (TextView) findViewById(R.id.detail_origin);
        detailLocation = (TextView) findViewById(R.id.detail_location);
        detailStatus = (TextView) findViewById(R.id.detail_status);
        detailSpecies = (TextView) findViewById(R.id.detail_species);
        detailGender = (TextView) findViewById(R.id.detail_gender);
        detailType = (TextView) findViewById(R.id.detail_type);

        episodeRecyclerView = (RecyclerView) findViewById(R.id.detail_episodes);
        manager = new LinearLayoutManager(this);
        episodeRecyclerView.setLayoutManager(manager);
    }

    @Override
    public void showDetail(DetailCharacter detailCharacter) {
        Picasso.with(this).load(detailCharacter.getImage()).into(detailImage);

        detailName.append(detailCharacter.getName());
        detailOrigin.append(detailCharacter.getOrigin().getName());
        detailLocation.append(detailCharacter.getOrigin().getName());
        detailStatus.setText(detailCharacter.getStatus());
        detailSpecies.setText(detailCharacter.getSpecies());
        detailGender.setText(detailCharacter.getGender());
        detailType.setText(detailCharacter.getType());
    }

    @Override
    public void setEpisodeAdapter(List<EpisodeItem> episodes) {
        if (adapter == null){
            adapter = new DetailEpisodesAdapter(this, episodes);
            episodeRecyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void startOriginActivity(String id) {
        detailOrigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailLocationPresenter.start(myContext, id);
            }
        });
    }

    @Override
    public void startLocationActivity(String id) {
        detailLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailLocationPresenter.start(myContext, id);
            }
        });
    }
}
