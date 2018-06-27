package com.example.yun.androidmvpexample.detail;

import com.example.yun.androidmvpexample.data.Document;

import java.util.List;

public interface ItemDetailContract {

    interface View {
        void showTitle(String title);

        void showDescription(int position);
    }

    interface Presenter {
        void onAttach(View view);

        void onDetach();

        void loadCurrentItem(List<Document> items, int id);
    }
}
