package com.example.yun.androidmvpexample.main;

import com.example.yun.androidmvpexample.data.source.GetDataCallback;
import com.example.yun.androidmvpexample.main.adapter.AdapterContract;
import com.example.yun.androidmvpexample.data.Document;
import com.example.yun.androidmvpexample.data.source.DocumentDataRepository;

import java.util.List;

public class MainListPresenter implements MainListContract.Presenter {

    private MainListContract.View view;

    private DocumentDataRepository sampleData;
    private AdapterContract.View adapterView;
    private AdapterContract.Model adapterModel;

    @Override
    public void loadItems() {
        sampleData.getDocuments(new GetDataCallback() {
            @Override
            public void onDocumentsLoaded(List<Document> documents) {
                adapterModel.loadItems(documents);
                adapterView.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void addNewItem(int itemCount) {
        //TODO : add item
        //adapterModel.addItem(sampleData.newItem(itemCount));
        adapterView.notifyDataSetChanged();

        view.showMessage(itemCount + 1);
        view.scrollToBottom();
    }

    @Override

    public void onItemClick(int position) {
        view.showItemDetail(position);
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
