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
                if(txtusu.getText().toString().isEmpty() || txtpass.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Campos vacios",Toast.LENGTH_LONG).show();
                }else{
                    SQLiteDatabase db = conn.getReadableDatabase();
                    try {
                        Cursor cursor = db.rawQuery("select "+Utilidades.CAMPO_ID+
                                " from "+Utilidades.TABLA_USUARIO+
                                " where "+Utilidades.CAMPO_NOMBRE+"= '"+txtusu.getText().toString()+
                                "' and "+Utilidades.CAMPO_PASSWORD+"='"+txtpass.getText().toString()+"'",null);
                        if (cursor.moveToFirst()){
                            Intent i = new Intent(getApplicationContext(),MainActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putInt("key_user",cursor.getInt(0));
                            cursor.close();
                            i.putExtras(bundle);
                            startActivity(i);
                            conn.close();
                        }else{
                            Toast.makeText(getApplicationContext(),"Usuario y/0 Pass Incorrectos",Toast.LENGTH_LONG).show();
                            conn.close();
                        }
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),"Error en Consulta",Toast.LENGTH_LONG).show();
                        txtusu.setText("");
                        txtpass.setText("");
                        txtusu.findFocus();
                    }
                }

            }
        });
    }
}