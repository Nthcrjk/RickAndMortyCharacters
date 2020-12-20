package com.example.rickandmortycharacters.presentations.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.rickandmortycharacters.R;
import com.example.rickandmortycharacters.model.retrofit.api.JsonApi;
import com.example.rickandmortycharacters.model.retrofit.model.CharacterList.CharacterResults;
import com.example.rickandmortycharacters.model.retrofit.model.DetailEpisode.DetailEpisode;
import com.example.rickandmortycharacters.model.retrofit.service.Service;
import com.example.rickandmortycharacters.presentations.view.DetailEpisodeView;
import com.example.rickandmortycharacters.ui.activity.DetailEpisodeActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class DetailEpisodePresenter extends MvpPresenter<DetailEpisodeView> {

    private static final String EXTRA = "EXTRA_ID";
    private static Intent intent;

    JsonApi api;
    List<CharacterResults> loadList;

    public DetailEpisodePresenter(){
        Service service = new Service();
        api = service.getApi();

        loadList = new ArrayList<>();
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                Observable<DetailEpisode> mainObs = api.getDetailEpisodeById(intent.getStringExtra(EXTRA));
                mainObs.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<DetailEpisode>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

                            }

                            @Override
                            public void onNext(@NonNull DetailEpisode detailEpisode) {
                                getViewState().showDetailEpisode(detailEpisode);

                                String deleteString = "https://rickandmortyapi.com/api/character/";
                                String tempId;

                                Observable<CharacterResults> mainObs = null;

                                for (int i = 0; i < detailEpisode.getCharacters().size(); i++){
                                    tempId = detailEpisode.getCharacters().get(i).replace(deleteString, "");
                                    if (mainObs == null){
                                        mainObs = api.getCharacterListById(tempId);
                                    } else {
                                        mainObs = mainObs.mergeWith(api.getCharacterListById(tempId));
                                    }
                                }

                                mainObs.subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(new Observer<CharacterResults>() {
                                            @Override
                                            public void onSubscribe(@NonNull Disposable d) {

                                            }

                                            @Override
                                            public void onNext(@NonNull CharacterResults characterResults) {
                                                loadList.add(characterResults);
                                            }

                                            @Override
                                            public void onError(@NonNull Throwable e) {

                                            }

                                            @Override
                                            public void onComplete() {
                                                getViewState().setCharacterAdapter(loadList);
                                            }
                                        });
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

    public static void start(Context caller, String id){
        intent = new Intent(caller, DetailEpisodeActivity.class);
        intent.putExtra(EXTRA, id);
        caller.startActivity(intent);
    }

}
