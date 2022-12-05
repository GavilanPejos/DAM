package com.example.rolife.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.rolife.MenuActivity;
import com.example.rolife.R;


public class loginACTLogin_Fragment extends Fragment {

    Button btnLogin, btnRegister, btnForget;
    EditText etUserName, etPassword;
    interfaceFragments interfaceFragments;
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
        btnForget = vroot.findViewById(R.id.loginfrag_BTNforgetpass);
        //ACCIONES BOTONILES
        btnLogin.setOnClickListener(new View.OnClickListener() { //Comprobación de acción logearse
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
                    //llamar a una nueva actividad
                    setCallActivity();

                } else {
                    Toast.makeText(getContext(), "No Login", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Registro
                if (interfaceFragments != null) {
                    String procedencia = "register";
                    interfaceFragments.changeFragment(procedencia);
                }
            }
        });//Registro de nuevo usuario (almacenado)

        btnForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Olvidaste la constraseña?
                if (interfaceFragments != null) {
                    String procedencia = "forget";
                    interfaceFragments.changeFragment(procedencia);
                }
            }
        }); // Olvidaste la constraseña

        return vroot;

    }

    public void setCallBackFragment(interfaceFragments interfaceFragments) {
        this.interfaceFragments = interfaceFragments;
    }

    public void setCallActivity() {
        Intent inicio = new Intent(getActivity(), MenuActivity.class);
        startActivity(inicio);
    }
}