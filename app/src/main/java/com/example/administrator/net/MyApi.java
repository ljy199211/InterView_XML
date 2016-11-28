package com.example.administrator.net;

import com.example.administrator.result.SearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ${ljy} on 2016/11/14.
 */

public interface MyApi {
    @GET("environment/air/cityair")
    Call<SearchResult> getAir(@Query("city") String city, @Query("key") String key);
}
