package com.example.timerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new CountDownTimer(25000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                Log.d("TANZ","onTick: I am hero" );
            }

            @Override
            public void onFinish() {
                Log.d("TANZ","Finished" );
            }
        }.start();
//        final Handler handler = new Handler();
//        Runnable run = new Runnable() {
//            @Override
//            public void run() {
//                Toast.makeText(MainActivity.this,"This is Tanz Runnable",Toast.LENGTH_SHORT).show();
//                handler.postDelayed(this,1000);
//            }
//        };
//        handler.post(run);
    }
}