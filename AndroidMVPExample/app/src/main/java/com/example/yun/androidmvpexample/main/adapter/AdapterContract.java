package com.example.yun.androidmvpexample.main.adapter;

import com.example.yun.androidmvpexample.data.Document;

import java.util.List;

public interface AdapterContract {

    interface View {
        void notifyDataSetChanged();
    }

    interface Model {
        void loadItems(List<Document> items);

        void addItem(Document item);
    }
}
