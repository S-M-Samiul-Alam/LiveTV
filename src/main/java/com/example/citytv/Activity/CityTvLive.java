package com.example.citytv.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.citytv.R;

public class CityTvLive extends AppCompatActivity {
    WebView webView;

    @Override
    public void onBackPressed() {
        if(webView.canGoBack())
        {
            webView.goBack();
        }
        else
            {
        super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_tv_live);
        webView = findViewById(R.id.WebView);
        Intent intent =getIntent();
        String website = intent.getStringExtra("links");
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(website);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}
