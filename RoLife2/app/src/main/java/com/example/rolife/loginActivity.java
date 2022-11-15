package com.example.rolife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginform = new login_bar_fragment();




        getSupportFragmentManager().beginTransaction().add(R.id.loginActivity_FLcontainerfragments, loginform).commit();

    }


    public void logearse() {
        EditText user = findViewById(R.id.loginfrag_ETuser);
        if (user.getText().equals("Cañas")) {
            user.setText("Calvo");
        }

    }

    public void onClick(View view) {
        transaction = getSupportFragmentManager().beginTransaction();
        if (view.getId() == R.id.loginfrag_BTNforgetpass) {
            transaction.replace(R.id.loginActivity_FLcontainerfragments, forgetform).commit();
        } else if (view.getId() == R.id.loginfrag_BTNregister) {
            transaction.replace(R.id.loginActivity_FLcontainerfragments, registerform).commit();
        } else if(view.getId()==R.id.forgetfrag_BTNbacktologin){
            transaction.replace(R.id.loginActivity_FLcontainerfragments, loginform).commit();
        }
        else {

        }


    }
}