package com.example.rickandmortycharacters.model.retrofit.model.EpisodItem;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EpisodeItem {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("air_date")
    @Expose
    private String air_date;

    @SerializedName("episode")
    @Expose
    private String episode;

    public int getId() {
        return id;
    }

    public String getAir_date() {
        return air_date;
    }

    public String getEpisode() {
        return episode;
    }
}
