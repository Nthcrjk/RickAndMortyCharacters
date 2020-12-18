package com.example.rickandmortycharacters.presentations.presenter;

import android.os.AsyncTask;
import android.util.Log;

import com.example.rickandmortycharacters.model.retrofit.api.JsonApi;
import com.example.rickandmortycharacters.model.retrofit.model.CharacterList.CharacterList;
import com.example.rickandmortycharacters.model.retrofit.model.CharacterList.CharacterResults;
import com.example.rickandmortycharacters.model.retrofit.service.Service;
import com.example.rickandmortycharacters.presentations.view.MainView;

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
public class MainPresenter extends MvpPresenter<MainView> {

    private JsonApi api;

    private int numberOfNextPage = 0;
    public MainPresenter(){

        Service service = new Service();

        api = service.getApi();

        List<CharacterResults> results = new ArrayList<>();

        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                /*
                Observable<CharacterList> obs = api.getCharacterList(1)
                        .mergeWith(api.getCharacterList(2));

                 */
                Observable<CharacterList> mainObs = api.getCharacterList(1);

                for (int i = 2; i <= 34; i++){
                    mainObs = mainObs.mergeWith(api.getCharacterList(i));
                }

                mainObs.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<CharacterList>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

                            }

                            @Override
                            public void onNext(@NonNull CharacterList characterList) {
                                results.addAll(characterList.getResults());
                                Log.e("meow", "1");
                                Log.e("meow", characterList.getResults().get(0).getName());
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }

                            @Override
                            public void onComplete() {
                                //numberOfNextPage++;
                                getViewState().setAdapter(results);

                            }
                        });

                return null;
            }
        }.execute();

    }
}
