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

import com.example.rolife.fragments.callBackFragment;
import com.example.rolife.fragments.forget_bar_fragment;
import com.example.rolife.fragments.login_bar_fragment;
import com.example.rolife.fragments.register_bar_fragment;

public class loginActivity extends AppCompatActivity implements callBackFragment {
    //El que provoca el cambio
    FragmentTransaction fragmentTransaction;
    //El cambio en si
    Fragment fragment;
    //Asistente de cambio para poder darse
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        addFragment();
    }

    //método por el cual aceptaremos nuevos fragmentos
    public void addFragment() {
        login_bar_fragment fragment = new login_bar_fragment();
        fragment.setCallBackFragment(this);
        fragmentManager = getSupportFragmentManager();//lo convertimos en un support de verdad
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.loginActivity_FLcontainerfragments, fragment);
        fragmentTransaction.commit();//Acción de realizar.
    }

    public void replaceFragment() {

        fragment = new register_bar_fragment();
        fragmentManager = getSupportFragmentManager();//lo convertimos en un support de verdad
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.add(R.id.loginActivity_FLcontainerfragments, fragment);
        fragmentTransaction.commit();//Acción de realizar.
    }

    @Override
    public void changeFragment() {
        replaceFragment();
    }
}