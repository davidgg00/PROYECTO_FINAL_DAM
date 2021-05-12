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
import com.AutoBurger.app.Modelo.Menu;
import com.AutoBurger.app.Modelo.Pedido;
import com.AutoBurger.app.Modelo.Producto;

import java.util.ArrayList;

public class VerDetallesMenu extends AppCompatActivity {
    TextView titulo,precio;
    Pedido pedido;
    Menu menu;
    EditText etProductosMenu;
    ScrollView scrollProductosMenu;
    LinearLayout wrapperProductosMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_detalles_menu);

        titulo = (TextView)findViewById(R.id.labelTitulo);
        precio = (TextView)findViewById(R.id.labelPrecio);
        wrapperProductosMenu = (LinearLayout)findViewById(R.id.wrapperProductosMenu);
        scrollProductosMenu = (ScrollView)findViewById(R.id.scrollProductosMenu );

        //Recibimos parametros
        Bundle bundle=getIntent().getExtras();
        menu = (Menu) bundle.get("menu");
        pedido = (Pedido) bundle.get("pedido");

        titulo.setText(menu.getNombre());
        precio.setText(String.valueOf(menu.getPrecio()) + "€");

        for (Producto producto: menu.getProductos()) {
            TextView textView = new TextView(this);
            textView.setText("-" + producto.getNombre());
            textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,18);
            wrapperProductosMenu.addView(textView);

        }

    }

    public void volverCarta(View view){
        finish();
    }

    public void addProducto(View view){
        ArrayList<Producto> prods = menu.getProductos();
        pedido.getCuenta().add(menu);

        pedido.setTotal_a_pagar(pedido.getTotal_a_pagar() + menu.getPrecio());
        Intent intent = new Intent(getApplicationContext(), ActivityCartaAlimentos.class);
        intent.putExtra("pedido",pedido);
        finish();
        startActivity(intent);
    }
}