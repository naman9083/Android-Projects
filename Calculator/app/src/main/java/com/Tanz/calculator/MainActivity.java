package com.Tanz.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edt1,edt2;
    TextView ans;
    Button add,sub,mul,div;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1=findViewById(R.id.edt1);
        edt2=findViewById(R.id.edt2);
        ans=findViewById(R.id.ans);
        add=findViewById(R.id.add);
        sub=findViewById(R.id.sub);
        mul=findViewById(R.id.mul);
        div=findViewById(R.id.div);
        add.setOnClickListener(v -> {
                double a,b,answer;
                a=Double.parseDouble(edt1.getText().toString());
                b=Double.parseDouble(edt2.getText().toString());
                answer=a+b;
                ans.setText("Ans: "+answer);
        });
        sub.setOnClickListener(v -> {
            double a,b,answer;
            a=Double.parseDouble(edt1.getText().toString());
            b=Double.parseDouble(edt2.getText().toString());
            answer=a-b;
            ans.setText("Ans: "+answer);
        });
        mul.setOnClickListener(v -> {
            double a,b,answer;
            a=Double.parseDouble(edt1.getText().toString());
            b=Double.parseDouble(edt2.getText().toString());
            answer=a*b;
            ans.setText("Ans: "+answer);
        });
        div.setOnClickListener(v -> {
            double a,b,answer;
            a=Double.parseDouble(edt1.getText().toString());
            b=Double.parseDouble(edt2.getText().toString());
            answer=a/b;
            ans.setText("Ans: "+answer);
        });

    }
}