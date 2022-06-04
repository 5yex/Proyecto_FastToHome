package com.donosocortes.fast2home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.donosocortes.fast2home.vista.login.PantallaLogin;

public class PantallaInicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

    }

    public void pantallaLogin(View view){
        Intent i = new Intent(this, PantallaLogin.class );
        startActivity(i);
    }

}