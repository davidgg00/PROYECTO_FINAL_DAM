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
    private ArrayList<Producto> bebidas;
    private LinearLayout pagina1,pagina2,pagina3;
    private RecyclerView recyclerView,recyclerView2;
    private recyclerAdapter.RecyclerViewClickListener listener;
    private Pedido pedido;
    private Button btnPedidoTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta_alimentos);

        obtenerHamburguesas();

        btnPedidoTotal = (Button)findViewById(R.id.btnPedidoTotal);
        bebidas = new ArrayList<>();
        //Recibimos parametros
        Bundle bundle=getIntent().getExtras();
        pedido = (Pedido) bundle.get("pedido");

        btnPedidoTotal.setText("Pedido total : " + pedido.getTotal_a_pagar() + "€");

        view1=(ViewPager)findViewById(R.id.view);
        view1.setAdapter(new AdminPageAdapter());


        btnPedidoTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  System.out.println(hamburguesas.size());

                //GestionProductos.getIngredientesHamburguesa(getApplicationContext(),1);
                //System.out.println("ha llegado: " + x);
            }
        });

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



    private void setOnClickListener() {

        listener = new recyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), VerDetallesProducto.class);
                intent.putExtra("producto",hamburguesas.get(position));
                intent.putExtra("pedido",pedido);
                startActivity(intent);
            }
        };
    }

    private void setOnClickListener2() {
        listener = new recyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                intent.putExtra("username",hamburguesas.get(position).getId());
                intent.putExtra("cuenta","xd");
                startActivity(intent);
            }
        };
    }

    private void setAdapter() {
        //setOnClickListener();
        //recyclerView =(RecyclerView) findViewById(R.id.recyclerId);
        recyclerAdapter adapter = new recyclerAdapter(hamburguesas,listener);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setUserInfo() {
        hamburguesas.add(new Producto(1,"hamburguesa1",9.99,"fotoAlimento1","hamburguesa"));
        hamburguesas.add(new Producto(1,"hamburguesa2",8.99,"fotoAlimento2","hamburguesa"));
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

    class AdminPageAdapter extends PagerAdapter
    {

        @Override
        public int getCount()
        {
            return 3;
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
                        recyclerView = pagina1.findViewById(R.id.recyclerId);


                        setOnClickListener();
                        setAdapter();
                    }
                    paginaactual = pagina1;
                    break;
                case 1:
                    if (pagina2 == null)
                    {
                        pagina2 = (LinearLayout) LayoutInflater.from(ActivityCartaAlimentos.this).inflate(R.layout.pagina2, null);
                        recyclerView2 = pagina2.findViewById(R.id.recyclerId);
                        //setUserInfo();
                        bebidas.add(new Producto(1,"bebida1",1.99,"fotobebida1","bebida"));
                        bebidas.add(new Producto(1,"bebida2",2.99,"fotoBebida2","bebida"));
                        setOnClickListener2();
                        recyclerAdapter adapter2 = new recyclerAdapter(bebidas,listener);

                        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
                        recyclerView2.setLayoutManager(layoutManager);
                        recyclerView2.setItemAnimator(new DefaultItemAnimator());
                        recyclerView2.setAdapter(adapter2);
                    }
                    paginaactual = pagina2;
                    break;
                case 2:
                    if (pagina3 == null)
                    {
                        pagina3 = (LinearLayout) LayoutInflater.from(ActivityCartaAlimentos.this).inflate(R.layout.pagina3, null);
                    }
                    paginaactual = pagina3;
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

