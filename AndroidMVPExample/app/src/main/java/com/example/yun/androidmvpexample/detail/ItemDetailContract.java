package com.example.yun.androidmvpexample.detail;

import com.example.yun.androidmvpexample.data.Document;

public interface ItemDetailContract {

    interface View {
        void showTitle(String title);
    }

    interface Presenter {
        void onAttach(View view);

        void onDetach();

        void loadItems(Document document);
    }
}
