package com.example.navigator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navigator.utilidades.Utilidades;

public class LoginActivity extends AppCompatActivity {
    Button btnIngresar;
    TextView tvRegistrese;
    ConexionSQLiteHelper conn;
    EditText txtusu,txtpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        conn = new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
        txtusu= (EditText) findViewById(R.id.loginUsuario);
        txtpass = (EditText) findViewById(R.id.loginClave);

        tvRegistrese = (TextView) findViewById(R.id.txtregister);
        tvRegistrese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(i);
            }
        });
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultar();
            }

            private void consultar() {
                SQLiteDatabase db = conn.getReadableDatabase();
                //String[] parametros = {txtusu.getText().toString(),txtpass.getText().toString()};
                //String[] campos = {Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_APELLIDOP,Utilidades.CAMPO_APELLIDOM,Utilidades.CAMPO_CORREO};
                try {
                    //Cursor cursor = db.query(Utilidades.TABLA_USUARIO,campos,Utilidades.CAMPO_NOMBRE+"=?",parametros,null,null,null);
                    //cursor.moveToFirst();
                    Cursor cursor = db.query("usuario",
                            new String[]{"id","nombre","apellidoP","apellidoM","correo","password"}
                            ,"nombre like '"+txtusu.getText().toString()+"' and password like '" +
                                    ""+ txtpass.getText().toString()+"'",
                            null,null,null,null);
                    if (cursor.getCount()>0){
                        Intent i = new Intent(getApplicationContext(),MainActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("key_user",txtusu.getText().toString());
                        cursor.close();
                        i.putExtras(bundle);
                        startActivity(i);
                    }else{
                        Toast.makeText(getApplicationContext(),"Usuario y/0 Pass Incorrectos",Toast.LENGTH_LONG).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Error en Consulta",Toast.LENGTH_LONG).show();
                    txtusu.setText("");
                    txtpass.setText("");
                    txtusu.findFocus();
                }

            }
        });
    }
}