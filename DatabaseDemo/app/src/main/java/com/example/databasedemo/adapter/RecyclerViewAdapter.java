package com.example.databasedemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databasedemo.DisplayContact;
import com.example.databasedemo.MainActivity;
import com.example.databasedemo.R;
import com.example.databasedemo.model.Contact;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private  Context context;
    private List<Contact> contactList;

    public RecyclerViewAdapter(Context context, List<Contact> contactList){
        this.context=context;
        this.contactList=contactList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact = contactList.get(position);

        holder.contactName.setText(contact.getName());
        holder.phoneNumber.setText(contact.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView contactName;
        public TextView phoneNumber;
        public ImageView iconButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            contactName = itemView.findViewById(R.id.name);
            phoneNumber= itemView.findViewById(R.id.phone_number);
            iconButton = itemView.findViewById(R.id.icon_button);

            iconButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = this.getAdapterPosition()+1;
            Contact contact = contactList.get(position);
            String name = contact.getName();
            String ph_number = contact.getPhoneNumber();
            Toast.makeText(context,String.valueOf(position)+": Name: "+name+" Phone: "+ph_number,Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(context, DisplayContact.class);
            intent.putExtra("Name: ",name);
            intent.putExtra("Phone: ",ph_number);
            context.startActivity(intent);
        }
    }
}