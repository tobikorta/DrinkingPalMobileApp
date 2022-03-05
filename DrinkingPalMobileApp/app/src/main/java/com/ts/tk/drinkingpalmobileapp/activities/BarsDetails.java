package com.ts.tk.drinkingpalmobileapp.activities;

import androidx.recyclerview.selection.ItemDetailsLookup;

public class BarsDetails extends ItemDetailsLookup.ItemDetails<String> {

    private int position;
    private String selectionKey;

    public BarsDetails(int position, String selectionKey){
        this.position = position;
        this.selectionKey = selectionKey;
    }

    @Override
    public int getPosition(){
        return position;
    }

    @Override
    public String getSelectionKey(){
        return selectionKey;
    }
}
