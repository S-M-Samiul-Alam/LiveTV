package com.example.citytv.Restrofit;

import com.example.citytv.Model.VideoDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {
    @GET("search")
    Call<VideoDetails> getVideoData(
            @Query("part") String part,
            @Query("channelId") String channelId,
            @Query("key") String key,
            @Query("order") String order
    );
}
