package com.example.hamburgergg_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.hamburgergg_android.Controlador.GestionPedidos;
import com.example.hamburgergg_android.Controlador.GestionProductos;
import com.example.hamburgergg_android.Modelo.Pedido;
import com.example.hamburgergg_android.Modelo.Producto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        Intent intent = new Intent(BienvenidaActivity.this, ActivityCartaAlimentos.class);
        Pedido pedido = new Pedido(email,0,null);
        intent.putExtra("pedido",pedido);
        finish();
        startActivity(intent);
    }

    public void irAHistorialPedidos(View view){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //Guardaremos los datos de las patatas en variables de sesión, para así solo acceder una vez por cada inicio de la app
                Bundle bundle=getIntent().getExtras();
                String email =bundle.getString("email");
                String pedidos = GestionPedidos.getPedidosAntiguos(getApplicationContext(),email);

                Intent intent = new Intent(BienvenidaActivity.this, ActivityVerHistorialPedidos.class);
                intent.putExtra("email",email);
                intent.putExtra("pedidos",pedidos);
                finish();
                startActivity(intent);

            }
        });
        thread.start();

    }
}