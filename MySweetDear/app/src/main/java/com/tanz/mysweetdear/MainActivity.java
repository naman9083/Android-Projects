package com.tanz.mysweetdear;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    TextView pageNumber,wishes;
    String s;
    int pgnumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            Toast.makeText(this,"Press Green arrow",Toast.LENGTH_SHORT).show();


    }
    @SuppressLint("SetTextI18n")
    public void setImage(int pgnumber){
        imageView = findViewById(R.id.imageView3);
        wishes=findViewById(R.id.textView3);
        if(pgnumber==1){
            imageView.setImageResource(R.drawable.img5);
            wishes.setText("I LOVE YOU MY💞😊❤" +
                    "DEARJI");
        }
        else if(pgnumber==2){
            imageView.setImageResource(R.drawable.img3);
            wishes.setText("You Are My Everything! Jabse se aap meri life mein aaaye ho tabse mujhe😊❤😘 lgta hai chalo koi toh mila jo mujhe samjhta hai mera dhyan rakhta hai! Mujhe pyaar krta hai!");
        }
        else if(pgnumber==3){
            imageView.setImageResource(R.drawable.img4);
            wishes.setText("Meri life mein sabse acha cheez jo hua hai wo aapse ❤❤milna hai! You are very important to me! Mein aapke bina aage ki nhi soch sakta");
        }
        else if(pgnumber==4){
            imageView.setImageResource(R.drawable.img2);
            wishes.setText("Mana humari thori ladai hoti hai ! Pr sach toh yhi hai hum dono ek dusre se bahut pyaar krte hai! Ladai hua agar, koina milke sort krenge❤😘");

        }
        else if(pgnumber==5){
            imageView.setImageResource(R.drawable.img1);
            wishes.setText("Bs humara pyar aise hi bna rahe! Thori ladai hoti hai uske liye mujhe maaf krdiya kro! Iloveyou my dearji🥰😚💗💞! Jldi se aajao or mujhe gle lgalo🫂🤗");

        }
    }
    @SuppressLint("SetTextI18n")
    public void next(View view){
        pageNumber = findViewById(R.id.pgnumber) ;
        s = pageNumber.getText().toString();
        pgnumber = Integer.parseInt(s);

        if (pgnumber==5)
            pageNumber.setText("1");
        else {
            pgnumber=pgnumber+1;
            String s = Integer.toString(pgnumber);
            pageNumber.setText(s);
        }
        s = pageNumber.getText().toString();
        pgnumber = Integer.parseInt(s);
        setImage(pgnumber);


    }
}