package com.example.yun.androidmvpexample.data.source;

import com.example.yun.androidmvpexample.data.Document;

import java.util.List;

public interface GetDataCallback {

    void onDocumentsLoaded(List<Document> documents);

}
