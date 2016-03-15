package com.example.libardomunoz.motivabici;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class Recorrido extends AppCompatActivity {

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

        iniciar.setEnabled(true);
        pausar.setEnabled(false);
        detener.setEnabled(false);
        reestablecer.setEnabled(false);
    }

    public void iniciarRecorrido(View view){
        cronometro.start();

        iniciar.setEnabled(false);
        pausar.setEnabled(true);
        detener.setEnabled(true);
        reestablecer.setEnabled(false);
        if(pausar.getText().equals("Continuar")){
            pausar.setText("Pausar");
        }
    }

    public void pausarRecorrido(View view){
        if(pausar.getText().equals("Pausar")){
            pausar.setText("Continuar");
        }
        else{
            pausar.setText("Pausar");
            reestablecer.setEnabled(true);
        }

        iniciar.setEnabled(false);
        pausar.setEnabled(true);
        detener.setEnabled(false);
        reestablecer.setEnabled(false);
    }

    public void detenerRecorrido(View view){
        cronometro.stop();

        iniciar.setEnabled(false);
        pausar.setEnabled(false);
        detener.setEnabled(true);
        reestablecer.setEnabled(true);
        if(pausar.getText().equals("Continuar")){
            pausar.setText("Pausar");
        }
    }

    public void restablecerCronometro(View view){
        cronometro.setBase(SystemClock.elapsedRealtime());

        iniciar.setEnabled(true);
        pausar.setEnabled(false);
        detener.setEnabled(false);
        reestablecer.setEnabled(false);
        if(pausar.getText().equals("Continuar")){
            pausar.setText("Pausar");
        }
    }

}
