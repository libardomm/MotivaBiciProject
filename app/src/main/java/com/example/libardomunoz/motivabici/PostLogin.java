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

    public void informacionImportante(View view){

        ImageView informacionImportante1 = (ImageView)findViewById(R.id.informacionImportante1View);
        ImageView informacionImportante2 = (ImageView)findViewById(R.id.informacionImportante2View);

        informacionImportante1.animate().alpha(0f).setDuration(3000);
        informacionImportante2.animate().alpha(1f).setDuration(3000);

    }


}
