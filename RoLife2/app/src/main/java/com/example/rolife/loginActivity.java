package com.example.rolife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.rolife.fragments.interfaceFragments;
import com.example.rolife.fragments.loginACTForget_Fragment;
import com.example.rolife.fragments.loginACTLogin_Fragment;
import com.example.rolife.fragments.loginACTRegister_Fragment;

public class LoginActivity extends AppCompatActivity implements interfaceFragments {
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
        loginACTLogin_Fragment fragment = new loginACTLogin_Fragment();
        fragment.setCallBackFragment(this);
        fragmentManager = getSupportFragmentManager();//lo convertimos en un support de verdad
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.loginActivity_FLcontainerfragments, fragment);
        fragmentTransaction.commit();//Acción de realizar.
    }

    public void replaceFragment(String procedencia) {
        //recibo la procedencia, un string para seleccionar con mayor seguridad a donde ir
        //(más que nada por que el fragment.getId dice que puede dar fallos)
        switch (procedencia) {
            case "register":
                fragment = new loginACTRegister_Fragment();
                break;
            case "forget":
                fragment = new loginACTForget_Fragment();
                break;
            case "login":
                fragment = new loginACTLogin_Fragment();
                break;
        }
        //fragment = new loginACTRegister_Fragment();
        fragmentManager = getSupportFragmentManager();//lo convertimos en un support de verdad
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.add(R.id.loginActivity_FLcontainerfragments, fragment);
        fragmentTransaction.commit();//Acción de realizar.
    }

    @Override
    public void changeFragment(String procedencia) {

        replaceFragment(procedencia);
    }

    @Override
    public void removeFragment() {
        //getActivity().getFragmentManager().beginTransaction().remove(this).commit();
    }
}