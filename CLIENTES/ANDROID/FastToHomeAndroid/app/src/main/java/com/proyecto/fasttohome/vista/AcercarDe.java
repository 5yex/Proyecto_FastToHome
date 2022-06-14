package com.proyecto.fasttohome.vista;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.proyecto.fasttohome.R;

public class AcercarDe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acercar_de);
        WebView myWebView = (WebView) findViewById(R.id.acercarDeWebView);
        myWebView.loadUrl(getString(R.string.licenciasUrl));
    }
}