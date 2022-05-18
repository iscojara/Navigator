package com.example.navigator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.navigator.utilidades.Utilidades;

public class RegisterActivity extends AppCompatActivity {

    Button btnGrabar;
    EditText txtnom,txtaM,txtaP,txtcorreo,txtpass;
    //SQLiteOpenHelper helper = new SQLite_OpenHelper(this,"BD1",null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnGrabar = (Button) findViewById(R.id.RegisterUsuario);
        txtnom = (EditText) findViewById(R.id.txtNombreURegister);
        txtaP = (EditText) findViewById(R.id.txtApellidoPR);
        txtaM = (EditText) findViewById(R.id.txtApellidoMR);
        txtcorreo = (EditText) findViewById(R.id.txtCorreoR);
        txtpass = (EditText) findViewById(R.id.txtPasswordR);
        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(txtnom.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Complete el campo nombre",Toast.LENGTH_SHORT).show();
                }else if(txtaP.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Complete el campo aPaterno",Toast.LENGTH_SHORT).show();
                }else if(txtaM.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Complete el campo aMaterno",Toast.LENGTH_SHORT).show();
                }else if(txtcorreo.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Complete el campo correo",Toast.LENGTH_SHORT).show();
                } else if(txtpass.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Complete el campo password",Toast.LENGTH_SHORT).show();
                }else{
                    registrarUsuarios();
                }
            }
        });
    }

    private void registrarUsuarios() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values =  new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE,txtnom.getText().toString());
        values.put(Utilidades.CAMPO_APELLIDOP,txtaP.getText().toString());
        values.put(Utilidades.CAMPO_APELLIDOM,txtaM.getText().toString());
        values.put(Utilidades.CAMPO_CORREO,txtcorreo.getText().toString());
        values.put(Utilidades.CAMPO_PASSWORD,txtpass.getText().toString());

        Long idResultado = db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID,values);
        Toast.makeText(getApplicationContext(),"Id Registro: "+idResultado,Toast.LENGTH_LONG).show();
        db.close();
        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);
    }
}