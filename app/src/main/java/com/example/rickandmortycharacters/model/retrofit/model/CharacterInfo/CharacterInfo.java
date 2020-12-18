package com.example.rickandmortycharacters.model.retrofit.model.CharacterInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CharacterInfo {
    @SerializedName("info")
    @Expose
    private Info info;

    public Info getInfo() {
        return info;
    }
}
