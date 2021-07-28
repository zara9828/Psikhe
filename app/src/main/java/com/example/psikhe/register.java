package com.example.psikhe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
    Databasehelper db;
    Button  register;
    EditText username, password, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new Databasehelper(this);

        username = (EditText)findViewById(R.id.idname);
        password = (EditText)findViewById(R.id.pass);
        register = (Button)findViewById(R.id.regisbtn2);

        register.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String strUsername = username.getText().toString();
                String strPassword = password.getText().toString();
                Boolean daftar = db.insertUser(strUsername, strPassword);
                if (daftar == true) {
                    Toast.makeText(getApplicationContext(), "Daftar Berhasil", Toast.LENGTH_SHORT).show();
                    Intent loginIntent = new Intent(register.this, login.class);
                    startActivity(loginIntent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Daftar Gagal", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
}