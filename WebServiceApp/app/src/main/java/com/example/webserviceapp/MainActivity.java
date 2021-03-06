package com.example.webserviceapp;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{

    /*
    primo pulsante: sync con la progress bar
    secondo pulsante: dowloand img da internet e show sotto il pulsante
    terzo pulsante: utilizzo di retrofit con i metodi rest
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setto la view
        Button buttonProgress = findViewById(R.id.buttonProgress);
        Button buttonImage = findViewById(R.id.buttonImage);
        Button buttonRetrofit = findViewById(R.id.buttonRetrofit);
        TextView textView = findViewById(R.id.textView);
        ImageView imageView = findViewById(R.id.imageView);
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(100);

        AsyncTaskApp app = new AsyncTaskApp();

        WebInterface apiService = app.retrofit.create(WebInterface.class);

        buttonProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               new ProgressAsyncTask(progressDialog).execute();
            }
        });

        buttonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlImgS = "https://www.altoadige.it/image/contentid/policy:1.2988296:1630949993/image.jpg?f=3x2&w=627&$p$f$w=6b4c25b";
                new AnimalDownloadImage(imageView).execute(urlImgS);
            }
        });

        buttonRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<AnimalStatus> call = apiService.getStatus();//GET http://api.myservice.com/users/antolezzi
                call.enqueue(new Callback<AnimalStatus>() {
                    @Override
                    public void onResponse(Call<AnimalStatus> call, Response<AnimalStatus> response) {
                        int statusCode = response.code();
                        AnimalStatus wm = response.body();

                        textView.setText(wm.status);
                    }

                    @Override
                    public void onFailure(Call<AnimalStatus> call, Throwable t) {
                    }
                });
            }
        });
    }
}