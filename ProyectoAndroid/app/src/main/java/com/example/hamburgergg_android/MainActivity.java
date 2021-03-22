package com.example.hamburgergg_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.hamburgergg_android.Modelo.Conexion;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText etCorreo,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etCorreo = (EditText) findViewById(R.id.etCorreo);
        etPassword = (EditText) findViewById(R.id.etPassword);
    }

    public void iniciarSesionInvitado(View view){
        Intent intent = new Intent(this, BienvenidaActivity.class);
        intent.putExtra("email","invitado@invitado.com");
        intent.putExtra("nombre","invitado");
        startActivity(intent);
    }

    /**
     * Método que manda por parámetros el email y el password y si es correcto te llevará a otro activity, en caso contrario se muestra error
     * @param view
     */
    public void iniciarSesion(View view){

        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        StringRequest jsonObjectRequest = new StringRequest(Request.Method.POST,
                Conexion.URL_WEB_SERVICES + "iniciarSesion.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject objResultado = new JSONObject(response);
                            String estado=objResultado.get("estado").toString();
                            if (estado.equalsIgnoreCase("exito")){
                                System.out.println(objResultado.toString());
                                Intent intent = new Intent(getApplicationContext(), BienvenidaActivity.class);
                                intent.putExtra("email",objResultado.get("email").toString());
                                intent.putExtra("nombre",objResultado.get("nombre").toString());
                                startActivity(intent);
                            } else {
                                Toast.makeText(MainActivity.this,"Usuario o contraseña incorrecta",Toast.LENGTH_LONG).show();
                            }


                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params= new HashMap<>();
                params.put("email", etCorreo.getText().toString());
                params.put("password", etPassword.getText().toString());
                return params;
            }
        };
        queue.add(jsonObjectRequest);
    }
}