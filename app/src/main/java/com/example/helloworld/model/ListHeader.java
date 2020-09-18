package com.example.helloworld.model;

public class ListHeader extends DataItem {

    String headerText;

    public ListHeader(String headerText) {
        this.headerText = headerText;
    }

    public String getHeaderText() {
        return headerText;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }
}
