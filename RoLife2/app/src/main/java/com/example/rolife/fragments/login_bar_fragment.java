package com.example.rolife.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import com.example.rolife.R;


public class login_bar_fragment extends Fragment {
    Button btnLogin, btnRegister, btnForget;
    EditText etUserName, etPassword;
    FragmentTransaction transaction;
    Fragment loginform, registerform, forgetform;
    FragmentManager fragmentManager;

    public login_bar_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vroot = inflater.inflate(R.layout.login_bar_fragment, container, false);

        etUserName = vroot.findViewById(R.id.loginfrag_ETuser);
        etPassword = vroot.findViewById(R.id.loginfrag_ETpass);

        btnLogin = vroot.findViewById(R.id.loginfrag_BTNlogin);
        btnRegister = vroot.findViewById(R.id.loginfrag_BTNregister);
        btnForget = vroot.findViewById(R.id.loginfrag_BTNforgetpass);



        transaction = fragmentManager.beginTransaction();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etUserName.getText();
                etPassword.getText();
                if (etUserName.getText().equals("Federico") && etPassword.getText().equals("123")) {
                    transaction.replace(R.id.loginActivity_FLcontainerfragments, registerform).commit();

                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.replace(R.id.loginActivity_FLcontainerfragments, registerform).commit();
            }
        });

        btnForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.replace(R.id.loginActivity_FLcontainerfragments, forgetform).commit();
            }
        });
        return vroot;

    }


}