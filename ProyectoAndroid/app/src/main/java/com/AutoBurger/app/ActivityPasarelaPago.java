package com.AutoBurger.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.AutoBurger.app.Modelo.Conexion;
import com.AutoBurger.app.Modelo.Menu;
import com.AutoBurger.app.Modelo.Pedido;
import com.AutoBurger.app.Modelo.Producto;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.braintreepayments.cardform.view.CardForm;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author DavidGG
 * @version 1.0
 */
public class ActivityPasarelaPago extends AppCompatActivity {
    CardForm cardForm;
    Button buy;
    Pedido pedido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasarela_pago);

        buy = findViewById(R.id.btnBuy);
        cardForm = (CardForm) findViewById(R.id.card_form);
        cardForm.cardRequired(true)
                .expirationRequired(true)
                .cvvRequired(true)
                .cardholderName(CardForm.FIELD_REQUIRED)
                .postalCodeRequired(true)
                .mobileNumberRequired(true)
                .actionLabel("Purchase")
                .setup(ActivityPasarelaPago.this);


        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cardForm.isValid()) {
                    inserccionPedidoBBDD();
                }else {
                    Toast.makeText(ActivityPasarelaPago.this, "Completa el formulario", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    /**
     * Método que inserta el pedido en la bbdd
     */
    private void inserccionPedidoBBDD(){

        Bundle bundle=getIntent().getExtras();
        pedido = (Pedido) bundle.get("pedido");
        RequestQueue queue = Volley.newRequestQueue(ActivityPasarelaPago.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Conexion.URL_WEB_SERVICES + "Pedido/insertarPedido.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            System.out.println(pedido.getFecha());

                            System.out.println(response);

                            JSONObject respuesta = new JSONObject(response);


                            for (Object objeto : pedido.getCuenta()){
                                if (objeto instanceof Producto){
                                    addDetallePedidoBBDD(((Producto) objeto).getId(), Integer.parseInt(respuesta.get("id").toString()));
                                    ((Producto) objeto).getId();
                                } else if(objeto instanceof Menu){
                                    addDetallePedidoBBDD(((Menu) objeto).getId(), Integer.parseInt(respuesta.get("id").toString()));
                                }
                            }

                            pedido.setId(Integer.parseInt(respuesta.get("id").toString()));
                            pedido.setPedidoNumero(Integer.parseInt(respuesta.get("pedidoNumero").toString()));
                            pedido.setFecha(respuesta.get("fecha").toString());
                            pedido.setEntregado(Boolean.parseBoolean(respuesta.get("entregado").toString()));
                            Intent intent = new Intent(ActivityPasarelaPago.this, EsperarComida.class);
                            intent.putExtra("pedidoNumero",respuesta.get("pedidoNumero").toString());
                            intent.putExtra("pedido",pedido);
                            finish();
                            startActivity(intent);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("email_cliente", pedido.getEmail_cliente());
                params.put("total_a_pagar", String.valueOf(pedido.getTotal_a_pagar()));
                params.put("fecha",pedido.getFecha());
                return params;
            }
        };
        queue.add(stringRequest);
    }

    /**
     * Método que añade los detalles del pedido (productos y menús)
     * @param detalle
     * @param idPedido
     */
    private void addDetallePedidoBBDD(final int detalle, final int idPedido){
        RequestQueue queue = Volley.newRequestQueue(ActivityPasarelaPago.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Conexion.URL_WEB_SERVICES + "Pedido/insertarDetallePedido.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            System.out.println(response);
                            JSONObject objResultado = new JSONObject(response);
                            String extadox = objResultado.get("estado").toString();
                            if (!extadox.equalsIgnoreCase("exito")) {
                                Toast.makeText(ActivityPasarelaPago.this, "error al crear el pedido", Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("idPedido", String.valueOf(idPedido));
                params.put("idProducto", String.valueOf(detalle));
                return params;
            }
        };
        queue.add(stringRequest);
    }

}