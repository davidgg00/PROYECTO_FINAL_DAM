package com.AutoBurger.app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.AutoBurger.app.Modelo.Conexion;
import com.AutoBurger.app.Modelo.Menu;
import com.AutoBurger.app.Modelo.Pedido;
import com.AutoBurger.app.Modelo.Producto;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VerPedidoActual extends AppCompatActivity {
    private Pedido pedido;
    private TextView labelPrecio;
    private LinearLayout wrapperPedidos;
    private ArrayList<Button> botones = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_pedido_actual);

        labelPrecio = findViewById(R.id.labelPrecio);

        wrapperPedidos = findViewById(R.id.wrapperPedidos);
        //Recibimos parametros
        Bundle bundle=getIntent().getExtras();
        pedido = (Pedido) bundle.get("pedido");

        labelPrecio.setText(String.valueOf(pedido.getTotal_a_pagar() + "€"));



        ArrayList<Object> pedido_total = pedido.getCuenta();
        System.out.println(pedido_total);

        int index = 0;
        for (Object producto: pedido_total) {
            if (producto instanceof Producto){
                final LinearLayout wrapPedido = new LinearLayout(this);
                wrapPedido.setOrientation(LinearLayout.HORIZONTAL);

                TextView txt = new TextView(this);
                txt.setText(((Producto) producto).getNombre());
                //layout_weight:1
                txt.setLayoutParams(new TableLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));

                final Button btn = new Button(this);
                btn.setId(index);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        borrarProductoPedido(btn.getId(),wrapPedido);
                    }
                });
                btn.setText("Eliminar");
                btn.setGravity(Gravity.RIGHT);
                wrapPedido.addView(txt);
                wrapPedido.addView(btn);
                botones.add(btn);
                wrapperPedidos.addView(wrapPedido);
            } else if (producto instanceof Menu){
                final LinearLayout wrapPedido = new LinearLayout(this);
                wrapPedido.setOrientation(LinearLayout.HORIZONTAL);
                TextView txt = new TextView(this);
                txt.setText(((Menu) producto).getNombre());
                txt.setLayoutParams(new TableLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));

                final Button btn = new Button(this);
                btn.setId(index);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        borrarProductoPedido(btn.getId(),wrapPedido);
                    }
                });
                btn.setText("Eliminar");
                btn.setGravity(Gravity.RIGHT);
                wrapPedido.addView(txt);
                wrapPedido.addView(btn);
                botones.add(btn);
                wrapperPedidos.addView(wrapPedido);
            }
            index++;
        }
    }

    public void borrarProductoPedido(int index, LinearLayout wrapPedido){
        double precio = 0;
        if (pedido.getCuenta().get(index) instanceof Producto){
            precio = ((Producto) pedido.getCuenta().get(index)).getPrecio();
        } else if(pedido.getCuenta().get(index) instanceof Menu){
            precio = ((Menu) pedido.getCuenta().get(index)).getPrecio();
        }
        System.out.println(pedido.getTotal_a_pagar());
        System.out.println(precio);

        pedido.setTotal_a_pagar(pedido.getTotal_a_pagar() - precio);
        labelPrecio.setText(String.valueOf(pedido.getTotal_a_pagar()));
        pedido.getCuenta().remove(index);
        botones.remove(index);
        if (index < pedido.getCuenta().size()){
            for (int i = index; i < pedido.getCuenta().size(); i++){
                int id = botones.get(i).getId();
                botones.get(i).setId(id-1);
            }
        }

        wrapPedido.setVisibility(View.GONE);
    }

    public void pagarPedido(View view){
        Intent intent = new Intent(getApplicationContext(), ActivityPasarelaPago.class);
        intent.putExtra("pedido",pedido);
        finish();
        startActivity(intent);
    }

    public void volveraCarta(View view){
        Intent intent = new Intent(getApplicationContext(), ActivityCartaAlimentos.class);
        intent.putExtra("pedido",pedido);
        finish();
        startActivity(intent);
    }
}