package com.example.yun.androidmvpexample.data;

import java.io.Serializable;

public class Document implements Serializable {
    private int id;
    private String title;

    public Document(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public int getId() {
        return id;
    }
}
