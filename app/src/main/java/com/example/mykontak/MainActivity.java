package com.example.mykontak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText tm_Nama, tm_Number;
    private Button btnSimpan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tm_Nama = findViewById(R.id.txtNama);
        tm_Number = findViewById(R.id.txtNumber);
        btnSimpan = findViewById(R.id.btnsp);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = tm_Nama.getText().toString();
                String notelp = tm_Number.getText().toString();


                if (name.trim().equals("")){
                    tm_Nama.setError("Nama harus diisi");
                }else if (notelp.trim().equals("")){
                    tm_Number.setError("Nomor telepon harus diisi");
                }else{
                    Intent kirim = new Intent(MainActivity.this, DataKontak.class);
                    kirim.putExtra("nameNew", name);
                    kirim.putExtra("numberNew", notelp);
                    startActivity(kirim);
                }
            }
        });

    }
}