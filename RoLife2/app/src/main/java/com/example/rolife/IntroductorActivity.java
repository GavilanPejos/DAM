package com.example.rolife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;

import java.util.ArrayList;

public class IntroductorActivity extends AppCompatActivity {

    ImageView logo_simbolo, logo_texto, fondo_mazmorra;
    LottieAnimationView animacion_introductor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductor);


        //Imagenes del introductor
        logo_simbolo = findViewById(R.id.logo_rojo);
        logo_texto = findViewById(R.id.nombre_app);
        fondo_mazmorra = findViewById(R.id.fondo_dungeon);
        //Animación del introductor
        animacion_introductor = findViewById(R.id.lottie_levelup);

        //animate() para dar animaciones, scale aumenta, alpha desvanece, luego lo que dura la animación y por ultimo cuando empieza
        logo_simbolo.animate().scaleX(50).setDuration(1000).setStartDelay(1000);
        logo_simbolo.animate().scaleY(50).setDuration(1000).setStartDelay(1000);
        logo_texto.animate().alpha(0f).setDuration(1200).setListener(null);
        fondo_mazmorra.animate().alpha(0f).setDuration(1800).setStartDelay(1100);
        animacion_introductor.animate().translationY(1400).setDuration(300).setStartDelay(1000);
        logo_simbolo.animate().alpha(0f).setDuration(1800).setStartDelay(1100);



    }




}