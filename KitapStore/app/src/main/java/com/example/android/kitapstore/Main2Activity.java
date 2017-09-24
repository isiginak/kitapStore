package com.example.android.kitapstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class Main2Activity extends AppCompatActivity {
Button kitapEkle,btnSite,btnIcerik,btnHarita;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        kitapEkle=(Button)findViewById(R.id.bookAdd);
        btnSite=(Button)findViewById(R.id.visit);
        btnIcerik=(Button)findViewById(R.id.icerik);
        btnHarita=(Button)findViewById(R.id.map);
tiklama();

    }
    private void tiklama() {
        kitapEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),KitapEkle.class));
            }
        });
        btnSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,Site.class));
            }
        });
        btnIcerik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,Icerik.class));
            }
        });
        btnHarita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,HaritadaGoster.class));
            }
        });
}}
