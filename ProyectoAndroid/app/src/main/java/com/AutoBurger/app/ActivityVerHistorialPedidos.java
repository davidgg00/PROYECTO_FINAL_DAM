package com.AutoBurger.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.AutoBurger.app.Controlador.GestionProductos;
import com.AutoBurger.app.Modelo.Menu;
import com.AutoBurger.app.Modelo.Pedido;
import com.AutoBurger.app.Modelo.Producto;
import com.AutoBurger.app.Modelo.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
/**
 *
 * @author DavidGG
 * @version 1.0
 */
public class ActivityVerHistorialPedidos extends AppCompatActivity {
    private ArrayList<Button> botones = new ArrayList<>();
    private LinearLayout wrapperHistorialPedidos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_historial_pedidos);
        wrapperHistorialPedidos = (LinearLayout) findViewById(R.id.wrapperHistorialPedidos);

        Bundle bundle = getIntent().getExtras();
        String pedidos = bundle.getString("pedidos");

        //Convertimos los Strings a JSONArray, los recorremos y los almacenamos en el arraylist de pedidos
        try {
            System.out.println(pedidos.toString());
            JSONArray jsonArray = new JSONArray(pedidos);
            String datosPedido = "";
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject j = null;
                JSONObject e = jsonArray.getJSONObject(i);
                int contador = i + 1;
                if (contador < (jsonArray.length() - 1)){
                    j = jsonArray.getJSONObject(i+1);
                } else {
                    j = jsonArray.getJSONObject(i);
                }


                datosPedido += e.get("nombre") + "\n";
                //Si el pedido siguiente es distinto al anterior o es el último creamos botones y texto.
                if (Integer.parseInt(e.get("idPedido").toString()) != Integer.parseInt(j.get("idPedido").toString()) || i == jsonArray.length() - 1){
                    LinearLayout wrapPedido = new LinearLayout(getApplicationContext());
                    wrapPedido.setOrientation(LinearLayout.HORIZONTAL);

                    TextView txt = new TextView(getApplicationContext());
                    txt.setText(datosPedido);
                    //layout_weight:1
                    txt.setLayoutParams(new TableLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));

                    final Button btn = new Button(this);
                    if (i == 0 || e.get("idPedido").toString().equalsIgnoreCase(jsonArray.getJSONObject(i - 1).get("idPedido").toString())){
                        btn.setId(Integer.parseInt(e.get("idPedido").toString()));
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                addProductoPedido(btn.getId());
                            }
                        });
                    } else {
                        btn.setId(Integer.parseInt(e.get("idPedido").toString()));
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                addProductoPedido(btn.getId());
                            }
                        });
                    }


                    //e = jsonArray.getJSONObject(i);

                    btn.setText("Añadir al pedido");
                    btn.setGravity(Gravity.RIGHT);
                    wrapPedido.addView(txt);
                    wrapPedido.addView(btn);
                    botones.add(btn);
                    wrapperHistorialPedidos.addView(wrapPedido);
                    datosPedido = "";
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que cuando se pulsa ir hacia atrás del MOVIL, te llva al activity Bienvenida
     */
    @Override
    public void onBackPressed() {
        Bundle bundle = getIntent().getExtras();
        Usuario usuario = (Usuario) bundle.get("usuario");
        Intent intent = new Intent(ActivityVerHistorialPedidos.this,  BienvenidaActivity.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);
        finish();

    }

    /**
     * Método que añade los productos de un pedido antiguo al pedido actual
     * @param id
     */
    private void addProductoPedido(final int id) {
        Bundle bundle = getIntent().getExtras();
        Usuario usuario = (Usuario) bundle.get("usuario");
        final String email =usuario.getEmail();
        final Pedido pedido = new Pedido(email, 0, null);

        final String pedidos = bundle.getString("pedidos");
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    JSONArray jsonArray = new JSONArray(pedidos);

                    final ArrayList<Object> productos = new ArrayList<>();

                    for (int i = 0; i < jsonArray.length(); i++) {

                        final JSONObject e = jsonArray.getJSONObject(i);
                        if (Integer.parseInt(e.get("idPedido").toString()) == id) {

                            if (e.get("tipo").toString().equalsIgnoreCase("Menu")) {

                                try {
                                    String productosMenu = GestionProductos.getProductosMenu(getApplicationContext(), Integer.parseInt(e.get("id").toString()));
                                    JSONArray productosJSON = new JSONArray(productosMenu);
                                    ArrayList<Producto> productosArrayList = new ArrayList<>();
                                    for (int j = 0; j < productosJSON.length(); j++) {
                                        JSONObject d = productosJSON.getJSONObject(j);
                                        productosArrayList.add(new Producto(Integer.parseInt(d.get("id").toString()), d.get("nombre").toString(), Double.parseDouble(d.get("precio").toString()), d.get("ruta_img").toString(), d.get("tipo").toString()));
                                    }
                                    System.out.println("aaa");
                                    productos.add(new Menu(Integer.parseInt(e.get("id").toString()), e.get("nombre").toString(), Double.parseDouble(e.get("precio").toString()), productosArrayList, e.get("ruta_img").toString()));
                                    pedido.setTotal_a_pagar(pedido.getTotal_a_pagar() + Double.parseDouble(e.get("precio").toString()));
                                } catch (JSONException ex) {
                                    ex.printStackTrace();
                                }
                            }else {
                                productos.add(new Producto(Integer.parseInt(e.get("id").toString()), e.get("nombre").toString(), Double.parseDouble(e.get("precio").toString()), e.get("ruta_img").toString(), e.get("tipo").toString()));
                                pedido.setTotal_a_pagar(pedido.getTotal_a_pagar() + Double.parseDouble(e.get("precio").toString()));
                            }

                        }
                    }
                    System.out.println(productos.toString());
                    pedido.setProductos(productos);
                    Intent intent = new Intent(ActivityVerHistorialPedidos.this, ActivityCartaAlimentos.class);
                    intent.putExtra("pedido",pedido);
                    finish();
                    startActivity(intent);

                } catch (JSONException ex) {
                    ex.printStackTrace();
                }
            }

        });
        thread.start();

    }

    /**
     * Método que al hacer click para ir hacia atrás en la APP MOVIL, te lleva al activity Bienvenida
     * @param view
     */
    public void irAtras(View view){
        Intent intent = new Intent(ActivityVerHistorialPedidos.this, BienvenidaActivity.class);
        Bundle bundle = getIntent().getExtras();
        Usuario usuario = (Usuario) bundle.get("usuario");
        intent.putExtra("usuario",usuario);
        finish();
        startActivity(intent);
    }
}