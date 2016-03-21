package com.example.libardomunoz.motivabici;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class PostLogin extends AppCompatActivity {
    private int mCurrent = 0;
    private ImageView mImageView;

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
        ImageView informacionImportante3 = (ImageView)findViewById(R.id.informacionImportante3View);
        ImageView informacionImportante4 = (ImageView)findViewById(R.id.informacionImportante4View);
        ImageView informacionImportante5 = (ImageView)findViewById(R.id.informacionImportante5View);

        //informacionImportante1.animate().alpha(0f).setDuration(3000);
        //informacionImportante2.animate().alpha(1f).setDuration(3000);


        if (informacionImportante1.getAlpha() == 1f)
        {
        // fade out homer
        // fade in marge

            informacionImportante1.animate().alpha(0f).setDuration(2000);
            informacionImportante2.animate().alpha(1f).setDuration(2000);

        }
        else if(informacionImportante2.getAlpha() == 1f){
        // fade out bart
        // fade in bart

            informacionImportante2.animate().alpha(0f).setDuration(2000);
            informacionImportante3.animate().alpha(1f).setDuration(2000);
        }
        else if(informacionImportante3.getAlpha() == 1f){
            // fade out bart
            // fade in bart

            informacionImportante3.animate().alpha(0f).setDuration(2000);
            informacionImportante4.animate().alpha(1f).setDuration(2000);
        }
        else if(informacionImportante4.getAlpha() == 1f){
            // fade out bart
            // fade in bart

            informacionImportante4.animate().alpha(0f).setDuration(2000);
            informacionImportante5.animate().alpha(1f).setDuration(2000);
        }
        else if(informacionImportante5.getAlpha() == 1f){
            // fade out bart
            // fade in bart

            informacionImportante5.animate().alpha(0f).setDuration(2000);
            informacionImportante1.animate().alpha(1f).setDuration(2000);
        }

    }
}
