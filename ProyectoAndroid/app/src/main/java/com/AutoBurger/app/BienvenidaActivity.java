package com.AutoBurger.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.AutoBurger.app.Controlador.GestionPedidos;
import com.AutoBurger.app.Modelo.Pedido;

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

                System.out.println(pedidos);
                if (pedidos.equalsIgnoreCase("[]")){
                    runOnUiThread (new Thread(new Runnable() {
                        public void run() {
                            Toast.makeText(getApplicationContext(),"Esta opción estará disponible cuando haga su primer pedido.",Toast.LENGTH_LONG).show();
                        }
                    }));
                } else {
                    Intent intent = new Intent(BienvenidaActivity.this, ActivityVerHistorialPedidos.class);
                    intent.putExtra("email", email);
                    intent.putExtra("pedidos", pedidos);
                    finish();
                    startActivity(intent);
                }

            }
        });
        thread.start();

    }
}