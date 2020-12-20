package com.example.rickandmortycharacters.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rickandmortycharacters.R;
import com.example.rickandmortycharacters.adapter.adapter.DetailEpisodesAdapter;
import com.example.rickandmortycharacters.model.retrofit.api.JsonApi;
import com.example.rickandmortycharacters.model.retrofit.model.Detail.DetailCharacter;
import com.example.rickandmortycharacters.model.retrofit.model.EpisodItem.EpisodeItem;
import com.example.rickandmortycharacters.model.retrofit.service.Service;
import com.example.rickandmortycharacters.presentations.presenter.DetailPresenter;
import com.example.rickandmortycharacters.presentations.view.DetailView;
import com.squareup.picasso.Picasso;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class DetailActivity extends MvpAppCompatActivity implements DetailView {

    @InjectPresenter
    DetailPresenter presenter;

    private static final String EXTRA = "ID_EXTRA";

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
        Log.e("gaf", "meow " + episodes.get(0).getEpisode());
        if (adapter == null){
            adapter = new DetailEpisodesAdapter(this, episodes);
            episodeRecyclerView.setAdapter(adapter);
        }
    }
}
