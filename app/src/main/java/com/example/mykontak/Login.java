package com.example.mykontak;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mykontak.MainActivity;
import com.example.mykontak.R;

public class Login extends AppCompatActivity {
    private EditText lg_username, lg_pass;
    private Button lg_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        lg_username = findViewById(R.id.username);
        lg_pass = findViewById(R.id.passwd);
        lg_btn = findViewById(R.id.buttonLogin);

        lg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_key = lg_username.getText().toString();
                String key_pass = lg_pass.getText().toString();


                if (user_key.equals("Novia") && key_pass.equals("1234")){
                    //jika login berhasil
                    Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
                    Intent masuk = new Intent(Login.this, MainActivity.class);
                    startActivity(masuk);
                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                    builder.setMessage("Usernama atau Password Salah!").setNegativeButton("Retry", null).create().show();
                }
            }
        });
    }
}