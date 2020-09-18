package com.example.helloworld.model;

import java.util.List;

public class HorizontalListParent extends DataItem {

List<ListItem> data;

    public HorizontalListParent(List<ListItem> data) {
        this.data = data;
    }

    public List<ListItem> getData() {
        return data;
    }

    public void setData(List<ListItem> data) {
        this.data = data;
    }
}

