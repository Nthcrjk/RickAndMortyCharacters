package com.example.rickandmortycharacters.model.retrofit.model.Detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailResults {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("species")
    @Expose
    private String species;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("origin")
    @Expose
    private DetailLocation origin;

    @SerializedName("location")
    @Expose
    private DetailLocation location;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("episode")
    @Expose
    private List<String> episode = null;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("created")
    @Expose
    private String created;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getSpecies() {
        return species;
    }

    public String getType() {
        return type;
    }

    public String getGender() {
        return gender;
    }

    public DetailLocation getOrigin() {
        return origin;
    }

    public DetailLocation getLocation() {
        return location;
    }

    public String getImage() {
        return image;
    }

    public List<String> getEpisode() {
        return episode;
    }

    public String getUrl() {
        return url;
    }

    public String getCreated() {
        return created;
    }
}
