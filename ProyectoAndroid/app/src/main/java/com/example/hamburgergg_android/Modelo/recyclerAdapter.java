package com.example.hamburgergg_android.Modelo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hamburgergg_android.R;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
    private ArrayList<Producto> productos;
    private RecyclerViewClickListener listener;

    public recyclerAdapter(ArrayList<Producto> productos, RecyclerViewClickListener listener){
        this.productos = productos;
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
        holder.foto.setText(productos.get(position).getRuta_img());
        holder.nametxt.setText(productos.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public interface RecyclerViewClickListener {
        void onClick(View v, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView foto;
        private TextView nametxt;

        public MyViewHolder(final View view){
            super(view);
            nametxt = view.findViewById(R.id.textView4);
            foto = view.findViewById(R.id.textView3);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }
}
