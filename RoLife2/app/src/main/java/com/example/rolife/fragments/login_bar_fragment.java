package com.example.rolife.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.rolife.R;


public class login_bar_fragment extends Fragment {
    Button btnLogin, btnRegister, btnForget;
    EditText etUserName, etPassword;
    callBackFragment callBackFragment;
    String userName, userPass;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    /*FragmentTransaction transaction;
    Fragment loginform, registerform, forgetform;
    FragmentManager fragmentManager;*/

    @Override
    public void onAttach(Context context) {
        sharedPreferences = context.getSharedPreferences("usersValues", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vroot = inflater.inflate(R.layout.login_bar_fragment, container, false);
        //EDITTEXT IDENTIFICADOS
        etUserName = vroot.findViewById(R.id.loginfrag_ETuser);
        etPassword = vroot.findViewById(R.id.loginfrag_ETpass);
        //BOTONES IDENTIFICADOS
        btnLogin = vroot.findViewById(R.id.loginfrag_BTNlogin);
        btnRegister = vroot.findViewById(R.id.loginfrag_BTNregister);

        //ACCIONES BOTONILES
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Login
                userName = etUserName.getText().toString();
                userPass = etPassword.getText().toString();

                String uName, uPass;
                uName = sharedPreferences.getString("userName", null);
                uPass = sharedPreferences.getString("userPass", null);

                if (userName.equals(uName) && userPass.equals(uPass)) {
                    Toast.makeText(getContext(), "Login", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "No Login", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Registro
                if (callBackFragment != null) {
                    callBackFragment.changeFragment();
                }
            }
        });

        return vroot;

    }

    public void setCallBackFragment(callBackFragment callBackFragment) {
        this.callBackFragment = callBackFragment;
    }
}