package com.example.helloworld.model;

public class ListItem extends DataItem {

    public ListItem(String caption, int imageResource) {
        this.caption = caption;
        this.imageResource = imageResource;
    }

    String caption;

    int imageResource;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
