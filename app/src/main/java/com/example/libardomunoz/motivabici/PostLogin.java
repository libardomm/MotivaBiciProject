package com.example.libardomunoz.motivabici;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PostLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_login);

        //Al hacer click en el botón "Iniciar Sesión" envía a la actividad de recorrido
        findViewById(R.id.iniciarRecorridoButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PostLogin.this, Recorrido.class));
            }
        });

    }



}
