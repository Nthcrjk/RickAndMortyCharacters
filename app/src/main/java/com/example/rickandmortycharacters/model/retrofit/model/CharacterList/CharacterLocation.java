package com.example.rickandmortycharacters.model.retrofit.model.CharacterList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CharacterLocation {
    @SerializedName("name")
    @Expose
    private String name;

    public String getName() {
        return name;
    }
}
