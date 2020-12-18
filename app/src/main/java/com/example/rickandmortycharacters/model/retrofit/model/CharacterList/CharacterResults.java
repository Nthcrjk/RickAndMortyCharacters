package com.example.rickandmortycharacters.model.retrofit.model.CharacterList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CharacterResults {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("origin")
    @Expose
    private CharacterLocation origin;

    @SerializedName("image")
    @Expose
    private String image;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public CharacterLocation getOrigin() {
        return origin;
    }

    public String getImage() {
        return image;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrigin(CharacterLocation origin) {
        this.origin = origin;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
