package com.example.hamburgergg_android;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.hamburgergg_android.Controlador.GestionProductos;
import com.example.hamburgergg_android.Modelo.Producto;
import com.example.hamburgergg_android.Modelo.VolleyCallback;
import com.example.hamburgergg_android.Modelo.recyclerAdapter;

import java.util.ArrayList;


public class ActivityCartaAlimentos extends AppCompatActivity {
    private ViewPager view1;
    private ArrayList<Producto> hamburguesas;
    private ArrayList<Producto> bebidas;
    private LinearLayout pagina1,pagina2,pagina3;
    private RecyclerView recyclerView,recyclerView2;
    private recyclerAdapter.RecyclerViewClickListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta_alimentos);

        bebidas = new ArrayList<>();
        GestionProductos.getHamburguesas(getApplicationContext(),new VolleyCallback() {
            @Override
            public void onSuccess(ArrayList<Producto> hamburguesasLista) {
                System.out.println("xd: "+hamburguesasLista.toString());
                hamburguesas = hamburguesasLista;
                view1=(ViewPager)findViewById(R.id.view);
                view1.setAdapter(new AdminPageAdapter());
                hamburguesas = new ArrayList<>();

            }});

    }

    private void setOnClickListener() {

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
        System.out.println(view1);
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


                        System.out.println("no: " + hamburguesas.toString());
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
                        System.out.println(view1);
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

