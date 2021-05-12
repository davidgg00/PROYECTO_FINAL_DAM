package com.AutoBurger.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.AutoBurger.app.Modelo.Ingrediente;
import com.AutoBurger.app.Modelo.Pedido;
import com.AutoBurger.app.Modelo.Producto;

import java.util.ArrayList;

public class VerDetallesProducto extends AppCompatActivity {
    TextView titulo,precio;
    Pedido pedido;
    Producto producto;
    ScrollView scrollIngredientesProduct;
    LinearLayout wrapperIngredientesProducto;
    TextView labelIngredientes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_detalles_producto);

        titulo = (TextView)findViewById(R.id.labelTitulo);
        precio = (TextView)findViewById(R.id.labelPrecio);
        scrollIngredientesProduct = (ScrollView)findViewById(R.id.scrollIngredientesProducto);
        wrapperIngredientesProducto = (LinearLayout)findViewById(R.id.wrapperIngredientesProducto);
        labelIngredientes = (TextView)findViewById(R.id.labelIngredientes);

        //Recibimos parametros
        Bundle bundle=getIntent().getExtras();
        producto = (Producto) bundle.get("producto");
        pedido = (Pedido) bundle.get("pedido");

        titulo.setText(producto.getNombre());
        precio.setText(String.valueOf(producto.getPrecio()) + "€");
        ArrayList<Ingrediente> ingredientes = producto.getIngredientes();

        switch(producto.getTipo()) {
            case "Hamburguesa":
                for (Ingrediente ingrediente : ingredientes) {
                    TextView textView = new TextView(this);
                    textView.setText("-" + ingrediente.getNombre());
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
                    wrapperIngredientesProducto.addView(textView);
                }
                break;
            case "Bebida":
                TextView textView = new TextView(this);
                textView.setText("-" + producto.getNombre());
                labelIngredientes.setText("Producto: ");
                textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
                wrapperIngredientesProducto.addView(textView);
                break;

            case "Patatas":
                TextView textView2 = new TextView(this);
                textView2.setText("Aceite de girasol y sal.");
                textView2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
                wrapperIngredientesProducto.addView(textView2);
                break;
        }

    }

    public void volverCarta(View view){
        Intent intent = new Intent(getApplicationContext(), ActivityCartaAlimentos.class);
        intent.putExtra("pedido",pedido);
        finish();
        startActivity(intent);
    }

    public void addProducto(View view){
        pedido.getCuenta().add(producto);
        pedido.setTotal_a_pagar(pedido.getTotal_a_pagar() + producto.getPrecio());
        Intent intent = new Intent(getApplicationContext(), ActivityCartaAlimentos.class);
        intent.putExtra("pedido",pedido);
        finish();
        startActivity(intent);
    }
}