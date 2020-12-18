package com.example.rickandmortycharacters.presentations.view;

import com.example.rickandmortycharacters.model.retrofit.model.Detail.DetailCharacter;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface DetailView extends MvpView {

    void showDetail(DetailCharacter detailCharacter);
}
