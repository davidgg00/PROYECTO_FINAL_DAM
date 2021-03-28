package com.example.hamburgergg_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hamburgergg_android.Modelo.Ingrediente;
import com.example.hamburgergg_android.Modelo.Pedido;
import com.example.hamburgergg_android.Modelo.Producto;

import java.util.ArrayList;

public class VerDetallesProducto extends AppCompatActivity {
    TextView titulo,precio;
    Pedido pedido;
    Producto producto;
    EditText etIngredProducto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_detalles_producto);

        titulo = (TextView)findViewById(R.id.labelTitulo);
        precio = (TextView)findViewById(R.id.labelPrecio);
        etIngredProducto = (EditText)findViewById(R.id.etIngredProducto);

        //Recibimos parametros
        Bundle bundle=getIntent().getExtras();
        producto = (Producto) bundle.get("producto");
        pedido = (Pedido) bundle.get("pedido");

        titulo.setText(producto.getNombre());
        precio.setText(String.valueOf(producto.getPrecio()) + "€");
        ArrayList<Ingrediente> ingredientes = producto.getIngredientes();
        String resultado = "";
        for (Ingrediente ingrediente: ingredientes) {
            resultado+="-" + ingrediente.getNombre()+"\n\n";
        }
        etIngredProducto.setText(resultado);

    }

    public void volverCarta(View view){
        finish();
    }

    public void addProducto(View view){
        pedido.getCuenta().add(producto);
        pedido.setTotal_a_pagar(pedido.getTotal_a_pagar() + producto.getPrecio());
        Intent intent = new Intent(getApplicationContext(), ActivityCartaAlimentos.class);
        intent.putExtra("pedido",pedido);
        startActivity(intent);
    }
}