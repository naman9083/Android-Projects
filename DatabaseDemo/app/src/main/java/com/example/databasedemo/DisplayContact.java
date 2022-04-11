package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);
        Intent intent = getIntent();
        String name = intent.getStringExtra("Name: ");
        String phone = intent.getStringExtra("Phone: ");
        TextView textView1 = findViewById(R.id.displayName),textView2=findViewById(R.id.displayPhone);
        textView1.setText(name);
        textView2.setText(phone);
    }
}