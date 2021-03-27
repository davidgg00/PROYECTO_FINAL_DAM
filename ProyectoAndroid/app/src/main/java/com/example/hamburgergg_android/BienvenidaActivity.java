package com.example.hamburgergg_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;

import com.example.hamburgergg_android.Controlador.GestionProductos;
import com.example.hamburgergg_android.Modelo.Pedido;
import com.example.hamburgergg_android.Modelo.Producto;

import java.util.ArrayList;

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
        final Intent intent = new Intent(BienvenidaActivity.this, ActivityCartaAlimentos.class);
        Pedido pedido = new Pedido(email,0);
        intent.putExtra("pedido",pedido);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<Producto> hamburguesas = GestionProductos.getHamburguesas(getApplicationContext());
                intent.putExtra("hamburguesas", hamburguesas);
                startActivity(intent);


            }
        });
        thread.start();

    }
}