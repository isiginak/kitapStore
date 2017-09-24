package com.example.android.kitapstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Timer timer=new Timer();
       timer.schedule(new TimerTask() {
           @Override
           public void run() {
              // Intent ile anasayfaya yönlendirme, 3sn bekleme ile
               startActivity(new Intent(MainActivity.this, Main2Activity.class));
           }
       },3000);
    }
}
