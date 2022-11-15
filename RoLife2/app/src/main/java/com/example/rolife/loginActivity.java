package com.example.rolife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rolife.fragments.forget_bar_fragment;
import com.example.rolife.fragments.login_bar_fragment;
import com.example.rolife.fragments.register_bar_fragment;

public class loginActivity extends AppCompatActivity {

    FragmentTransaction transaction;
    Fragment loginform, registerform,forgetform;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Agregamos el login
        addlogin();





    }

    private void addlogin() {
        loginform = new login_bar_fragment();
        fragmentManager=getSupportFragmentManager();
        transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.loginActivity_FLcontainerfragments,loginform);
        transaction.commit();
    }



    public void logearse() {
        EditText user = findViewById(R.id.loginfrag_ETuser);
        if (user.getText().equals("Cañas")) {
            user.setText("Calvo");
        }

    }





}