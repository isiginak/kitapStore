package com.example.android.kitapstore;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class Icerik extends AppCompatActivity {
VideoView video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icerik);

        video=(VideoView)findViewById(R.id.video);
        Uri adres=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.kedivideosu);
        video.setVideoURI(adres);
        video.start();

    }
}
