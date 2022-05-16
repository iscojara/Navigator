package com.example.navigator.adaptadores;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.navigator.R;
import com.example.navigator.entidades.Puntoventa;
import com.example.navigator.entidades.Usuario;

import java.util.ArrayList;


public class ListaPersonasAdapter extends
        RecyclerView.Adapter<ListaPersonasAdapter.PersonasViewHolder>
        implements View.OnClickListener{
    ImageView imgMapa;
    ArrayList<Puntoventa> listaUsuario;
    private View.OnClickListener listener;
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
        holder.documento.setText(listaUsuario.get(position).getId().toString());
        holder.nombre.setText(listaUsuario.get(position).getNombre());
        holder.telefono.setText(listaUsuario.get(position).getDireccion());
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
        TextView documento,nombre,telefono;
        public PersonasViewHolder(View itemView) {
            super(itemView);
            documento = (TextView) itemView.findViewById(R.id.idNombre);
            nombre = (TextView) itemView.findViewById(R.id.idNombre);
            telefono = (TextView) itemView.findViewById(R.id.idInfo);
            imgMapa = (ImageView) itemView.findViewById(R.id.idImagenMapa);

        }
    }
}
