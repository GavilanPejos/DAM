package com.example.rolife.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.rolife.R;

public class register_bar_fragment extends Fragment {
EditText etUserName,etPassword,etEmail,etConfirmPass;
Button btnConfirm,btnBack;

    public register_bar_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.register_bar_fragment,container,false);

        etUserName= v.findViewById(R.id.registerfrag_ETuser);
        etPassword=v.findViewById(R.id.registerfrag_ETPassword);
        etEmail=v.findViewById(R.id.registerfrag_ETemail);
        etConfirmPass=v.findViewById(R.id.registerfrag_ETConfirmPassword);

        btnConfirm=v.findViewById(R.id.registerfrag_BTNRegister);
        btnBack=v.findViewById(R.id.registerfrag_BTNBack);


        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return v;
    }
}

