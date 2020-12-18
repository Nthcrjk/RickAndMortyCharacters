package com.example.rickandmortycharacters.model.retrofit.model.CharacterInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {
    @SerializedName("pages")
    @Expose
    private Integer pages;

    public Integer getPages() {
        return pages;
    }
}
