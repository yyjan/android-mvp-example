package com.example.yun.androidmvpexample.data;

import java.util.List;

public class SearchResponse {
    private SearchMeta meta;
    private List<Document> documents;

    public List<Document> getDocuments() {
        return documents;
    }

}
