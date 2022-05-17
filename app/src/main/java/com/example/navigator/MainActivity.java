package com.example.navigator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.navigator.Fragments.MainFragment;
import com.example.navigator.utilidades.Utilidades;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    TextView user,correo;
    int usuario;
    // variables para fragment
    MainFragment mainFragment = new MainFragment();
    Bundle bundletofragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    //Para Login
    ConexionSQLiteHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        // establecer evento onclick al navigationView
        navigationView.setNavigationItemSelectedListener(this);
        //obteniendo los datos de usuario
        conn = new ConexionSQLiteHelper(this,"bd_usuarios",null,1);

        View header = navigationView.getHeaderView(0);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            usuario = bundle.getInt("key_user");
            Bundle bundletofragment = new Bundle();
            bundletofragment.putInt("key_usuariof",usuario);
            String[] campos = {Utilidades.CAMPO_NOMBRE,",",Utilidades.CAMPO_APELLIDOP,",",Utilidades.CAMPO_APELLIDOM,",",Utilidades.CAMPO_CORREO};
            try {
                SQLiteDatabase db = conn.getReadableDatabase();
                Cursor cursor = db.rawQuery("select "+Utilidades.CAMPO_NOMBRE+","+
                        Utilidades.CAMPO_APELLIDOP+","+Utilidades.CAMPO_APELLIDOM+
                        ","+Utilidades.CAMPO_CORREO+" from "+Utilidades.TABLA_USUARIO+
                        " where "+Utilidades.CAMPO_ID+"="+usuario,null);
                if(cursor.moveToFirst()){
                    user = (TextView) header.findViewById(R.id.headerNombre);
                    correo = (TextView) header.findViewById(R.id.headerCorreo);
                    user.setText(cursor.getString(0)+" "+cursor.getString(1)+" "+cursor.getString(2));
                    correo.setText(cursor.getString(3));
                    cursor.close();
                    conn.close();
                }
            }catch (Exception e){
            }
        }

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setTitle("Puntos de Ventas");
        //Cargar Fragment Principal
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container,new MainFragment());
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if(item.getItemId() == R.id.home){

            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container,mainFragment);
            mainFragment.setArguments(bundletofragment);
            fragmentTransaction.commit();
        }
        if(item.getItemId() == R.id.logout){
            Intent i = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(i);
            finish();
        }
        return false;
    }
}