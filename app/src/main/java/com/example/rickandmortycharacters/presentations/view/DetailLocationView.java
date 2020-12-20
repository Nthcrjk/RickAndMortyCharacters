package com.example.rickandmortycharacters.presentations.view;

import com.example.rickandmortycharacters.model.retrofit.model.CharacterList.CharacterResults;
import com.example.rickandmortycharacters.model.retrofit.model.DetailLocation.DetailLocation;

import java.util.List;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;


@StateStrategyType(AddToEndSingleStrategy.class)
public interface DetailLocationView extends MvpView {

    void showLocation(DetailLocation detailLocation);

    void setCharacterAdapter(List<CharacterResults> characterResults);
}
