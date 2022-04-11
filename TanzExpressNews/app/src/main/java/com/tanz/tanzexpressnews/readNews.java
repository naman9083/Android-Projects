package com.tanz.tanzexpressnews;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class readNews extends AppCompatActivity {
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String url = getIntent().getStringExtra("URL");
        setContentView(R.layout.activity_read_news);
        WebView w = (WebView) findViewById(R.id.ReadNewz);
        w.loadUrl(url);
        w.getSettings().setJavaScriptEnabled(true);
        w.setWebViewClient(new WebViewClient());

    }

}
