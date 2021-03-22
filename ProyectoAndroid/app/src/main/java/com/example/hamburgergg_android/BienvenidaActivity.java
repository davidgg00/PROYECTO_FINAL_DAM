package com.example.hamburgergg_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BienvenidaActivity extends AppCompatActivity {

    private Button btnVerHistorial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);
        btnVerHistorial = (Button) findViewById(R.id.btnVerHistorial);

        //Recibimos parametros
        Bundle bundle=getIntent().getExtras();
        String email =bundle.getString("email");
        String nombre =bundle.getString("nombre");

        System.out.println(bundle.toString());
        if (!email.equalsIgnoreCase("invitado@invitado.com")){
            btnVerHistorial.setVisibility(View.VISIBLE);
        }
    }
}