package com.example.hamburgergg_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hamburgergg_android.Modelo.Pedido;

public class BienvenidaActivity extends AppCompatActivity {

    private Button btnVerHistorial;
    private String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);
        btnVerHistorial = (Button) findViewById(R.id.btnVerHistorial);

        //Recibimos parametros
        Bundle bundle=getIntent().getExtras();
        email =bundle.getString("email");
        String nombre =bundle.getString("nombre");

        System.out.println(bundle.toString());
        if (!email.equalsIgnoreCase("invitado@invitado.com")){
            btnVerHistorial.setVisibility(View.VISIBLE);
        }
    }

    public void irACarta(View view){
        Intent intent = new Intent(BienvenidaActivity.this, ActivityCartaAlimentos.class);
        Pedido pedido = new Pedido(email,0);
        intent.putExtra("pedido",pedido);
        startActivity(intent);
    }
}