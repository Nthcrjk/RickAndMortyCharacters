package com.example.rickandmortycharacters.model.retrofit.model.Detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailCharacter {

    @SerializedName("info")
    @Expose
    private Info info;

    @SerializedName("results")
    @Expose
    private List<Results> results = null;

    public Info getInfo() {
        return info;
    }

    public List<Results> getResults() {
        return results;
    }

}

