package com.example.android_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.e("hello", String.valueOf(thread.getState()));
                //thread.start();

                startService(new Intent(MainActivity.this,MainService.class));
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //thread.interrupt();
                //Log.e("hello", String.valueOf(thread.getState()));

                stopService(new Intent(MainActivity.this,MainService.class));

            }
        });
    }


}