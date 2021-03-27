package com.example.hamburgergg_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
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
import com.example.hamburgergg_android.Controlador.GestionProductos;
import com.example.hamburgergg_android.Modelo.Conexion;
import com.example.hamburgergg_android.Modelo.Ingrediente;

import org.json.JSONArray;
import org.json.JSONException;
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

        guardarProductos_Sesion();

    }



    /**
     * Método que inicia sesión como invitado
     * @param view
     */
    public void iniciarSesionInvitado(View view){
        Intent intent = new Intent(this, BienvenidaActivity.class);
        intent.putExtra("email","invitado@invitado.com");
        intent.putExtra("nombre","invitado");
        startActivity(intent);
    }

    /**
     * Método que te lleva al formulario de registro
     * @param view
     */
    public void irFormularioRegistro(View view){
        Intent intent = new Intent(this, FormularioRegistro.class);
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

    /**
     * Método que obtiene de la base de datos las hamburguesas, después los ingredientes de cada hamburguesa ya que están en diferentes tablas (n:m)
     * Los guarda en un JSONArray creado desde 0, y este JSONArray se guarda en la session de la app
     * Para que así solo tenga que acceder a la base de datos para obtener los productos una sola vez (al estar en la pantalla de inicio de la app)
     */
    private void guardarProductos_Sesion() {
        //Se ejecuta en un hilo debido a que es una petición SINCRONA Y ES OBLIGATORIO
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //Guardaremos los datos de los productos en variables de sesión, para así solo acceder una vez por cada inicio de la app
                SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = sharedPrefs.edit();
                //Guardamos las hamburguesas
                String hamburguesas = GestionProductos.getHamburguesas2(getApplicationContext());
                editor.putString("hamburguesas",hamburguesas);

                //Y a continuación los ingredientes de las hamburguesas, que habrá que hacer otra petición
                //ya que están en otra tabla (relación muchos a muchos)
                JSONArray JSONArrayPadre = new JSONArray();
                JSONObject JSON = new JSONObject();
                JSONArray JSONArray = new JSONArray();
                try {
                    JSONArray jsonArr = new JSONArray(hamburguesas);
                    //Recorremos las hamburguesas
                    for (int i = 0; i < jsonArr.length(); i++)
                    {
                        JSONObject jsonObj = jsonArr.getJSONObject(i);
                        //Obtenemos los ingredientes de cada hamburguesa por su id
                        String ingredientesHamburguesa = GestionProductos.getIngredientesHamburguesa2(getApplicationContext(),Integer.parseInt(jsonObj.get("id").toString()));
                        JSONArray jsonArr2 = new JSONArray(ingredientesHamburguesa);
                        //guardamos el id de la hamburguesa
                        JSON.put("idHamburguesa",jsonObj.get("id").toString());

                        for (int j = 0; j < jsonArr2.length(); j++){
                            JSONObject jsonObj2 = jsonArr2.getJSONObject(j);
                            JSONArray.put(jsonObj2);
                        }
                        //guardamos los ingredientes en el JSON
                        JSON.put("ingredientes",JSONArray);
                        //Y todo lo anterior en el JSONPadre ya que será un array de JSONS
                        JSONArrayPadre.put(JSON);

                        //reseteamos para obtener nuevos datos y que no se juten
                        JSONArray = new JSONArray();
                        JSON = new JSONObject();
                    }
                    //Guardamos el JSONArray creado en la sesión
                    editor.putString("ingredientesHamburguesas",JSONArrayPadre.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                // Y lo subimos
                editor.commit();
            }
        });
        thread.start();
    }
}