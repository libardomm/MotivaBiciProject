package com.example.libardomunoz.motivabici;

import android.content.Intent;
import android.net.Uri;
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

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends Activity {
    private EditText etPass;
    private AutoCompleteTextView ActEmail;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

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
                if (Ingresar(v)) {
                    startActivity(new Intent(MainActivity.this, PostLogin.class));
                } else {
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


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public boolean Ingresar(View v) {
        boolean bandera;
        DataBaseManager db = new DataBaseManager();
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this);

        SQLiteDatabase bd = admin.getReadableDatabase();
        String email = ActEmail.getText().toString();
        String password = etPass.getText().toString();

        String consulta = "select nombre, email from usuarios where email='" + email + "' and password='" + password + "'";
        Cursor fila = bd.rawQuery(
                consulta, null);
        if (fila.moveToFirst()) {
            Toast.makeText(this, "Consulta hecha satisfactoriamente",
                    Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "hora "+db.getDateTime(),
                    Toast.LENGTH_SHORT).show();
            bandera = true;
        } else {
            Toast.makeText(this, "No existe ningún usuario con ese email",
                    Toast.LENGTH_SHORT).show();
            bandera = false;
        }

        bd.close();
        return bandera;

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.libardomunoz.motivabici/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.libardomunoz.motivabici/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}


