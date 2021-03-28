package com.example.hamburgergg_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hamburgergg_android.Modelo.Ingrediente;
import com.example.hamburgergg_android.Modelo.Menu;
import com.example.hamburgergg_android.Modelo.Pedido;
import com.example.hamburgergg_android.Modelo.Producto;

import java.util.ArrayList;

public class VerDetallesMenu extends AppCompatActivity {
    TextView titulo,precio;
    Pedido pedido;
    Menu menu;
    EditText etIngredProducto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_detalles_menu);

        titulo = (TextView)findViewById(R.id.labelTitulo);
        precio = (TextView)findViewById(R.id.labelPrecio);
        etIngredProducto = (EditText)findViewById(R.id.etIngredProducto);

        //Recibimos parametros
        Bundle bundle=getIntent().getExtras();
        menu = (Menu) bundle.get("menu");
        pedido = (Pedido) bundle.get("pedido");

        titulo.setText(menu.getNombre());
        precio.setText(String.valueOf(menu.getPrecio()) + "€");

        etIngredProducto.setText("-");
    }

    public void volverCarta(View view){
        finish();
    }

    public void addProducto(View view){
        ArrayList<Producto> prods = menu.getProductos();
        pedido.getProductos().add(menu);

        pedido.setTotal_a_pagar(pedido.getTotal_a_pagar() + menu.getPrecio());
        Intent intent = new Intent(getApplicationContext(), ActivityCartaAlimentos.class);
        intent.putExtra("pedido",pedido);
        startActivity(intent);
    }
}