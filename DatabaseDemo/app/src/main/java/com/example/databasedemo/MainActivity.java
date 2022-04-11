package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;


import com.example.databasedemo.Data.MyDbHandler;
import com.example.databasedemo.adapter.RecyclerViewAdapter;
import com.example.databasedemo.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    ListView listView ;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<Contact> contactArrayList;
    private  ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDbHandler db = new MyDbHandler(MainActivity.this);

        Contact tanz = new Contact();
        tanz.setPhoneNumber("7017251685");
        tanz.setName("TANZ");
        Contact nick = new Contact();
        nick.setPhoneNumber("7017251685");
        nick.setName("Nikita");
        Contact Niki = new Contact();
        Niki.setPhoneNumber("7017251685");
        Niki.setName("Nikichy");
        // Adding a contact to the db
        db.addContact(tanz);
        db.addContact(nick);
        db.addContact(Niki);
        Log.d("dbTanz", ("\nId: " + tanz.getId() + " " + nick.getId() + " " + Niki.getId()));
        //Updating a contact
        Niki.setId(4);
        Niki.setName("Dear");
        Niki.setPhoneNumber("6206687646");
        int affectedRows = db.updateContact(Niki);
        Log.d("dbTanz", "No of affected rows are : " + affectedRows);
        db.deleteContactById(1);
        contactArrayList = new ArrayList<>();
        recyclerView = findViewById(R.id.listView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get All contacts

        List<Contact>contactList = db.getAllContacts();
        //deleting contacts 🎶🎶🎶🎶
        for(Contact contact:contactList) {
            Log.d("dbTanz", "\nId:  " + contact.getId() + "\n" + "Phone Number: " + contact.getPhoneNumber() + "\n" + "Name: " + contact.getName() + "\n");
            contactArrayList.add(contact);
        }

 //     Use your recycler view
        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,contactArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,contacts);
//        listView.setAdapter(arrayAdapter);
        Log.d("dbTanz", "There are "+db.getCount()+" in your database");

    }
}