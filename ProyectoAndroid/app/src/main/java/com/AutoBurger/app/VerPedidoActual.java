package com.AutoBurger.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.AutoBurger.app.Modelo.Menu;
import com.AutoBurger.app.Modelo.Pedido;
import com.AutoBurger.app.Modelo.Producto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author DavidGG
 * @version 1.0
 */
public class VerPedidoActual extends AppCompatActivity {
    private Pedido pedido;
    private TextView labelPrecio;
    private LinearLayout wrapperPedidos;
    private ArrayList<ImageView> botones = new ArrayList<ImageView>();

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
                txt.setLayoutParams(new TableLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));

                final ImageView quitarProducto = new ImageView(this);
                quitarProducto.setImageResource(R.drawable.imgeliminarproducto);
                quitarProducto.setId(index);
                quitarProducto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        borrarProductoPedido(quitarProducto.getId(),wrapPedido);
                    }
                });
                LinearLayout.LayoutParams parametros =  new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                wrapPedido.setLayoutParams(parametros);
                parametros.setMargins(10,10,10,40);
                wrapPedido.addView(txt);
                wrapPedido.addView(quitarProducto);
                botones.add(quitarProducto);
                wrapperPedidos.addView(wrapPedido);
            } else if (producto instanceof Menu){
                final LinearLayout wrapPedido = new LinearLayout(this);
                wrapPedido.setOrientation(LinearLayout.HORIZONTAL);
                TextView txt = new TextView(this);
                txt.setText(((Menu) producto).getNombre());
                txt.setLayoutParams(new TableLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));

                final ImageView quitarProducto = new ImageView(this);
                quitarProducto.setImageResource(R.drawable.imgeliminarproducto);
                quitarProducto.setId(index);
                quitarProducto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        borrarProductoPedido(quitarProducto.getId(),wrapPedido);
                    }
                });

                LinearLayout.LayoutParams parametros =  new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                wrapPedido.setLayoutParams(parametros);
                parametros.setMargins(10,10,10,40);
                wrapPedido.addView(txt);
                wrapPedido.addView(quitarProducto);
                botones.add(quitarProducto);
                wrapperPedidos.addView(wrapPedido);
            }
            index++;
        }
    }

    /**
     * Método que borra un producto del pedido actual
     * @param index
     * @param wrapPedido
     */
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
        labelPrecio.setText(String.valueOf(pedido.getTotal_a_pagar()) + "€");
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

    /**
     * Método que te lleva a la pasarela de pago para pagar el pedido
     * @param view
     */
    public void pagarPedido(View view){
        if (pedido.getCuenta().size() > 0){
            //Obtenemos la fecha y hora actual
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            pedido.setFecha(formatter.format(date));
            Intent intent = new Intent(getApplicationContext(), ActivityPasarelaPago.class);
            intent.putExtra("pedido",pedido);
            finish();
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(),"¡No hay ningun producto en el pedido!",Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Método que te devuelve al activity anterior al hacer click en "ir hacia atrás" del pedido actual
     * @param view
     */
    public void volveraCarta(View view){
        Intent intent = new Intent(getApplicationContext(), ActivityCartaAlimentos.class);
        intent.putExtra("pedido",pedido);
        finish();
        startActivity(intent);
    }
}