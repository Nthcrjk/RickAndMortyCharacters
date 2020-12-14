package com.example.rickandmortycharacters.model.retrofit.model.Detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {
    @SerializedName("count")
    @Expose
    private Integer count;

    @SerializedName("pages")
    @Expose
    private Integer pages;

    @SerializedName("next")
    @Expose
    private String next;

    @SerializedName("prev")
    @Expose
    private Object prev;

    public Integer getCount() {
        return count;
    }

    public Integer getPages() {
        return pages;
    }

    public String getNext() {
        return next;
    }

    public Object getPrev() {
        return prev;
    }
}
