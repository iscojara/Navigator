package com.example.navigator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navigator.utilidades.Utilidades;

import java.io.File;
import java.io.IOException;

public class CamaraActivity extends AppCompatActivity {
    TextView txt_lugar,txt_detalle;
    ImageView imgRegresar,imgCaptura;
    Button btnVisitarTienda;
    TextView txtDireccion_lugar;
    String rutaImagen;
    Bundle bundle;
    int idf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);
        Toast.makeText(getApplicationContext(),"Click sobre nombre ciudad",Toast.LENGTH_LONG).show();
        btnVisitarTienda = (Button) findViewById(R.id.btnVisitarTienda);
        txtDireccion_lugar = findViewById(R.id.txtDireccion_lugar);
        imgCaptura = (ImageView) findViewById(R.id.ImgCaptura);
        txtDireccion_lugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCamara();
            }


        });

        bundle = getIntent().getExtras();
        if(bundle!=null){
            String lugarf = bundle.getString("key_tienda");
            String detallef = bundle.getString("key_direccion");
            idf = bundle.getInt("key_id");
            txt_lugar = (TextView) findViewById(R.id.txtDireccion_lugar);
            txt_detalle = (TextView) findViewById(R.id.txtDireccion_detalle);
            txt_lugar.setText(lugarf);
            txt_detalle.setText(detallef);
        }
        btnVisitarTienda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),ProductoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("key_id",idf);
                it.putExtras(bundle);
                startActivity(it);
            }
        });
        imgRegresar = (ImageView) findViewById(R.id.imgRegresar);
        imgRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
    private void abrirCamara() {
        Intent intentc = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //if(intentc.resolveActivity(getPackageManager())!=null){
            File imagenArchivo = null;
            try {
                imagenArchivo = crearImagen();
            }catch (IOException ex){
                Log.e("Error",ex.toString());
            }
            if(imagenArchivo != null){
                Uri fotoUri = FileProvider.getUriForFile(this,"com.example.navigatior.fileprovider",imagenArchivo);
                intentc.putExtra(MediaStore.EXTRA_OUTPUT,fotoUri);
                startActivityForResult(intentc,1);
            }
        //}
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            //Bundle extras = data.getExtras();
            Bitmap imgBitmap = BitmapFactory.decodeFile(rutaImagen);
            imgCaptura.setImageBitmap(imgBitmap);
        }
    }
    private File crearImagen() throws IOException {
        String nombreImagen = "foto_";
        File directorio = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File imagen = File.createTempFile(nombreImagen,".jpg",directorio);

        rutaImagen = imagen.getAbsolutePath();
        return  imagen;
    }
}