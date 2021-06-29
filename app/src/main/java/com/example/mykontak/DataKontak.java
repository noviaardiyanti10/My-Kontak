package com.example.mykontak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DataKontak extends AppCompatActivity {
    private TextView kontak_nama, kontak_nomor;
    private Button buttonTp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_kontak);
        kontak_nama = findViewById(R.id.dkNama);
        kontak_nomor = findViewById(R.id.dkNomor);
        buttonTp = findViewById(R.id.btnTelp);

        Intent ambil = getIntent();
        String xNama = ambil.getStringExtra("nameNew");
        String yNomor = ambil.getStringExtra("numberNew");

        kontak_nama.setText(xNama);
        kontak_nomor.setText(yNomor);

        buttonTp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Telepon = new Intent(Intent.ACTION_DIAL);
                Telepon.setData(Uri.parse("tel:" + yNomor));
                if (Telepon.resolveActivity(getPackageManager()) != null) {
                    startActivity(Telepon);
                }
            }
        });
    }
}