package com.example.yun.androidmvpexample.data.source;

import com.example.yun.androidmvpexample.api.SearchAPIClient;
import com.example.yun.androidmvpexample.api.SearchAPIInterface;
import com.example.yun.androidmvpexample.data.SearchResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DocumentDataRepository {

    private static final int DEFAULT_SIZE = 20;
    private static final String DEFAULT_QUERY = "안드로이드";

    private SearchAPIInterface searchApiInterface;

    private DocumentDataRepository() {
        searchApiInterface = SearchAPIClient.getClient().create(SearchAPIInterface.class);
    }

    private static DocumentDataRepository documentDataRepository;

    public static DocumentDataRepository getInstance() {
        if (documentDataRepository == null) {
            documentDataRepository = new DocumentDataRepository();
        }
        return documentDataRepository;
    }

    public void getDocuments(final GetDataCallback callback) {
        Call<SearchResponse> call = searchApiInterface.doGetSearchImageList(DEFAULT_QUERY, DEFAULT_SIZE);
        call.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                callback.onDocumentsLoaded(response.body().getDocuments());
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {

            }
        });
    }
}
