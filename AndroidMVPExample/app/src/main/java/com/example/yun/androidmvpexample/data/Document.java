package com.example.yun.androidmvpexample.data;

import java.io.Serializable;

public class Document implements Serializable {
    private String title;
    private String contents;
    private String url;
    private String thumbnail;

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getUrl() {
        return url;
    }
}
