package com.example.rickandmortycharacters.presentations.presenter;

import android.os.AsyncTask;

import com.example.rickandmortycharacters.model.retrofit.api.JsonApi;
import com.example.rickandmortycharacters.model.retrofit.model.CharacterList.CharacterList;
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


    private int numberOfNextPage = 1;
    public MainPresenter(){

        Service service = new Service();
        api = service.getApi();

        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                Observable<CharacterList> obs = api.getCharacterList(1);

                obs.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<CharacterList>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

                            }

                            @Override
                            public void onNext(@NonNull CharacterList characterList) {
                                getViewState().setAdapter(characterList.getResults());
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }

                            @Override
                            public void onComplete() {
                                numberOfNextPage++;
                            }
                        });

                return null;
            }
        }.execute();

    }
}
