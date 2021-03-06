package com.example.yun.androidmvpexample.detail;

import com.example.yun.androidmvpexample.data.Document;

import java.util.List;

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
    public void loadCurrentItem(List<Document> items, int position) {
        Document item = items.get(position);
        view.showTitle(item.getTitle());
        view.showDescription(position);
    }
}
