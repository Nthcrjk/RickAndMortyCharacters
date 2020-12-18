package com.example.rickandmortycharacters.presentations.presenter;

import android.os.AsyncTask;
import android.util.Log;

import com.example.rickandmortycharacters.model.retrofit.api.JsonApi;
import com.example.rickandmortycharacters.model.retrofit.model.CharacterList.CharacterList;
import com.example.rickandmortycharacters.model.retrofit.model.CharacterList.CharacterResults;
import com.example.rickandmortycharacters.model.retrofit.service.Service;
import com.example.rickandmortycharacters.presentations.view.MainView;

import java.io.IOException;
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
import retrofit2.Call;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private JsonApi api;

    private List<List<CharacterResults>> loadlist;

    public MainPresenter(){

        Service service = new Service();
        api = service.getApi();
        loadlist = new ArrayList<>();

        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                int countOfPages = 0;
                Call<CharacterList> infoOfPages = api.getInfo(1);
                try {
                    countOfPages = infoOfPages.execute().body().getInfo().getPages();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Log.e("meow", Integer.toString(countOfPages));

                Observable<CharacterList> startObs = api.getCharacterList(1);

                Observable<CharacterList> mainObs = api.getCharacterList(2);
                for (int i = 3; i <= countOfPages; i++){
                    mainObs = mainObs.mergeWith(api.getCharacterList(i));
                }

                startObs.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<CharacterList>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

                            }

                            @Override
                            public void onNext(@NonNull CharacterList characterList) {
                                Log.e("meow", "1");
                                Log.e("meow", characterList.getResults().get(0).getName());
                                getViewState().setAdapter(characterList.getResults());
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });

                mainObs.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<CharacterList>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

                            }

                            @Override
                            public void onNext(@NonNull CharacterList characterList) {
                                loadlist.add(characterList.getResults());
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

    public List<List<CharacterResults>> getLoadList(){
        return loadlist;
    }
}
