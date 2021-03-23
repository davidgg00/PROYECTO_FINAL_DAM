package com.example.hamburgergg_android.Modelo;

import java.util.ArrayList;

/**
 * Clase creada para controlar las peticiones ASYNCRONAS a la base de datos
 */
public interface VolleyCallback {
    void onSuccess(ArrayList<Producto> hamburguesas);
}