package com.example.yun.androidmvpexample.main;

import com.example.yun.androidmvpexample.main.adapter.AdapterContract;
import com.example.yun.androidmvpexample.data.source.DocumentDataRepository;

public interface MainListContract {

    interface View {
        void showMessage(int itemCount);

        void showItemDetail(int position);

        void scrollToBottom();
    }

    interface Presenter {
        void loadItems();

        void addNewItem(int itemCount);

        void onAttach(View view);

        void onDetach();

        void onItemClick(int position);

        void setAdapterModel(AdapterContract.Model adapterModel);

        void setAdapterView(AdapterContract.View adapterView);

        void setSampleData(DocumentDataRepository sampleData);
    }
}
