package com.example.navigator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.navigator.utilidades.Utilidades;

public class NuevoPuntoVentaActivity extends AppCompatActivity {
    ImageView imgRegresarDeRegistroToPrincipal;
    Button btnRegisterPuntoV;
    EditText txtnomP,txtCodP,txtDireP,txtLatitP,txLongituP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_punto_venta);
        btnRegisterPuntoV = (Button) findViewById(R.id.btnRegisterPuntoV);
        imgRegresarDeRegistroToPrincipal = (ImageView) findViewById(R.id.imgRegresarDeRegistroToPrincipal);

        txtnomP = (EditText) findViewById(R.id.txtNombrePuntoV);
        txtCodP = (EditText) findViewById(R.id.txtCodigoPuntoV);
        txtDireP = (EditText) findViewById(R.id.txtDireccionPuntoV);
        txtLatitP = (EditText) findViewById(R.id.txtLatitudePuntoV);
        txLongituP = (EditText) findViewById(R.id.txtLongitudePuntoV);

        imgRegresarDeRegistroToPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        btnRegisterPuntoV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtnomP.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Complete el campo nombre PDV",Toast.LENGTH_SHORT).show();
                }else if(txtCodP.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Complete el campo Codigo PDV",Toast.LENGTH_SHORT).show();
                }else if(txtDireP.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Complete el campo Direccion PDV",Toast.LENGTH_SHORT).show();
                }else if(txtLatitP.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Complete el campo Latitude PDV",Toast.LENGTH_SHORT).show();
                } else if(txLongituP.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Complete el campo Longitude PDV",Toast.LENGTH_SHORT).show();
                }else{
                    registrarPuntoVenta();
                }
            }
        });
    }
    private void registrarPuntoVenta() {
        Double latitude = Double.parseDouble(txtLatitP.getText().toString());
        Double longitude = Double.parseDouble(txLongituP.getText().toString());
        //Toast.makeText(getApplicationContext(),""+latitude,Toast.LENGTH_SHORT).show();

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values =  new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE_PUNTOV,txtnomP.getText().toString());
        values.put(Utilidades.CAMPO_CODIGO_PUNTOV,txtCodP.getText().toString());
        values.put(Utilidades.CAMPO_DIRECCION_PUNTOV,txtDireP.getText().toString());
        values.put(Utilidades.CAMPO_LATITUDE,latitude);
        values.put(Utilidades.CAMPO_AMPLITUDE,longitude);

        Long idResultado = db.insert(Utilidades.TABLA_PUNTOSV,Utilidades.CAMPO_ID_PUNTOV,values);
        Toast.makeText(getApplicationContext(),"Id Registro: "+idResultado,Toast.LENGTH_LONG).show();
        db.close();
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();

    }
}