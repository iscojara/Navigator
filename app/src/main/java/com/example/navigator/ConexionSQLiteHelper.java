package com.example.navigator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.navigator.utilidades.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {
    public ConexionSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_USUARIO);
        db.execSQL("insert into "+Utilidades.TABLA_USUARIO+" ('"+Utilidades.CAMPO_NOMBRE+"','"+
                Utilidades.CAMPO_APELLIDOP+"', '"+Utilidades.CAMPO_APELLIDOM+"','"
                +Utilidades.CAMPO_CORREO+"','"+Utilidades.CAMPO_PASSWORD+"' ) " +
                "values('francisco','ocana','jara','iscojara14@gmail.com','123');");
        db.execSQL(Utilidades.CREAR_TABLA_PUNTOSV);
        db.execSQL("insert into "+Utilidades.TABLA_PUNTOSV+" ('"+Utilidades.CAMPO_NOMBRE_PUNTOV+"','"+
                Utilidades.CAMPO_CODIGO_PUNTOV+"', '"+Utilidades.CAMPO_DIRECCION_PUNTOV+"',"
                +Utilidades.CAMPO_LATITUDE+","+Utilidades.CAMPO_AMPLITUDE+" ) " +
                "values('YOSELY AMALI SEGUILAR','409138','REAL S/N Urb ESQ. 10 NOVIEMBRE'," +
                "-12.106447165352808, -77.03948120290903)");
        db.execSQL("insert into "+Utilidades.TABLA_PUNTOSV+" ('"+Utilidades.CAMPO_NOMBRE_PUNTOV+"','"+
                Utilidades.CAMPO_CODIGO_PUNTOV+"', '"+Utilidades.CAMPO_DIRECCION_PUNTOV+"',"
                +Utilidades.CAMPO_LATITUDE+","+Utilidades.CAMPO_AMPLITUDE+" ) " +
                "values('METRO ALFONSO UGARTE','409138','AV. ALFONSO UGARTE 740'," +
                "-12.05376734580166, -77.04312230290961)");
        db.execSQL("insert into "+Utilidades.TABLA_PUNTOSV+" ('"+Utilidades.CAMPO_NOMBRE_PUNTOV+"','"+
                Utilidades.CAMPO_CODIGO_PUNTOV+"', '"+Utilidades.CAMPO_DIRECCION_PUNTOV+"',"
                +Utilidades.CAMPO_LATITUDE+","+Utilidades.CAMPO_AMPLITUDE+" ) " +
                "values('TOTTUS ZORRITOS','409138','AV. COLONIAL 1520'," +
                "-12.047939471224868, -77.0586774029097)");
        // Para tabla productos
        db.execSQL(Utilidades.CREAR_TABLA_PRODUCTO);
        db.execSQL("insert into "+Utilidades.TABLA_PRODUCTO+" ('"+Utilidades.CAMPO_NOMBREP+"','"+
                Utilidades.CAMPO_PRECIOP+"', '"+Utilidades.CAMPO_PRUTAP+"',"
                +Utilidades.CAMPO_STOCKP+","+Utilidades.CAMPO_PRODUCTOIDTIENDA+" ) " +
                "values('AZUCAR RUBIA BOLSA',54.43,45.42,300, 1)");
        db.execSQL("insert into "+Utilidades.TABLA_PRODUCTO+" ('"+Utilidades.CAMPO_NOMBREP+"','"+
                Utilidades.CAMPO_PRECIOP+"', '"+Utilidades.CAMPO_PRUTAP+"',"
                +Utilidades.CAMPO_STOCKP+","+Utilidades.CAMPO_PRODUCTOIDTIENDA+" ) " +
                "values('AZUCAR BLANCA BOLSA',54.43,45.44,100, 3)");
        db.execSQL("insert into "+Utilidades.TABLA_PRODUCTO+" ('"+Utilidades.CAMPO_NOMBREP+"','"+
                Utilidades.CAMPO_PRECIOP+"', '"+Utilidades.CAMPO_PRUTAP+"',"
                +Utilidades.CAMPO_STOCKP+","+Utilidades.CAMPO_PRODUCTOIDTIENDA+" ) " +
                "values('LECHE',54.43,45.52,300, 1)");
        db.execSQL("insert into "+Utilidades.TABLA_PRODUCTO+" ('"+Utilidades.CAMPO_NOMBREP+"','"+
                Utilidades.CAMPO_PRECIOP+"', '"+Utilidades.CAMPO_PRUTAP+"',"
                +Utilidades.CAMPO_STOCKP+","+Utilidades.CAMPO_PRODUCTOIDTIENDA+" ) " +
                "values('CHOCOLATE',54.43,45.42,400, 3)");
        db.execSQL("insert into "+Utilidades.TABLA_PRODUCTO+" ('"+Utilidades.CAMPO_NOMBREP+"','"+
                Utilidades.CAMPO_PRECIOP+"', '"+Utilidades.CAMPO_PRUTAP+"',"
                +Utilidades.CAMPO_STOCKP+","+Utilidades.CAMPO_PRODUCTOIDTIENDA+" ) " +
                "values('DURAZNOS',54.43,45.42,30, 1)");
        db.execSQL("insert into "+Utilidades.TABLA_PRODUCTO+" ('"+Utilidades.CAMPO_NOMBREP+"','"+
                Utilidades.CAMPO_PRECIOP+"', '"+Utilidades.CAMPO_PRUTAP+"',"
                +Utilidades.CAMPO_STOCKP+","+Utilidades.CAMPO_PRODUCTOIDTIENDA+" ) " +
                "values('CHANTILLI',54.43,45.42,3, 1)");
        db.execSQL("insert into "+Utilidades.TABLA_PRODUCTO+" ('"+Utilidades.CAMPO_NOMBREP+"','"+
                Utilidades.CAMPO_PRECIOP+"', '"+Utilidades.CAMPO_PRUTAP+"',"
                +Utilidades.CAMPO_STOCKP+","+Utilidades.CAMPO_PRODUCTOIDTIENDA+" ) " +
                "values('QUESO',54.43,45.42,60, 3)");
        db.execSQL("insert into "+Utilidades.TABLA_PRODUCTO+" ('"+Utilidades.CAMPO_NOMBREP+"','"+
                Utilidades.CAMPO_PRECIOP+"', '"+Utilidades.CAMPO_PRUTAP+"',"
                +Utilidades.CAMPO_STOCKP+","+Utilidades.CAMPO_PRODUCTOIDTIENDA+" ) " +
                "values('SANDIA',54.43,45.42,70, 3)");
        db.execSQL("insert into "+Utilidades.TABLA_PRODUCTO+" ('"+Utilidades.CAMPO_NOMBREP+"','"+
                Utilidades.CAMPO_PRECIOP+"', '"+Utilidades.CAMPO_PRUTAP+"',"
                +Utilidades.CAMPO_STOCKP+","+Utilidades.CAMPO_PRODUCTOIDTIENDA+" ) " +
                "values('AZUCAR RUBIA BOLSA',54.43,45.42,40, 3)");
        db.execSQL("insert into "+Utilidades.TABLA_PRODUCTO+" ('"+Utilidades.CAMPO_NOMBREP+"','"+
                Utilidades.CAMPO_PRECIOP+"', '"+Utilidades.CAMPO_PRUTAP+"',"
                +Utilidades.CAMPO_STOCKP+","+Utilidades.CAMPO_PRODUCTOIDTIENDA+" ) " +
                "values('CARAMELOS',54.43,45.42,500, 3)");
        db.execSQL("insert into "+Utilidades.TABLA_PRODUCTO+" ('"+Utilidades.CAMPO_NOMBREP+"','"+
                Utilidades.CAMPO_PRECIOP+"', '"+Utilidades.CAMPO_PRUTAP+"',"
                +Utilidades.CAMPO_STOCKP+","+Utilidades.CAMPO_PRODUCTOIDTIENDA+" ) " +
                "values('PAPA CANCHAY',54.43,45.42,400, 3)");
        db.execSQL("insert into "+Utilidades.TABLA_PRODUCTO+" ('"+Utilidades.CAMPO_NOMBREP+"','"+
                Utilidades.CAMPO_PRECIOP+"', '"+Utilidades.CAMPO_PRUTAP+"',"
                +Utilidades.CAMPO_STOCKP+","+Utilidades.CAMPO_PRODUCTOIDTIENDA+" ) " +
                "values('TOMATE',54.43,45.42,30, 3)");
        db.execSQL("insert into "+Utilidades.TABLA_PRODUCTO+" ('"+Utilidades.CAMPO_NOMBREP+"','"+
                Utilidades.CAMPO_PRECIOP+"', '"+Utilidades.CAMPO_PRUTAP+"',"
                +Utilidades.CAMPO_STOCKP+","+Utilidades.CAMPO_PRODUCTOIDTIENDA+" ) " +
                "values('AZUCAR RUBIA BOLSA',54.43,45.42,30, 3)");
        db.execSQL("insert into "+Utilidades.TABLA_PRODUCTO+" ('"+Utilidades.CAMPO_NOMBREP+"','"+
                Utilidades.CAMPO_PRECIOP+"', '"+Utilidades.CAMPO_PRUTAP+"',"
                +Utilidades.CAMPO_STOCKP+","+Utilidades.CAMPO_PRODUCTOIDTIENDA+" ) " +
                "values('PIÑA',54.43,45.42,320, 2)");
        db.execSQL("insert into "+Utilidades.TABLA_PRODUCTO+" ('"+Utilidades.CAMPO_NOMBREP+"','"+
                Utilidades.CAMPO_PRECIOP+"', '"+Utilidades.CAMPO_PRUTAP+"',"
                +Utilidades.CAMPO_STOCKP+","+Utilidades.CAMPO_PRODUCTOIDTIENDA+" ) " +
                "values('AJIES',54.43,45.42,320, 2)");
        db.execSQL("insert into "+Utilidades.TABLA_PRODUCTO+" ('"+Utilidades.CAMPO_NOMBREP+"','"+
                Utilidades.CAMPO_PRECIOP+"', '"+Utilidades.CAMPO_PRUTAP+"',"
                +Utilidades.CAMPO_STOCKP+","+Utilidades.CAMPO_PRODUCTOIDTIENDA+" ) " +
                "values('MEMBRILLO',54.43,45.42,100, 2)");
        db.execSQL("insert into "+Utilidades.TABLA_PRODUCTO+" ('"+Utilidades.CAMPO_NOMBREP+"','"+
                Utilidades.CAMPO_PRECIOP+"', '"+Utilidades.CAMPO_PRUTAP+"',"
                +Utilidades.CAMPO_STOCKP+","+Utilidades.CAMPO_PRODUCTOIDTIENDA+" ) " +
                "values('CALABAZA',54.43,45.42,300, 2)");
        db.execSQL("insert into "+Utilidades.TABLA_PRODUCTO+" ('"+Utilidades.CAMPO_NOMBREP+"','"+
                Utilidades.CAMPO_PRECIOP+"', '"+Utilidades.CAMPO_PRUTAP+"',"
                +Utilidades.CAMPO_STOCKP+","+Utilidades.CAMPO_PRODUCTOIDTIENDA+" ) " +
                "values('PELOTA',54.43,45.42,300, 2)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS puntosventas");
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS producto");
        onCreate(db);
    }
}
