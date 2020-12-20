package com.example.rickandmortycharacters.presentations.view;

import com.example.rickandmortycharacters.model.retrofit.model.CharacterList.CharacterResults;
import com.example.rickandmortycharacters.model.retrofit.model.DetailEpisode.DetailEpisode;

import java.util.List;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface DetailEpisodeView extends MvpView {

    void showDetailEpisode(DetailEpisode detailEpisode);

    void setCharacterAdapter(List<CharacterResults> characterResults);
}
