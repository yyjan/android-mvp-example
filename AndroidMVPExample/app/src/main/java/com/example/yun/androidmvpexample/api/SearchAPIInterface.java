package com.example.yun.androidmvpexample.api;

import com.example.yun.androidmvpexample.data.SearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchAPIInterface {
    @GET("v2/search/book?")
    Call<SearchResponse> doGetSearchImageList(@Query("query") String query, @Query("size") int size);

}
