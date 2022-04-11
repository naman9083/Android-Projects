package com.tanz.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText number1,number2;
    TextView res;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=findViewById(R.id.button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1=findViewById(R.id.number1);
                number2=findViewById(R.id.number2);
                res = findViewById(R.id.result);

                int n1 = Integer.parseInt(number1.getText().toString());
                int n2 = Integer.parseInt(number2.getText().toString());
                int result=n1+n2;
                res.setText("Result: "+result);
            }
        });
        Toast.makeText(this,"Congratualation you are a android developer",Toast.LENGTH_SHORT).show();
    }

}