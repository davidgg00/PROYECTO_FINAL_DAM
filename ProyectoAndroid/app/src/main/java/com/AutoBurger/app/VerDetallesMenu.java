package com.AutoBurger.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.AutoBurger.app.Modelo.Menu;
import com.AutoBurger.app.Modelo.Pedido;
import com.AutoBurger.app.Modelo.Producto;

import java.util.ArrayList;
/**
 *
 * @author DavidGG
 * @version 1.0
 */
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

    /**
     * Método que te devuelve al activity anterior cuando haces click en "ir hacia atrás" de la app movil
     * @param view
     */
    public void volverCarta(View view){
        finish();
    }

    /**
     * Método que te añade el producto al pedido actual al hacer click en "Añadir pedido"
     * @param view
     */
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