package com.example.libardomunoz.motivabici;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class Recorrido extends AppCompatActivity {

    //Cambio en el cronometro del recorrido

    Button iniciar, pausar, detener, reestablecer;
    Chronometer cronometro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorrido);
        cronometro = (Chronometer)findViewById(R.id.cronometro);
        iniciar = (Button)findViewById(R.id.botonIniciar);
        pausar = (Button)findViewById(R.id.botonPausar);
        detener = (Button)findViewById(R.id.botonDetener);
        reestablecer=(Button)findViewById(R.id.botonReestablecer);

        ImageView androidImageField = (ImageView)findViewById(R.id.imagenEstadoRecorrido);
        iniciar.setEnabled(true);
        pausar.setEnabled(false);
        detener.setEnabled(false);
        reestablecer.setEnabled(false);
    }

    public void iniciarRecorrido(View view){
        cronometro.setBase(SystemClock.elapsedRealtime());
        cronometro.start();

        ImageView androidImageField = (ImageView)findViewById(R.id.imagenEstadoRecorrido);
        iniciar.setEnabled(false);
        pausar.setEnabled(true);
        detener.setEnabled(true);
        reestablecer.setEnabled(false);
        if(pausar.getText().equals("Continuar")){
            pausar.setText("Pausar");
        }
        androidImageField.setImageResource(R.drawable.play);
    }

    public void pausarRecorrido(View view){
        if(pausar.getText().equals("Pausar")){
            ImageView androidImageField = (ImageView)findViewById(R.id.imagenEstadoRecorrido);
            pausar.setText("Continuar");
            androidImageField.setImageResource(R.drawable.pause);
        }
        else {
            ImageView androidImageField = (ImageView)findViewById(R.id.imagenEstadoRecorrido);
            pausar.setText("Pausar");
            reestablecer.setEnabled(true);
            androidImageField.setImageResource(R.drawable.play);
        }

        iniciar.setEnabled(false);
        pausar.setEnabled(true);
        detener.setEnabled(true);
        reestablecer.setEnabled(false);
    }

    public void detenerRecorrido(View view){
        cronometro.stop();

        ImageView androidImageField = (ImageView)findViewById(R.id.imagenEstadoRecorrido);
        iniciar.setEnabled(false);
        pausar.setEnabled(false);
        detener.setEnabled(true);
        reestablecer.setEnabled(true);
        if(pausar.getText().equals("Continuar")){
            pausar.setText("Pausar");
        }
        androidImageField.setImageResource(R.drawable.stop);
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
    }

}
