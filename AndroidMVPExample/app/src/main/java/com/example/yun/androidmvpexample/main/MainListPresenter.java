package com.example.yun.androidmvpexample.main;

import com.example.yun.androidmvpexample.main.adapter.AdapterContract;
import com.example.yun.androidmvpexample.data.Document;
import com.example.yun.androidmvpexample.data.DocumentDataRepository;

import java.util.List;

public class MainListPresenter implements MainListContract.Presenter {

    private MainListContract.View view;

    private DocumentDataRepository sampleData;
    private AdapterContract.View adapterView;
    private AdapterContract.Model adapterModel;

    @Override
    public void loadItems() {
        List<Document> items = sampleData.getItems(30);
        adapterModel.loadItems(items);
        adapterView.notifyDataSetChanged();
    }

    @Override
    public void addNewItem(int itemCount) {
        adapterModel.addItem(sampleData.newItem(itemCount));
        adapterView.notifyDataSetChanged();

        view.showMessage(itemCount + 1);
        view.scrollToBottom();
    }

    @Override

    public void onItemClick(Document document) {
        String title = document.getTitle();
        view.showToast(title);
        view.showItemDetail(document);
    }

    @Override
    public void setAdapterModel(AdapterContract.Model adapterModel) {
        this.adapterModel = adapterModel;
    }

    @Override
    public void setAdapterView(AdapterContract.View adapterView) {
        this.adapterView = adapterView;
    }

    @Override
    public void setSampleData(DocumentDataRepository sampleData) {
        this.sampleData = sampleData;
    }

    @Override
    public void onAttach(MainListContract.View view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        view = null;
    }
}
