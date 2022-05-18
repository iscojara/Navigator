package com.example.navigator.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigator.R;
import com.example.navigator.entidades.Producto;
import com.example.navigator.entidades.Puntoventa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaProductosAdapter extends
        RecyclerView.Adapter<ListaProductosAdapter.ProductosViewHolder>
        implements View.OnClickListener{
    ArrayList<Producto> listaProducto;
    ArrayList<Producto> listaOriginal;
    private View.OnClickListener listener;
    public ListaProductosAdapter(ArrayList<Producto> listaProducto) {
        this.listaProducto = listaProducto;
        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(listaProducto);
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
        /*
        holder.reporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Guardado con Exito",Toast.LENGTH_LONG).show();
            }
        });

         */
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
    // metodo para filtrar
    public void filtrado(final String txtBuscar) {
        int longitud = txtBuscar.length();
        if (longitud == 0) {
            listaProducto.clear();
            listaProducto.addAll(listaOriginal);
        } else {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<Producto> collecion = listaProducto.stream()
                        .filter(i -> i.getNombre().toLowerCase().contains(txtBuscar.toLowerCase()))
                        .collect(Collectors.toList());
                listaProducto.clear();
                listaProducto.addAll(collecion);
            } else {
                for (Producto c : listaOriginal) {
                    if (c.getNombre().toLowerCase().contains(txtBuscar.toLowerCase())) {
                        listaProducto.add(c);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    public class ProductosViewHolder extends RecyclerView.ViewHolder {
        TextView nombre,precio,pruta,stock,reporte;
        public ProductosViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.ProductoID);
            precio = (TextView) itemView.findViewById(R.id.ProductoCosto);
            pruta = (TextView) itemView.findViewById(R.id.ProductoRuta);
            stock = (TextView) itemView.findViewById(R.id.ProductoStock);
            /*
            reporte = (TextView) itemView.findViewById(R.id.imagenGuardarFinal);

             */
        }
    }
}
