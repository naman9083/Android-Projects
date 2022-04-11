package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView myListView = findViewById(R.id.myListView);
        ArrayList<String> grocery = new ArrayList<>();
        grocery.add("Facewash");
        grocery.add("Shampoo");
        grocery.add("Soap");
        grocery.add("Detegent");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter< >(this, android.R.layout.simple_list_item_1, grocery);
        myListView.setAdapter(arrayAdapter);
        myListView.setOnItemClickListener((parent, view, position, id) -> {
            String text = "Item"+position+" "+((TextView)view).getText().toString();
            Toast.makeText(MainActivity.this,text,Toast.LENGTH_SHORT).show();
        });
    }
}