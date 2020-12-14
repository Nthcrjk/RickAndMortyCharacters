package com.example.rickandmortycharacters.presentations.presenter;

import android.os.AsyncTask;
import android.util.Log;

import com.example.rickandmortycharacters.model.retrofit.api.JsonApi;
import com.example.rickandmortycharacters.model.retrofit.model.Character;
import com.example.rickandmortycharacters.model.retrofit.service.Service;
import com.example.rickandmortycharacters.presentations.view.MainView;


import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private JsonApi api;

    private final Disposable[] disposables;

    public MainPresenter(){
        disposables = new Disposable[1];

        Service service = new Service();
        api = service.getApi();

        Observable<Character> observable = api.getCharacters();

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Character>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposables[0] = d;
                    }

                    @Override
                    public void onNext(@NonNull Character character) {
                        Log.e("meow", character.getResults().get(0).getName());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
