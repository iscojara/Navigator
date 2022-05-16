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
    ImageView imgMapa;
    ArrayList<Producto> listaUsuario;
    private View.OnClickListener listener;
    public ListaProductosAdapter(ArrayList<Producto> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }
    @Override
    public ProductosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto,null,false);
        view.setOnClickListener(this);
        return new ProductosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductosViewHolder holder, int position) {
        holder.documento.setText(listaUsuario.get(position).getNombre());
        holder.nombre.setText(listaUsuario.get(position).getPrecio().toString());
        holder.telefono.setText(listaUsuario.get(position).getPruta().toString());
        holder.stock.setText(listaUsuario.get(position).getStock().toString());
    }

    @Override
    public int getItemCount() {
        return listaUsuario.size();
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

        TextView documento,nombre,telefono,stock;
        public ProductosViewHolder(View itemView) {
            super(itemView);

            documento = (TextView) itemView.findViewById(R.id.ProductoID);
            nombre = (TextView) itemView.findViewById(R.id.ProductoCosto);
            telefono = (TextView) itemView.findViewById(R.id.ProductoRuta);
            stock = (TextView) itemView.findViewById(R.id.ProductoStock);

        }
    }
}
