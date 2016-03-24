package com.example.libardomunoz.motivabici;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
    private EditText etPass;
    private AutoCompleteTextView ActEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPass = (EditText) findViewById(R.id.edtPassword);
        ActEmail = (AutoCompleteTextView) findViewById(R.id.ActEmail);
        Toast.makeText(getApplicationContext(), "¡Bienvenido(a) a MotivaBici!", Toast.LENGTH_LONG).show();

        //Al tocar sobre el título "Motivabici" pasa a la actividad de información de la aplicación
        findViewById(R.id.tituloMotivaBici).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FullscreenActivity.class));
            }
        });

        //Al hacer click en el botón "Iniciar Sesión" envía a la actividad de recorrido
        findViewById(R.id.bttIniciarSesion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Ingresar(v)){
                    startActivity(new Intent(MainActivity.this, PostLogin.class));
                }else {
                    etPass.setText("");
                    ActEmail.setText("");
                }
            }
        });

        //Al hacer click sobre el botón "Registrase" envía a la actividad de formulario de registro
        findViewById(R.id.bttRegistrarse).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Registro.class));
            }
        });



    }
    
    public boolean Ingresar(View v){
        boolean bandera;

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();
        String email = ActEmail.getText().toString();
        String password = etPass.getText().toString();

        String consulta = "select nombre, email from usuario where email='" +email+"' and password='"+password+"'";
        Cursor fila = bd.rawQuery(
                consulta, null);
        if (fila.moveToFirst()) {
            Toast.makeText(this, "Consulta hecha satisfactoriamente",
                    Toast.LENGTH_SHORT).show();

            bandera = true;
        } else{
            Toast.makeText(this, "No existe ningún usuario con ese email",
                    Toast.LENGTH_SHORT).show();
            bandera = false;
        }

        bd.close();
        return bandera;

    }

}


