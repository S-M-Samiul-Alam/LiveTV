package com.example.citytv.Restrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit=null;
   private static String Base_Url="https://www.googleapis.com/youtube/v3/";

    public static Retrofit getRetrofit() {
        if(retrofit == null)
        {
         retrofit =new Retrofit.Builder()
                 .addConverterFactory(GsonConverterFactory.create())
                 .baseUrl(Base_Url)
                 .build();
        }
     return retrofit;
    }

}
