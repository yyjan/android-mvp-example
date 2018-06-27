package com.example.yun.androidmvpexample.data.utils;

import com.example.yun.androidmvpexample.data.Document;

import java.util.List;

public class DocumentDataUtils {

    public static int getDocumentPosition(List<Document> items, int id) {
        int position = 0;
        for (Document document : items) {
            if (id == document.getId()) {
                return position;
            }
            position++;
        }
        return position;
    }
}
