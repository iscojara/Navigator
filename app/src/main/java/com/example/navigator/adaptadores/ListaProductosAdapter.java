package com.example.navigator.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigator.R;
import com.example.navigator.entidades.Producto;
import com.example.navigator.entidades.Puntoventa;

import java.util.ArrayList;

public class ListaProductosAdapter extends
        RecyclerView.Adapter<ListaProductosAdapter.ProductosViewHolder>
        implements View.OnClickListener{
    ArrayList<Producto> listaProducto;
    private View.OnClickListener listener;
    public ListaProductosAdapter(ArrayList<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }
    @Override
    public ProductosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto,null,false);
        view.setOnClickListener(this);
        return new ProductosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductosViewHolder holder, int position) {
        holder.nombre.setText(listaProducto.get(position).getNombre());
        holder.precio.setText(listaProducto.get(position).getPrecio().toString());
        holder.pruta.setText(listaProducto.get(position).getPruta().toString());
        holder.stock.setText(listaProducto.get(position).getStock().toString());
    }

    @Override
    public int getItemCount() {
        return listaProducto.size();
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }
    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    public class ProductosViewHolder extends RecyclerView.ViewHolder {
        TextView nombre,precio,pruta,stock;
        public ProductosViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.ProductoID);
            precio = (TextView) itemView.findViewById(R.id.ProductoCosto);
            pruta = (TextView) itemView.findViewById(R.id.ProductoRuta);
            stock = (TextView) itemView.findViewById(R.id.ProductoStock);
        }
    }
}
