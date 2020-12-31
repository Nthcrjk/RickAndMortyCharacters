package com.example.rickandmortycharacters.presentations.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.example.rickandmortycharacters.model.retrofit.api.JsonApi;
import com.example.rickandmortycharacters.model.retrofit.model.Detail.DetailCharacter;
import com.example.rickandmortycharacters.model.retrofit.model.EpisodItem.EpisodeItem;
import com.example.rickandmortycharacters.model.retrofit.service.Service;
import com.example.rickandmortycharacters.presentations.view.DetailView;
import com.example.rickandmortycharacters.ui.activity.DetailActivity;

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
public class DetailPresenter extends MvpPresenter<DetailView> {

    private static final String MAIN_EXTRA = "EXTRA_MY_ID";

    private static Intent myIntent;

    private JsonApi api;

    List<EpisodeItem> episodeItems;

    public DetailPresenter(){
        Service service = new Service();
        api = service.getApi();

        episodeItems = new ArrayList<>();

        Log.e("CharacterId", myIntent.getStringExtra(MAIN_EXTRA));
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                Observable<DetailCharacter> observable = api.getDetailCharacterById(myIntent.getStringExtra(MAIN_EXTRA));
                observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<DetailCharacter>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

                            }
                            @Override
                            public void onNext(@NonNull DetailCharacter detailCharacter) {
                                //Вытаскиваю ссылку удаляю из нее #deleteString, остается id - те номер страницы с location, на его основе создаю Observable
                                String deleteString = "https://rickandmortyapi.com/api/location/";
                                String id;

                                id = detailCharacter.getOrigin().getUrl().replace(deleteString, "");
                                getViewState().startOriginActivity(id);

                                id = detailCharacter.getLocation().getUrl().replace(deleteString, "");
                                getViewState().startLocationActivity(id);


                                //То же самое, что и с  "https://rickandmortyapi.com/api/location/" вытаскиваю из строки id
                                Observable<EpisodeItem> episodeItemObservable = null;
                                deleteString = "https://rickandmortyapi.com/api/episode/";
                                String episodeIdTemp = "";

                                //В этом цикле объединяю все observable
                                for (int i = 0; i < detailCharacter.getEpisode().size(); i++){
                                    episodeIdTemp = detailCharacter.getEpisode().get(i);
                                    episodeIdTemp = episodeIdTemp.replace(deleteString, "");

                                    if (episodeItemObservable == null){
                                        episodeItemObservable = api.getEpisodeById(episodeIdTemp);
                                    } else {
                                        episodeItemObservable = episodeItemObservable.mergeWith(api.getEpisodeById(episodeIdTemp));
                                    }
                                }
                                episodeItemObservable.subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(new Observer<EpisodeItem>() {
                                            @Override
                                            public void onSubscribe(@NonNull Disposable d) {

                                            }

                                            @Override
                                            public void onNext(@NonNull EpisodeItem episodeItem) {
                                                Log.e("Episode ", "Episode: " + episodeItem.getEpisode());
                                                //Складываю в список все эпизоды
                                                episodeItems.add(episodeItem);
                                            }

                                            @Override
                                            public void onError(@NonNull Throwable e) {

                                            }

                                            @Override
                                            public void onComplete() {
                                                //Список закидываю в адаптер
                                                getViewState().setEpisodeAdapter(episodeItems);
                                            }
                                        });
                                //Информацию о персонаже закидываю вывожу на экран
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

    public List<EpisodeItem> getEpisodeItems(){
        return episodeItems;
    }

    public static void start(Context caller, String chatacterId){
        myIntent = new Intent(caller, DetailActivity.class);
        myIntent.putExtra(MAIN_EXTRA, chatacterId);
        caller.startActivity(myIntent);
    }
}
