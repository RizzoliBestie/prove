package com.example.webserviceapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebInterface {
    @GET("/")
    Call<AnimalStatus> getStatus();
}
