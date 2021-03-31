package com.example.hamburgergg_android.Modelo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hamburgergg_android.ActivityCartaAlimentos;
import com.example.hamburgergg_android.R;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
    private ArrayList<Producto> productos;
    private ArrayList<Menu> menus;
    private RecyclerViewClickListener listener;
    private Context contexto;

    public recyclerAdapter(ArrayList<Producto> productos, RecyclerViewClickListener listener, Context applicationContext){
        this.productos = productos;
        this.listener = listener;
        this.contexto = applicationContext;
    }

    public recyclerAdapter(RecyclerViewClickListener listener, ArrayList<Menu> menus){
        this.menus = menus;
        this.listener = listener;
    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        //String name = usersList.get(position).getUsername();
        if (productos == null){
            //holder.foto.setText(String.valueOf(menus.get(position).getId()));
            holder.nametxt.setText(menus.get(position).getNombre());
        }else {
            String imageUri = "https://autoburger.000webhostapp.com/imagenesProductos/"+productos.get(position).getRuta_img() ;
            Glide.with(contexto).load(imageUri).into(holder.foto);
            holder.nametxt.setText(productos.get(position).getNombre());
        }
    }

    @Override
    public int getItemCount() {
        if (productos == null){
            return menus.size();
        }
        return productos.size();
    }

    public interface RecyclerViewClickListener {
        void onClick(View v, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView foto;
        private TextView nametxt;

        public MyViewHolder(final View view){
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
