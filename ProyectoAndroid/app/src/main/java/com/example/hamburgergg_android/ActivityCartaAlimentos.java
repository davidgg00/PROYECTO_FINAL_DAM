package com.example.hamburgergg_android;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.hamburgergg_android.Controlador.GestionProductos;
import com.example.hamburgergg_android.Modelo.Ingrediente;
import com.example.hamburgergg_android.Modelo.Menu;
import com.example.hamburgergg_android.Modelo.Pedido;
import com.example.hamburgergg_android.Modelo.Producto;
import com.example.hamburgergg_android.Modelo.recyclerAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class ActivityCartaAlimentos extends AppCompatActivity {
    private ViewPager view1;
    private ArrayList<Producto> hamburguesas = new ArrayList<>();
    private ArrayList<Producto> bebidas = new ArrayList<>();
    private ArrayList<Producto> patatas = new ArrayList<>();
    private ArrayList<Menu> menus = new ArrayList<>();
    private LinearLayout pagina1,pagina2,pagina3,pagina4;
    private recyclerAdapter.RecyclerViewClickListener listener;
    private Pedido pedido;
    private Button btnPedidoTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta_alimentos);

        obtenerHamburguesas();

        obtenerBebidas();

        obtenerPatatas();

        obtenerMenus();

        btnPedidoTotal = (Button)findViewById(R.id.btnPedidoTotal);
        //Recibimos parametros
        Bundle bundle=getIntent().getExtras();
        pedido = (Pedido) bundle.get("pedido");

        btnPedidoTotal.setText("Pedido total : " + pedido.getTotal_a_pagar() + "€");

        view1=(ViewPager)findViewById(R.id.view);
        view1.setAdapter(new AdminPageAdapter());


    }

    public void verPedidoActual(View view){
        Intent intent = new Intent(getApplicationContext(), VerPedidoActual.class);
        intent.putExtra("pedido",pedido);
        startActivity(intent);
    }

    private void obtenerMenus() {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String menus_session = sharedPrefs.getString("menus", "");
        String productosMenu_session = sharedPrefs.getString("productosMenu", "");
        System.out.println(productosMenu_session);
        System.out.println("FFF:" + menus_session);
                //Convertimos los Strings a JSONArray, los recorremos y los almacenamos en el arraylist de hamburguesas
        try {
            JSONArray jsonArray = new JSONArray(menus_session);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject e = jsonArray.getJSONObject(i);

                JSONArray jsonArray2 = new JSONArray(productosMenu_session);
                for (int j = 0; j < jsonArray2.length(); j++) {
                    ArrayList<Producto> productos = new ArrayList<>();
                    JSONObject e2 = jsonArray2.getJSONObject(j);

                    if (e.get("id").toString().equalsIgnoreCase(e2.get("idMenu").toString())) {
                        JSONArray jsonArrayIngredientes = new JSONArray(e2.get("productos").toString());
                        for (int n = 0; n < jsonArrayIngredientes.length(); n++) {
                            JSONObject e3 = jsonArrayIngredientes.getJSONObject(n);
                            productos.add(new Producto(Integer.parseInt(e3.get("id").toString()), e3.get("nombre").toString(), Double.parseDouble(e3.get("precio").toString()),e3.get("tipo").toString(),e3.get("ruta_img").toString()));
                        }
                        menus.add(new Menu(Integer.parseInt(e.get("id").toString()), e.get("nombre").toString(), Double.parseDouble(e.get("precio").toString()), productos));
                    }

                }


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

        private void obtenerPatatas() {
        //Obtenemos las hamburguesas almacenadas en las sesión
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String patatas_session = sharedPrefs.getString("patatas","");


        //Convertimos los Strings a JSONArray, los recorremos y los almacenamos en el arraylist de hamburguesas
        try {
            JSONArray jsonArray = new JSONArray(patatas_session);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject e = jsonArray.getJSONObject(i);
                patatas.add(new Producto(Integer.parseInt(e.get("id").toString()), e.get("nombre").toString(), Double.parseDouble(e.get("precio").toString()), e.get("ruta_img").toString(), e.get("tipo").toString()));
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que obtiene las bebidas almacenadas en las sesión
     * Y las almacena en un arraylist para mostrarlas en el activity
     */
    private void obtenerBebidas() {
        //Obtenemos las hamburguesas almacenadas en las sesión
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String bebidas_session = sharedPrefs.getString("bebidas","");

        //Convertimos los Strings a JSONArray, los recorremos y los almacenamos en el arraylist de hamburguesas
        try {
            JSONArray jsonArray = new JSONArray(bebidas_session);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject e = jsonArray.getJSONObject(i);
                bebidas.add(new Producto(Integer.parseInt(e.get("id").toString()), e.get("nombre").toString(), Double.parseDouble(e.get("precio").toString()), e.get("ruta_img").toString(), e.get("tipo").toString()));
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que obtiene las hamburguesas almacenadas en las sesión
     * Y las almacena en un arraylist para mostrarlas en el activity
     */
    private void obtenerHamburguesas() {
        //Obtenemos las hamburguesas almacenadas en las sesión
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String hamburguesas_session = sharedPrefs.getString("hamburguesas","");
        String ingredientesHamburguesas = sharedPrefs.getString("ingredientesHamburguesas","");

        //Convertimos los Strings a JSONArray, los recorremos y los almacenamos en el arraylist de hamburguesas
        try {
            JSONArray jsonArray = new JSONArray(hamburguesas_session);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject e = jsonArray.getJSONObject(i);

                JSONArray jsonArray2 = new JSONArray(ingredientesHamburguesas);
                for (int j = 0; j < jsonArray2.length(); j++) {
                    ArrayList<Ingrediente> ingredientes = new ArrayList<>();
                    JSONObject e2 = jsonArray2.getJSONObject(j);
                    if (e.get("id").toString().equalsIgnoreCase(e2.get("idHamburguesa").toString())){
                        JSONArray jsonArrayIngredientes = new JSONArray(e2.get("ingredientes").toString());
                        for (int n = 0; n < jsonArrayIngredientes.length(); n++){
                            JSONObject e3 = jsonArrayIngredientes.getJSONObject(n);
                            ingredientes.add(new Ingrediente(Integer.parseInt(e3.get("id").toString()), e3.get("nombre").toString()));
                        }
                        hamburguesas.add(new Producto(Integer.parseInt(e.get("id").toString()), e.get("nombre").toString(), Double.parseDouble(e.get("precio").toString()), e.get("ruta_img").toString(), e.get("tipo").toString(), ingredientes));
                    }

                }


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    private void setOnClickListener(final ArrayList<Producto> tipoProducto) {

        listener = new recyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), VerDetallesProducto.class);
                intent.putExtra("producto",tipoProducto.get(position));
                intent.putExtra("pedido",pedido);
                startActivity(intent);
            }
        };
    }

    private void setOnClickListener2(final ArrayList<Menu> menu) {

        listener = new recyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), VerDetallesMenu.class);
                intent.putExtra("menu",menu.get(position));
                intent.putExtra("pedido",pedido);
                startActivity(intent);
            }
        };
    }

    private void setAdapter(ArrayList<Producto> tipoProducto, RecyclerView recyclerView) {
        recyclerAdapter adapter = new recyclerAdapter(tipoProducto,listener);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setAdapter2(ArrayList<Menu> menu, RecyclerView recyclerView) {
        recyclerAdapter adapter = new recyclerAdapter(listener,menu);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    public void irPagina1(View v) {
        view1.setCurrentItem(0);

    }

    public void irPagina2(View v) {
        view1.setCurrentItem(1);
    }

    public void irPagina3(View v) {
        view1.setCurrentItem(2);
    }

    public void irPagina4(View v) {
        view1.setCurrentItem(3);
    }

    class AdminPageAdapter extends PagerAdapter
    {

        @Override
        public int getCount()
        {
            return 4;
        }

        @Override
        public Object instantiateItem(ViewGroup collection, int position)
        {
            View paginaactual = null;
            switch (position)
            {
                case 0:
                    if (pagina1 == null)
                    {
                        pagina1 = (LinearLayout) LayoutInflater.from(ActivityCartaAlimentos.this).inflate(R.layout.pagina1, null);
                        RecyclerView recyclerView = pagina1.findViewById(R.id.recyclerId);
                        recyclerView = pagina1.findViewById(R.id.recyclerId);
                        setOnClickListener(hamburguesas);
                        setAdapter(hamburguesas,recyclerView);
                    }
                    paginaactual = pagina1;
                    break;
                case 1:
                    if (pagina2 == null)
                    {
                        pagina2 = (LinearLayout) LayoutInflater.from(ActivityCartaAlimentos.this).inflate(R.layout.pagina2, null);
                        RecyclerView recyclerView = pagina2.findViewById(R.id.recyclerId);
                        setOnClickListener(bebidas);
                        setAdapter(bebidas,recyclerView);

                    }
                    paginaactual = pagina2;
                    break;
                case 2:
                    if (pagina3 == null)
                    {
                        pagina3 = (LinearLayout) LayoutInflater.from(ActivityCartaAlimentos.this).inflate(R.layout.pagina3, null);
                        RecyclerView recyclerView = pagina3.findViewById(R.id.recyclerId);
                        setOnClickListener(patatas);
                        setAdapter(patatas,recyclerView);
                    }
                    paginaactual = pagina3;
                    break;

                case 3:
                    if (pagina4 == null)
                    {
                        pagina4 = (LinearLayout) LayoutInflater.from(ActivityCartaAlimentos.this).inflate(R.layout.pagina4, null);
                        RecyclerView recyclerView = pagina4.findViewById(R.id.recyclerId);
                        setOnClickListener2(menus);
                        setAdapter2(menus,recyclerView);
                    }
                    paginaactual = pagina4;
                    break;
            }
            ViewPager vp=(ViewPager) collection;
            vp.addView(paginaactual, 0);
            return paginaactual;
        }

        @Override
        public boolean isViewFromObject(View view, Object object)
        {
            return view == object;
        }

        @Override
        public void destroyItem(View collection, int position, Object view)
        {
            ((ViewPager) collection).removeView((View) view);
        }
    }
}

