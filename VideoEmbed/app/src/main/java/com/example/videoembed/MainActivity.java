package com.example.videoembed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoView VideoSong = findViewById(R.id.Song);
        VideoSong.setVideoPath("android.resource://"+getPackageName()+"//"+R.raw.clip);
        MediaController mediaController = new MediaController(this);
        VideoSong.setMediaController(mediaController);
        mediaController.setAnchorView(VideoSong);

        VideoSong.start();
    }
}