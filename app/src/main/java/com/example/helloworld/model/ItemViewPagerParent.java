package com.example.helloworld.model;

import java.util.List;

public class ItemViewPagerParent extends DataItem {

List<ListItem> data;

    public ItemViewPagerParent(List<ListItem> mData) {
        this.data = mData;
    }

    public List<ListItem> getData() {
        return data ;
    }

    public void setData(List<ListItem> mData) {
        this.data = mData;
    }
}
