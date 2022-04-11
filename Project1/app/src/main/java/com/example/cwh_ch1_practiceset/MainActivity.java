package com.example.cwh_ch1_practiceset;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text;
    EditText n1,n2;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"Good Morning Dear",Toast.LENGTH_SHORT).show();
        text =findViewById(R.id.textView);
        text.setText("");
        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                int sum = Integer.parseInt(n1.getText().toString())+ Integer.parseInt(n2.getText().toString());
                for (int i = 1; i <11 ; i++) {
                    text.append(sum + " X " + i + "=" + sum * i +"\n");
                }

            }
        });




    }
}