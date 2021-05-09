package com.AutoBurger.app.Modelo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.AutoBurger.app.R;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
    private ArrayList<Producto> productos;
    private ArrayList<Menu> menus;
    private RecyclerViewClickListener listener;
    private Context contexto;
    private Activity activity;

    public recyclerAdapter(ArrayList<Producto> productos, RecyclerViewClickListener listener, Context applicationContext, Activity activity) {
        this.productos = productos;
        this.listener = listener;
        this.contexto = applicationContext;
        this.activity = activity;
    }

    public recyclerAdapter(Context applicationContext, ArrayList<Menu> menu, RecyclerViewClickListener listener, Activity activity) {
        this.menus = menu;
        this.listener = listener;
        this.contexto = applicationContext;
        this.activity = activity;
    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final recyclerAdapter.MyViewHolder holder, final int position) {
        if (productos == null) {
            final String imageUri = "https://autoburger.000webhostapp.com/imagenesProductos/" + menus.get(position).getRuta_img();
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    holder.nametxt.setText(menus.get(position).getNombre());
                    Glide.with(contexto)
                            .load(imageUri)
                            .thumbnail(0.5f)
                            .override(100, 100)
                            .placeholder(R.drawable.carga)
                            .into(holder.foto);
                }
            });
        } else {

            final String imageUri = "https://autoburger.000webhostapp.com/imagenesProductos/" + productos.get(position).getRuta_img();
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    holder.nametxt.setText(productos.get(position).getNombre());
                    //Glide.with(contexto).load(imageUri).into(holder.foto);
                    Glide.with(contexto)
                            .load(imageUri)
                            .thumbnail(0.5f)
                            .override(100, 100)
                            .placeholder(R.drawable.carga)
                            .into(holder.foto);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (productos == null) {
            return menus.size();
        }
        return productos.size();
    }

    public interface RecyclerViewClickListener {
        void onClick(View v, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView foto;
        private TextView nametxt;

        public MyViewHolder(final View view) {
            super(view);
            nametxt = view.findViewById(R.id.textView4);
            foto = view.findViewById(R.id.imageProductoMenu);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }
}
