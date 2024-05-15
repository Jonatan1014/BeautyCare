package com.example.beautycare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.WindowManager;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });
        SharedPreferences datos = getSharedPreferences("UserInformation", Context.MODE_PRIVATE);
        usuario = datos.getString("username", "");


        // para vista completa
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // para ocultar botones de navegacion
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);


        Handler handler = new Handler();
        Runnable run = new Runnable(){
            public void run() {
                check();
            }
        };
        handler.postDelayed(run, 1000);
    }

    public void check(){
        Usuario userRegist = new Usuario();

        Intent i;
        if (usuario!=""){

            i = new Intent(MainActivity.this, Index.class);
            startActivity(i);
            overridePendingTransition(R.anim.entrada, R.anim.salida);
            finish();
        }
        else {
            i = new Intent(MainActivity.this, Login.class);
            startActivity(i);
            overridePendingTransition(R.anim.entrada, R.anim.salida);
            finish();
        }
        startActivity(i);

    }

}