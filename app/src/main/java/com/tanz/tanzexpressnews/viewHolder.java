package com.tanz.tanzexpressnews;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class viewHolder extends  RecyclerView.ViewHolder {
    TextView headlines, mainNews, author, publishedAt;
    ImageView imageView;

    public viewHolder(@NonNull View itemView) {
        super(itemView);
        headlines = itemView.findViewById(R.id.titlemainNews);
        mainNews = itemView.findViewById(R.id.newsDescription);
        author = itemView.findViewById(R.id.author);
        publishedAt = itemView.findViewById(R.id.description);
        imageView = itemView.findViewById(R.id.imageView);
    }
}