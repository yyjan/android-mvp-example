package com.example.yun.androidmvpexample.main;

import com.example.yun.androidmvpexample.main.adapter.AdapterContract;
import com.example.yun.androidmvpexample.data.Document;
import com.example.yun.androidmvpexample.data.DocumentDataRepository;

public interface MainListContract {

    interface View {
        void showToast(String title);

        void showMessage(int itemCount);

        void showItemDetail(Document document);

        void scrollToBottom();
    }

    interface Presenter {
        void loadItems();

        void addNewItem(int itemCount);

        void onAttach(View view);

        void onDetach();

        void onItemClick(Document document);

        void setAdapterModel(AdapterContract.Model adapterModel);

        void setAdapterView(AdapterContract.View adapterView);

        void setSampleData(DocumentDataRepository sampleData);
    }
}
