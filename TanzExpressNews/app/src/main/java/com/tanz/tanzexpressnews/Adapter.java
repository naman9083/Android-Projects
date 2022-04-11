package com.tanz.tanzexpressnews;


import android.annotation.SuppressLint;
import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {
    private int lastPosition = -1;

    Context context;
    ArrayList<Model> modelArrayList;
    public Adapter(Context context, ArrayList<Model> modelArrayList){
        this.context = context;
        this.modelArrayList = modelArrayList;

    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.headlines.setText(modelArrayList.get(position).getTitle());
        holder.mainNews.setText(modelArrayList.get(position).getDescription());
        holder.author.setText(modelArrayList.get(position).getAuthor());
        holder.publishedAt.setText(modelArrayList.get(position).getPublishedAt());
        String url = modelArrayList.get(position).getUrlToImage();
        setAnimation(holder.itemView,position);
        Glide.with(context).load(url).override(640, 740).apply(RequestOptions.bitmapTransform(new RoundedCorners(50))).into(holder.imageView);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context,readNews.class);
            intent.putExtra("URL",modelArrayList.get(position).getUrl());
            context.startActivity(intent);
        });
    }
    private void setAnimation(View viewToAnimate, int position)
    {
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.slide_in);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }
    public class viewHolder extends  RecyclerView.ViewHolder{
        TextView headlines,mainNews,author,publishedAt;
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


}
