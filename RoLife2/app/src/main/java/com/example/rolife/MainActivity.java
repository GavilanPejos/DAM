package com.example.rolife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Timer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intro = new Intent(this, IntroductorActivity.class);
        Intent login = new Intent(this, LoginActivity.class);
        startActivity(intro);


        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                startActivity(login);
                finish();
            }
        }, 3000);


    }


}