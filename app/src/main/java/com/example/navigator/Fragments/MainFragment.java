package com.example.navigator.Fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigator.CamaraActivity;
import com.example.navigator.ConexionSQLiteHelper;
import com.example.navigator.MainActivity;
import com.example.navigator.MapsFragment;
import com.example.navigator.R;
import com.example.navigator.UbicacionActivity;
import com.example.navigator.adaptadores.ListaPersonasAdapter;
import com.example.navigator.entidades.Puntoventa;
import com.example.navigator.entidades.Usuario;
import com.example.navigator.iComunicaFragments;
import com.example.navigator.utilidades.Utilidades;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainFragment extends Fragment {
    ArrayList<Puntoventa> listaUsuario;
    RecyclerView recyclerViewUsuarios;
    ConexionSQLiteHelper conn;
    iComunicaFragments iComunicaFragments;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.main_fragment,container,false);
        listaUsuario = new ArrayList<>();
        conn =  new ConexionSQLiteHelper(getContext(),"bd_usuarios",null,1);
        recyclerViewUsuarios = (RecyclerView) view.findViewById(R.id.recyclerID);
        recyclerViewUsuarios.setLayoutManager(new LinearLayoutManager(getContext()));

        Bundle bundlelogueado = getArguments();
        if(bundlelogueado!=null){
            int idlogueado = bundlelogueado.getInt("key_usuariof");
            Toast.makeText(getContext(),"IDLogueado:  "+idlogueado,Toast.LENGTH_LONG).show();
        }
        llenarLista();
        ListaPersonasAdapter adapter = new ListaPersonasAdapter(listaUsuario);

        /* Al dar click a la Iamgen mandar a maps
        Intent i = new Intent(getActivity().getApplicationContext(), UbicacionActivity.class);
        Bundle bundle = new Bundle();
        bundle.putDouble("key_latitude",listaUsuario.get(recyclerViewUsuarios.getChildAdapterPosition(v)).getLatitude());
        bundle.putDouble("key_longitude",listaUsuario.get(recyclerViewUsuarios.getChildAdapterPosition(v)).getLongitude());
        i.putExtras(bundle);
        startActivity(i);
         */
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle(listaUsuario.get(recyclerViewUsuarios.getChildAdapterPosition(v)).getNombre());
                builder.setMessage("¿ Atenderá el pdv ?")
                        .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(getActivity().getApplicationContext(), CamaraActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("key_tienda",listaUsuario.get(recyclerViewUsuarios.getChildAdapterPosition(v)).getNombre());
                                bundle.putString("key_direccion",listaUsuario.get(recyclerViewUsuarios.getChildAdapterPosition(v)).getDireccion());
                                bundle.putInt("key_id",listaUsuario.get(recyclerViewUsuarios.getChildAdapterPosition(v)).getId());
                                i.putExtras(bundle);
                                startActivity(i);
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).show();
            }
        });
        recyclerViewUsuarios.setAdapter(adapter);
        return view;
    }

    private void llenarLista() {
        SQLiteDatabase db = conn.getReadableDatabase();
        Puntoventa usuario = null;
        Cursor cursor = db.rawQuery("Select * FROM "+ Utilidades.TABLA_PUNTOSV,null);
        while (cursor.moveToNext()){
            usuario = new Puntoventa();
            usuario.setId(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setCodigo(cursor.getString(2));
            usuario.setDireccion(cursor.getString(3));
            usuario.setLatitude(cursor.getDouble(4));
            usuario.setLongitude(cursor.getDouble(5));
            listaUsuario.add(usuario);
        }
    }
}
