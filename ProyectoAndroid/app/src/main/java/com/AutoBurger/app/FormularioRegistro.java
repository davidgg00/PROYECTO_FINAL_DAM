package com.AutoBurger.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.AutoBurger.app.Controlador.Validar;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.AutoBurger.app.Modelo.Conexion;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class FormularioRegistro extends AppCompatActivity {
    private Button btnRegistro;
    EditText etNombre,etCorreo,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_registro);
        btnRegistro = (Button)findViewById(R.id.btnRegistro);
        etCorreo = (EditText) findViewById(R.id.etCorreoReg);
        etNombre = (EditText) findViewById(R.id.etNombreReg);
        etPassword = (EditText) findViewById(R.id.etPasswordReg);
    }

    /**
     * Método que manda por parámetros los datos del registro y si es correcto te llevará al login, en caso contrario se muestra error
     * @param view
     */
    public void realizarRegistro(View view){
        String error = "";
        if (!Validar.correo(etCorreo.getText().toString())){
            error += "El correo ha de ser válido y de máximo 50 carácteres\n";
        }

        if (!Validar.nombreUsuario(etNombre.getText().toString())){
            error += "El nombre ha de ser válido (máximo 25 caracteres y solo letras)\n";
        }

        if (!Validar.password(etPassword.getText().toString())){
            error += "La contraseña no puede estar vacía";
        }

        if (error.isEmpty()){
            RequestQueue queue = Volley.newRequestQueue(FormularioRegistro.this);
            StringRequest jsonObjectRequest = new StringRequest(Request.Method.POST,
                    Conexion.URL_WEB_SERVICES + "Usuario/registroUsuario.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject objResultado = new JSONObject(response);
                                if (Validar.respuestaWebService(objResultado)){
                                    Toast.makeText(FormularioRegistro.this,"Registro realizado correctamente, inicie sesión.",Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    finish();
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(FormularioRegistro.this,"El email ya existe, inténtelo de nuevo.",Toast.LENGTH_LONG).show();
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
                    params.put("nombre", etNombre.getText().toString());
                    params.put("email", etCorreo.getText().toString());
                    params.put("password", etPassword.getText().toString());
                    return params;
                }
            };
            queue.add(jsonObjectRequest);
        } else {
            Toast.makeText(FormularioRegistro.this,error,Toast.LENGTH_LONG).show();
        }

    }

    /**
     * Método que te lleva al formulario de login
     * @param view
     */
    public void irFormularioLogin(View view){
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);
    }
}