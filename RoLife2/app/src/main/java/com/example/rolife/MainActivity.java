package com.example.rolife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Timer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reproducir();
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
        }, 3100);


    }

    //Voy a añadir una cancioncilla de inicio
    private MediaPlayer mediaPlayer;

    public void reproducir() {
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.intro_music);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();
    }

}