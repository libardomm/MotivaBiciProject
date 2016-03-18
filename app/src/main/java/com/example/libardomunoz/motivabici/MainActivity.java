package com.example.libardomunoz.motivabici;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "¡Bienvenido(a) a MotivaBici!", Toast.LENGTH_LONG).show();

        //Al tocar sobre el título "Motivabici" pasa a la actividad de información de la aplicación
        findViewById(R.id.tituloMotivaBici).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FullscreenActivity.class));
            }
        });

        //Al hacer click en el botón "Iniciar Sesión" envía a la actividad de recorrido
        findViewById(R.id.iniciarSesionButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PostLogin.class));
            }
        });

        //Al hacer click sobre el botón "Registrase" envía a la actividad de formulario de registro
        findViewById(R.id.registrarseButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Registro.class));
            }
        });

    }

}
