package com.example.libardomunoz.motivabici;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.Toast;

public class Recorrido extends AppCompatActivity {

    //Cambio en el cronometro del recorrido

    Button iniciar, pausar, detener, reestablecer, finalizar;
    Chronometer cronometro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorrido);

        cronometro = (Chronometer)findViewById(R.id.cronometro);
        iniciar = (Button)findViewById(R.id.botonIniciar);
        pausar = (Button)findViewById(R.id.botonPausar);
        detener = (Button)findViewById(R.id.botonDetener);
        reestablecer = (Button)findViewById(R.id.botonReestablecer);
        finalizar = (Button)findViewById(R.id.botonFinalizarRecorrido);

        ImageView androidImageField = (ImageView)findViewById(R.id.imagenEstadoRecorrido);
        iniciar.setEnabled(true);
        pausar.setEnabled(false);
        detener.setEnabled(false);
        reestablecer.setEnabled(false);
        finalizar.setEnabled(false);

        //Al pulsar el botón "Finalizar recorrido" pasa a la actividad de resumen del recorrido de la aplicación
        findViewById(R.id.botonFinalizarRecorrido).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Recorrido.this, resumen_recorrido.class));
            }
        });
    }

    public void iniciarRecorrido(View view){
        cronometro.setBase(SystemClock.elapsedRealtime());
        cronometro.start(); //Inicia el cronometro

        ImageView androidImageField = (ImageView)findViewById(R.id.imagenEstadoRecorrido);
        iniciar.setEnabled(false);
        pausar.setEnabled(true);
        detener.setEnabled(true);
        reestablecer.setEnabled(false);
        if(pausar.getText().equals("Continuar")){
            pausar.setText("Pausar");
        }
        androidImageField.setImageResource(R.drawable.play);
        finalizar.setEnabled(false);
    }

    public void pausarRecorrido(View view){

        if(pausar.getText().equals("Pausar")){
            cronometro.stop();
            ImageView androidImageField = (ImageView)findViewById(R.id.imagenEstadoRecorrido);
            pausar.setText("Continuar");
            androidImageField.setImageResource(R.drawable.pause);
        }
        else {
            int stoppedMilliseconds = 0;
            String chronoText = cronometro.getText().toString();
            String array[] = chronoText.split(":");
            if (array.length == 2) {
                stoppedMilliseconds = Integer.parseInt(array[0]) * 60 * 1000 + Integer.parseInt(array[1]) * 1000;
            } else if (array.length == 3) {
                stoppedMilliseconds = Integer.parseInt(array[0]) * 60 * 60 * 1000 + Integer.parseInt(array[1]) * 60 * 1000 + Integer.parseInt(array[2]) * 1000;
            }
            cronometro.setBase(SystemClock.elapsedRealtime() - stoppedMilliseconds);
            cronometro.start();

            ImageView androidImageField = (ImageView)findViewById(R.id.imagenEstadoRecorrido);
            pausar.setText("Pausar");
            reestablecer.setEnabled(true);
            androidImageField.setImageResource(R.drawable.play);
        }

        iniciar.setEnabled(false);
        pausar.setEnabled(true);
        detener.setEnabled(true);
        reestablecer.setEnabled(false);
        finalizar.setEnabled(false);
    }

    public void detenerRecorrido(View view){
        cronometro.stop();

        ImageView androidImageField = (ImageView)findViewById(R.id.imagenEstadoRecorrido);
        iniciar.setEnabled(false);
        pausar.setEnabled(false);
        detener.setEnabled(false);
        reestablecer.setEnabled(true);
        if(pausar.getText().equals("Continuar")){
            pausar.setText("Pausar");
        }
        androidImageField.setImageResource(R.drawable.stop);
        finalizar.setEnabled(true);

        //Guarda el tiempo transcurrido en una variable tipo long
        long tiempoTranscurrido = SystemClock.elapsedRealtime() - cronometro.getBase();
        long tiempoRecorrido = (long)((tiempoTranscurrido / 1000) * 0.000277778);
        //Toast.makeText(Recorrido.this, "Tiempo del recorrido: " + ((tiempoTranscurrido / 1000) * 0.000277778) + " Horas", Toast.LENGTH_SHORT).show();
    }

    public void restablecerCronometro(View view){
        cronometro.setBase(SystemClock.elapsedRealtime());

        ImageView androidImageField = (ImageView)findViewById(R.id.imagenEstadoRecorrido);
        iniciar.setEnabled(true);
        pausar.setEnabled(false);
        detener.setEnabled(false);
        reestablecer.setEnabled(false);
        if(pausar.getText().equals("Continuar")){
            pausar.setText("Pausar");
        }
        androidImageField.setImageResource(R.drawable.stopwatch);
        finalizar.setEnabled(false);
    }

}
