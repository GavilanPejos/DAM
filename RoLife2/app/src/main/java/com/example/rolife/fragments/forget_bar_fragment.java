package com.example.rolife.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.rolife.R;

public class forget_bar_fragment extends Fragment {
    TextView tvTextExample;
    EditText etEmail;
    Button btnSend;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String userEmail;

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
        View vroot = inflater.inflate(R.layout.forget_bar_fragment, container, false);

        tvTextExample = vroot.findViewById(R.id.forgetfrag_TVtext);
        etEmail = vroot.findViewById(R.id.forgetfrag_ETemail);
        btnSend = vroot.findViewById(R.id.forgetfrag_BTNsend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Login
                userEmail = etEmail.getText().toString();

                Toast.makeText(getContext(), "E-mail enviado", Toast.LENGTH_SHORT).show();

            }
        });


        return vroot;


    }
}
