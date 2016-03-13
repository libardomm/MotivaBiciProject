package com.example.libardomunoz.motivabici;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class Recorrido extends AppCompatActivity {
Button iniciar,stop, restablecer;
    Chronometer cronometro;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorrido);
        cronometro=(Chronometer)findViewById(R.id.cronometro1);
        iniciar=(Button)findViewById(R.id.bttEmpezar);
        stop=(Button)findViewById(R.id.bttTerminar);
        restablecer=(Button)findViewById(R.id.bttRestablecer);
    }
    public void iniciar(View v){
   cronometro.start();

    }
    public void detener(View v){
        cronometro.stop();
    }
    public void restablecer(View v){
        cronometro.setBase(SystemClock.elapsedRealtime());
    }
}
