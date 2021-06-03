package com.AutoBurger.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.AutoBurger.app.Controlador.GestionPedidos;
import com.AutoBurger.app.Modelo.Pedido;
import com.AutoBurger.app.Modelo.Usuario;

public class BienvenidaActivity extends AppCompatActivity {

    private Button btnVerHistorial, btnAjustesPerfil;
    private Usuario usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);
        btnVerHistorial = (Button) findViewById(R.id.btnVerHistorial);
        btnAjustesPerfil = (Button) findViewById(R.id.btnAjusterPerfil);

        //Recibimos parametros
        Bundle bundle=getIntent().getExtras();
        usuario = (Usuario) bundle.get("usuario");

        if (!usuario.getEmail().equalsIgnoreCase("invitado@invitado.com")){
            btnVerHistorial.setVisibility(View.VISIBLE);
            btnAjustesPerfil.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Método que te lleva al activity Carta
     * @param view
     */
    public void irACarta(View view){
        Intent intent = new Intent(BienvenidaActivity.this, ActivityCartaAlimentos.class);
        Pedido pedido = new Pedido(usuario.getEmail(),0,null);
        intent.putExtra("pedido",pedido);
        finish();
        startActivity(intent);
    }

    /**
     * Método que te lleva al activity HistorialPedidos
     * @param view
     */
    public void irAHistorialPedidos(View view){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //Guardaremos los datos de las patatas en variables de sesión, para así solo acceder una vez por cada inicio de la app
                Bundle bundle=getIntent().getExtras();
                String pedidos = GestionPedidos.getPedidosAntiguos(getApplicationContext(),usuario.getEmail());

                System.out.println(pedidos);
                if (pedidos.equalsIgnoreCase("[]")){
                    runOnUiThread (new Thread(new Runnable() {
                        public void run() {
                            Toast.makeText(getApplicationContext(),"Esta opción estará disponible cuando haga su primer pedido.",Toast.LENGTH_LONG).show();
                        }
                    }));
                } else {
                    Intent intent = new Intent(BienvenidaActivity.this, ActivityVerHistorialPedidos.class);
                    intent.putExtra("usuario", usuario);
                    intent.putExtra("pedidos", pedidos);
                    startActivity(intent);
                }

            }
        });
        thread.start();

    }

    /**
     * Método que te lleva al activity AjustesCliete
     * @param view
     */
    public void irAjustesCliente(View view){
        Intent intent = new Intent(BienvenidaActivity.this,  activity_AjustesPerfil.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);

    }
}