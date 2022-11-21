package com.example.rolife.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.rolife.R;

public class loginACTRegister_Fragment extends Fragment implements interfaceFragments {
    EditText etUserName, etPassword, etEmail, etConfirmPass;
    Button btnConfirm, btnBack;
    String registerName, registerPassword, registerEmail, registerConfirmPass;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Fragment fragment;
    String procedencia = "login";
    @Override
    public void onAttach(Context context) {
        sharedPreferences = context.getSharedPreferences("usersValues", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        super.onAttach(context);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vroot = inflater.inflate(R.layout.register_bar_fragment, container, false);

        //EDITTEXT IDENTIFICADOS
        etUserName = vroot.findViewById(R.id.registerfrag_ETuser);
        etPassword = vroot.findViewById(R.id.registerfrag_ETPassword);
        etEmail = vroot.findViewById(R.id.registerfrag_ETemail);
        etConfirmPass = vroot.findViewById(R.id.registerfrag_ETConfirmPassword);
        //BOTONES IDENTIFICADOS
        btnConfirm = vroot.findViewById(R.id.registerfrag_BTNRegister);


        //ACCIONES BOTONILES

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Confirmar registro
                //De momento no voy a obligar a poner caracteres especiales ni limite por mi pura comodidad

                registerName = etUserName.getText().toString();
                registerPassword = etPassword.getText().toString();
                registerEmail = etEmail.getText().toString();
                registerConfirmPass = etConfirmPass.getText().toString();

                if (registerPassword.equals(registerConfirmPass)) {
                    editor.putString("userName", registerName);
                    editor.putString("userPass", registerPassword);
                    editor.putString("email", registerEmail);

                    editor.apply();
                    Toast.makeText(getContext(), "Registro completo", Toast.LENGTH_SHORT).show();

                    removeFragment();
                } else {
                    Toast.makeText(getContext(), "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
                }
            }
        });


        return vroot;
    }

    public void replaceFragment(String procedencia) {

    }

    @Override
    public void changeFragment(String procedencia) {
        replaceFragment(procedencia);
    }

    @Override
    public void removeFragment() {
        getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
    }
}

