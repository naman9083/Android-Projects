package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;
    EditText note;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text1);
        note = findViewById(R.id.editTextTextPersonName);
        save = findViewById(R.id.button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = note.getText().toString();
                SharedPreferences shrd = getSharedPreferences("new",MODE_PRIVATE);
                SharedPreferences.Editor editor = shrd.edit();

                editor.putString("str",msg);
                editor.apply();
                text.setText(msg);
            }
        });
        // Get the value of shared preferences back
        SharedPreferences getShared = getSharedPreferences("new",MODE_PRIVATE);
        String value = getShared.getString("str","Save a quick note here! ");
        text.setText(value);
    }
}