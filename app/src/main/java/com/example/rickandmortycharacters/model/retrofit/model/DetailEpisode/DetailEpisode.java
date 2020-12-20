package com.example.rickandmortycharacters.model.retrofit.model.DetailEpisode;

import com.example.rickandmortycharacters.model.retrofit.model.EpisodItem.EpisodeItem;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailEpisode extends EpisodeItem {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("characters")
    private List<String> characters;

    public String getName() {
        return name;
    }

    public List<String> getCharacters() {
        return characters;
    }
}
