package com.example.rickandmortycharacters.presentations.presenter;

import com.example.rickandmortycharacters.model.retrofit.service.Service;
import com.example.rickandmortycharacters.presentations.view.MainView;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    public MainPresenter(){

        Service service = new Service();
    }
}
