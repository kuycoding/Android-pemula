package com.kuycoding.rumahadat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


public class DetailrumahActivity extends AppCompatActivity {

    TextView nama, asal, ket;
    ImageView gambar;
    public String title = "Detail Rumah Adat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailrumah);

        getSupportActionBar().setTitle(title);

        nama = findViewById(R.id.nama);
        asal = findViewById(R.id.asal);
        ket = findViewById(R.id.keterangan);
        gambar = findViewById(R.id.photos);

        Intent intent = getIntent();
        String images = intent.getExtras().getString("POTO");
        String namarm = intent.getExtras().getString("NAMA");
        String asalrm = intent.getExtras().getString("ASAL");
        String ketrm = intent.getExtras().getString("KET");

        Glide.with(this)
                .load(images)
                .into(gambar);
        nama.setText(namarm);
        asal.setText(asalrm);
        ket.setText(ketrm);
    }
}
