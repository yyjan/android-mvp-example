package com.example.yun.androidmvpexample.detail;

import com.example.yun.androidmvpexample.data.Document;

public class ItemDetailPresenter implements ItemDetailContract.Presenter {

    private ItemDetailContract.View view;

    @Override
    public void onAttach(ItemDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        this.view = null;
    }

    @Override
    public void loadItems(Document document) {
        view.showTitle(document.getTitle());
    }
}
