package com.example.rickandmortycharacters.model.retrofit.model.CharacterList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CharacterList {
    @SerializedName("results")
    @Expose
    private List<CharacterResults> results = null;

    public List<CharacterResults> getResults() {
        return results;
    }

}
