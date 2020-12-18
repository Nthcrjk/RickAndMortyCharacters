package com.example.rickandmortycharacters.adapter.diffutil;

import androidx.recyclerview.widget.DiffUtil;

import com.example.rickandmortycharacters.model.retrofit.model.CharacterList.CharacterResults;

import java.util.List;

public class CharacterDiffUtilCallBack extends DiffUtil.Callback {

    private List<CharacterResults> oldList;
    private List<CharacterResults> newList;

    public CharacterDiffUtilCallBack(List<CharacterResults> oldList, List<CharacterResults> newList){
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return oldList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getId().equals(newList.get(newItemPosition).getId());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getName().equals(newList.get(newItemPosition).getName()) &&
                oldList.get(oldItemPosition).getStatus().equals(newList.get(newItemPosition).getStatus()) &&
                oldList.get(oldItemPosition).getOrigin().getName().equals(newList.get(newItemPosition).getOrigin().getName());
    }
}
