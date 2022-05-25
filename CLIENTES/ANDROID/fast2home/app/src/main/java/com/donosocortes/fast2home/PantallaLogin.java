package com.donosocortes.fast2home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.donosocortes.fast2home.controlador.UsuarioDao;
import com.donosocortes.fast2home.modelo.Usuario;

import java.util.List;

public class PantallaLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_login);
        List<Usuario> lista = UsuarioDao.seleccionUsuarios();

        Runnable runnable = new Runnable(){
            public void run() {
                System.out.println(lista.size());
            }
        };
        runnable.run();

    }



}