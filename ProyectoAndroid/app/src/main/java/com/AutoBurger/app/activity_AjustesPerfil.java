package com.AutoBurger.app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.AutoBurger.app.Controlador.Validar;
import com.AutoBurger.app.Modelo.Conexion;
import com.AutoBurger.app.Modelo.Usuario;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class activity_AjustesPerfil extends AppCompatActivity {
    EditText etNombre,etCorreo,etPasswordActual,etPasswordNueva;
    Usuario usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__ajustes_perfil);
        etNombre = findViewById(R.id.etNombreCliente);
        etCorreo = findViewById(R.id.etCorreoCliente);
        etPasswordActual = findViewById(R.id.etPasswordActualCliente);
        etPasswordNueva = findViewById(R.id.etPasswordNuevaCliente);
        Bundle bundle=getIntent().getExtras();
        usuario = (Usuario) bundle.get("usuario");
        etNombre.setText(usuario.getNombre());
        etCorreo.setText(usuario.getEmail());
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(activity_AjustesPerfil.this,  BienvenidaActivity.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);
        finish();

    }

    public void editarPerfil(View view){
        String errores = "";
        if (!Validar.nombreUsuario(etNombre.getText().toString())){
            errores += "El nombre de usuario no es válido.\n";
        }

        if (!Validar.correo(etCorreo.getText().toString())){
            errores += "El formato de email no es válido.\n";
        }

        if (!Validar.password(etPasswordActual.getText().toString())){
            errores += "La password actual no es válida, tiene más de 5 caracteres.\n";
        }

        if (!usuario.getPassword().equalsIgnoreCase(claveintroducidaMD5(etPasswordActual.getText().toString()))){
            errores += "La contraseña actual no es correcta";
            System.out.println(usuario.getPassword());
        }


        if (etPasswordNueva.getText().toString().length() > 0 && !Validar.password(etPasswordNueva.getText().toString())){
            errores += "La password actual debe tener más de 5 caracteres.\n";
        }

        if (errores.isEmpty()){
            RequestQueue queue = Volley.newRequestQueue(activity_AjustesPerfil.this);
            StringRequest jsonObjectRequest = new StringRequest(Request.Method.POST,
                    Conexion.URL_WEB_SERVICES + "Usuario/editarPerfil.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject objResultado = new JSONObject(response);
                                System.out.println(objResultado.toString());
                                if (objResultado.toString().equalsIgnoreCase("{\"code\":\"CR_OK\",\"value\":\"OK_MANIPULACION\"}")){
                                    Toast.makeText(activity_AjustesPerfil.this,"Perfil actualizado correctamente",Toast.LENGTH_LONG).show();
                                    usuario.setNombre(etNombre.getText().toString());
                                   if (!etPasswordNueva.getText().toString().isEmpty()){
                                       usuario.setPassword(claveintroducidaMD5(etPasswordNueva.getText().toString()));
                                   }
                                    etPasswordNueva.setText("");
                                    etPasswordActual.setText("");
                                } else {
                                    if (!etPasswordNueva.getText().toString().isEmpty()){
                                        Toast.makeText(activity_AjustesPerfil.this,"La password nueva no puede ser igual que la antigua",Toast.LENGTH_LONG).show();
                                    } else {
                                        Toast.makeText(activity_AjustesPerfil.this,"No has realizado ningún cambio",Toast.LENGTH_LONG).show();
                                    }
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
                    params.put("passwordActual", etPasswordActual.getText().toString());
                    if (!etPasswordNueva.getText().toString().isEmpty()){
                        params.put("passwordNueva", etPasswordNueva.getText().toString());
                    }
                    return params;
                }
            };
            queue.add(jsonObjectRequest);
        } else {
            Toast.makeText(getApplicationContext(),errores,Toast.LENGTH_LONG).show();
        }
    }

    private String claveintroducidaMD5(String clave){
        // Static getInstance method is called with hashing MD5
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(clave.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


        return null;
    }
}
