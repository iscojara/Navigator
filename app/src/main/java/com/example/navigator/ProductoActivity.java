package com.example.navigator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.navigator.adaptadores.ListaPersonasAdapter;
import com.example.navigator.adaptadores.ListaProductosAdapter;
import com.example.navigator.entidades.Producto;
import com.example.navigator.entidades.Puntoventa;
import com.example.navigator.utilidades.Utilidades;

import java.util.ArrayList;

public class ProductoActivity extends AppCompatActivity {
    int idTienda;
    ArrayList<Producto> listaUsuario;
    RecyclerView recyclerViewProducto;
    ConexionSQLiteHelper conn;
    Button btnMaps;
    Bundle bundle;
    ImageView imgRegresarCamaraP, imgGuardar;
    TextView tituloProductoTienda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
        tituloProductoTienda = (TextView) findViewById(R.id.tituloProductoTienda);
        imgRegresarCamaraP = (ImageView) findViewById(R.id.imgRegresarCamaraP);
        imgRegresarCamaraP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),CamaraActivity.class);
                startActivity(it);
            }
        });
        imgGuardar = (ImageView) findViewById(R.id.imgGuardar);
        imgGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(it);
                finish();
            }
        });
        listaUsuario = new ArrayList<>();
        conn =  new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
        recyclerViewProducto = (RecyclerView) findViewById(R.id.recyclerProducto);
        recyclerViewProducto.setLayoutManager(new LinearLayoutManager(this));
        bundle = getIntent().getExtras();
        if(bundle!=null){
            idTienda = bundle.getInt("key_idTienda");
        }
        buscarTienda();
        llenarLista();
        ListaProductosAdapter adapter = new ListaProductosAdapter(listaUsuario);
        recyclerViewProducto.setAdapter(adapter);

    }

    private void buscarTienda() {
        SQLiteDatabase db = conn.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select "+Utilidades.CAMPO_NOMBRE_PUNTOV+" FROM "+Utilidades.TABLA_PUNTOSV+" WHERE "+Utilidades.CAMPO_IDP+"="+idTienda,null);
        if (cursor.moveToFirst()){
            tituloProductoTienda.setText(cursor.getString(0));
        }
    }

    private void llenarLista() {
        SQLiteDatabase db = conn.getReadableDatabase();
        Producto usuario = null;
        Cursor cursor = db.rawQuery("Select * FROM producto WHERE "+Utilidades.CAMPO_PRODUCTOIDTIENDA+"="+idTienda,null);
        while (cursor.moveToNext()){
            usuario = new Producto();
            usuario.setId(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setPrecio(cursor.getDouble(2));
            usuario.setPruta(cursor.getDouble(3));
            usuario.setStock(cursor.getInt(4));
            usuario.setIdTienda(cursor.getInt(5));
            listaUsuario.add(usuario);
        }
    }
}