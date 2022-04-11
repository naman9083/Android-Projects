package com.example.photoframealbum;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    ImageView imageView0,imageView1, imageView2, imageView3;
    TextView pageNumber;
    String s;
    int pgnumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void setImage(int pgnumber){
        imageView0 = findViewById(R.id.imageView0);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        if(pgnumber==1){
            imageView0.setImageResource(R.drawable.img1);
            imageView1.setImageResource(R.drawable.img2);
            imageView2.setImageResource(R.drawable.img3);
            imageView3.setImageResource(R.drawable.img4);
        }
        else if(pgnumber==2){
            imageView0.setImageResource(R.drawable.img5);
            imageView1.setImageResource(R.drawable.img6);
            imageView2.setImageResource(R.drawable.img7);
            imageView3.setImageResource(R.drawable.img8);
        }
        else if(pgnumber==3){
            imageView0.setImageResource(R.drawable.img9);
            imageView1.setImageResource(R.drawable.img10);
            imageView2.setImageResource(R.drawable.img11);
            imageView3.setImageResource(R.drawable.img12);
        }
        else if(pgnumber==4){
            imageView0.setImageResource(R.drawable.img13);
            imageView1.setImageResource(R.drawable.img14);
            imageView2.setImageResource(R.drawable.img15);
            imageView3.setImageResource(R.drawable.img16);
        }
        else if(pgnumber==5){
            imageView0.setImageResource(R.drawable.img17);
            imageView1.setImageResource(R.drawable.img18);
            imageView2.setImageResource(R.drawable.img19);
            imageView3.setImageResource(R.drawable.img20);
        }
        else if(pgnumber==6){
            imageView0.setImageResource(R.drawable.img21);
            imageView1.setImageResource(R.drawable.img22);
            imageView2.setImageResource(R.drawable.img23);
            imageView3.setImageResource(R.drawable.img24);
        }
        else if(pgnumber==7){
            imageView0.setImageResource(R.drawable.img25);
            imageView1.setImageResource(R.drawable.img26);
            imageView2.setImageResource(R.drawable.img27);
            imageView3.setImageResource(R.drawable.img28);
        }
    }
    @SuppressLint("SetTextI18n")
    public void previous(View view){
        pageNumber = findViewById(R.id.pageNumber) ;
        s = pageNumber.getText().toString();
        pgnumber = Integer.parseInt(s);
        if (pgnumber==1)
            pageNumber.setText("7");
        else {
            pgnumber=pgnumber-1;
            s = Integer.toString(pgnumber);
            pageNumber.setText(s);
        }
        s = pageNumber.getText().toString();
        pgnumber = Integer.parseInt(s);
        setImage(pgnumber);

    }
    public void next(View view){
        pageNumber = findViewById(R.id.pageNumber) ;
        s = pageNumber.getText().toString();
        pgnumber = Integer.parseInt(s);

        if (pgnumber==7)
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