package com.example.navigator.adaptadores;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.navigator.R;
import com.example.navigator.UbicacionActivity;
import com.example.navigator.entidades.Puntoventa;
import com.example.navigator.entidades.Usuario;

import java.util.ArrayList;


public class ListaPersonasAdapter extends
        RecyclerView.Adapter<ListaPersonasAdapter.PersonasViewHolder>
        implements View.OnClickListener{
    ArrayList<Puntoventa> listaUsuario;
    private View.OnClickListener listener;
    // obtiene el tamaño de la lista
    public ListaPersonasAdapter(ArrayList<Puntoventa> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }
    @Override
    public PersonasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        view.setOnClickListener(this);
        return new PersonasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonasViewHolder holder, int position) {
        holder.lugar.setText(listaUsuario.get(position).getNombre());
        holder.direccion.setText(listaUsuario.get(position).getDireccion());
        //holder.imgMapa.setText(listaUsuario.get(position).getId().toString());
        holder.imgMapa.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"mandar foto: ",Toast.LENGTH_LONG).show();
            }
        });
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

    public class PersonasViewHolder extends RecyclerView.ViewHolder {
        TextView imgMapa,lugar,direccion;
        public PersonasViewHolder(View itemView) {
            super(itemView);
            lugar = (TextView) itemView.findViewById(R.id.idNombre);
            direccion = (TextView) itemView.findViewById(R.id.idInfo);
            imgMapa = (TextView) itemView.findViewById(R.id.idImagenMapa);
        }
    }
}
