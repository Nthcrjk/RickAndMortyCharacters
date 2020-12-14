package com.example.rickandmortycharacters.model.adapter;

public class CharacterState {
    private String image;
    private String name;
    private String originName;

    public CharacterState(String image, String name, String originName) {
        this.image = image;
        this.name = name;
        this.originName = originName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }
}
