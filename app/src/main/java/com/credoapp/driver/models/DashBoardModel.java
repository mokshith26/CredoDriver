package com.credoapp.driver.models;

public class DashBoardModel {


    private String textView;
    private int images;



    public DashBoardModel(String s, int images) {
        this.textView = s;
        this.images = images;

    }

    public String getTextView() {
        return textView;
    }

    public void setTextView(String textView) {
        this.textView = textView;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }



}
