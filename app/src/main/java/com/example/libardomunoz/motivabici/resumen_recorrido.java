package com.example.libardomunoz.motivabici;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class resumen_recorrido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_recorrido);

        //Al pulsar el botón "Finalizar recorrido" pasa a la actividad de resumen del recorrido de la aplicación
        findViewById(R.id.botonGuardar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(resumen_recorrido.this, PostLogin.class));
            }
        });

        //Al tocar el texto "Calorías Quemadas" envía a la actividad de calorías
        findViewById(R.id.caloriasTextView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(resumen_recorrido.this, calorias.class));
            }
        });
    }
}
