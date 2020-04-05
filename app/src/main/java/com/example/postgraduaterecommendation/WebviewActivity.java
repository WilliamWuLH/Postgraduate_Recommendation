package com.example.postgraduaterecommendation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebviewActivity extends AppCompatActivity {

    private WebView mWV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        String URL = bundle.getString("URL");

        mWV = findViewById(R.id.wv_main);
        mWV.getSettings().setJavaScriptEnabled(true);
        mWV.setWebViewClient(new MyWebViewClient());
        mWV.setWebChromeClient(new MyWebChromeClient());
        mWV.getSettings().setUseWideViewPort(true);
        mWV.getSettings().setLoadWithOverviewMode(true);
        mWV.getSettings().setSupportZoom(true);
        mWV.getSettings().setBuiltInZoomControls(true);
        mWV.loadUrl(URL);
    }

    class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    }

    class MyWebChromeClient extends WebChromeClient{
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            setTitle(title);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && mWV.canGoBack()){
            mWV.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
