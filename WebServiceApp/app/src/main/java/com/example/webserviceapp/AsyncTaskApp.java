package com.example.webserviceapp;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AsyncTaskApp extends Application {
    public static final String BASE_URL="https://dog.ceo/dog-api/";
    Retrofit retrofit = null;

    public AsyncTaskApp(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
