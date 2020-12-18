package com.example.rickandmortycharacters.presentations.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.example.rickandmortycharacters.model.retrofit.api.JsonApi;
import com.example.rickandmortycharacters.model.retrofit.model.Detail.DetailCharacter;
import com.example.rickandmortycharacters.model.retrofit.service.Service;
import com.example.rickandmortycharacters.presentations.view.DetailView;
import com.example.rickandmortycharacters.ui.activity.DetailActivity;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class DetailPresenter extends MvpPresenter<DetailView> {

    private static final String EXTRA = "EXTRA_ID";
    static Intent intent;
    private JsonApi api;

    public DetailPresenter(){
        Service service = new Service();
        api = service.getApi();

        Log.e("gaf", "dsds");
        Log.e("gaf", intent.getStringExtra(EXTRA));
        new AsyncTask<Void, Void, Void>(){


            @Override
            protected Void doInBackground(Void... voids) {
                Observable<DetailCharacter> observable = api.getCharacterById(intent.getStringExtra(EXTRA));
                observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<DetailCharacter>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

                            }

                            @Override
                            public void onNext(@NonNull DetailCharacter detailCharacter) {
                                getViewState().showDetail(detailCharacter);
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
                return null;
            }
        }.execute();
    }

    public static void start(Context caller, String chatacterId){
        intent = new Intent(caller, DetailActivity.class);
        intent.putExtra(EXTRA, chatacterId);
        caller.startActivity(intent);
    }
}
