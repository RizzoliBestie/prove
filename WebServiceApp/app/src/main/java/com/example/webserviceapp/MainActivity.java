package com.example.webserviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /*
    primo pulsante: sync con la progress bar
    secondo pulsante: dowloand img da internet e show sotto il pulsante
    terzo pulsante: utilizzo di retrofit con i metodi rest
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}