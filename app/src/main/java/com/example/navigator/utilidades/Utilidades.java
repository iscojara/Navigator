package com.example.navigator.utilidades;

public class Utilidades {

    //Constantes campos tabla usuario
    public static final  String TABLA_USUARIO = "usuario";
    public static final  String CAMPO_ID = "id";
    public  static final  String CAMPO_NOMBRE = "nombre";
    public static final  String CAMPO_APELLIDOP = "apellidoP";
    public static final  String CAMPO_APELLIDOM = "apellidoM";
    public static final  String CAMPO_CORREO = "correo";
    public static final  String CAMPO_PASSWORD = "password";
    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE "+
            TABLA_USUARIO+"("+CAMPO_ID+" INTEGER primary key autoincrement,"
            +CAMPO_NOMBRE+" TEXT,"+CAMPO_APELLIDOP+
            " text,"+CAMPO_APELLIDOM+" text,"+CAMPO_CORREO+
            " text, "+CAMPO_PASSWORD+" text)";
    //Constantes campos tabla Puntoventas
    public static final  String TABLA_PUNTOSV = "puntosventas";
    public static final  String CAMPO_ID_PUNTOV = "id";
    public  static final  String CAMPO_NOMBRE_PUNTOV = "nombre";
    public static final  String CAMPO_CODIGO_PUNTOV = "codigo";
    public static final  String CAMPO_DIRECCION_PUNTOV = "direccion";
    public static final  String CAMPO_LATITUDE = "latitud";
    public static final  String CAMPO_AMPLITUDE = "amplitud";
    public static final String CREAR_TABLA_PUNTOSV = "CREATE TABLE "+
            TABLA_PUNTOSV+"("+CAMPO_ID_PUNTOV+" INTEGER primary key autoincrement,"
            +CAMPO_NOMBRE_PUNTOV+" TEXT,"+CAMPO_CODIGO_PUNTOV+" TEXT,"+CAMPO_DIRECCION_PUNTOV+
            " text,"+CAMPO_LATITUDE+" DOUBLE,"+CAMPO_AMPLITUDE+" DOUBLE)";
    //Constantes campos tabla Productos
    public static final  String TABLA_PRODUCTO = "producto";
    public static final  String CAMPO_IDP = "id";
    public  static final  String CAMPO_NOMBREP = "nombre";
    public static final  String CAMPO_PRECIOP = "precio";
    public static final  String CAMPO_PRUTAP = "pruta";
    public static final  String CAMPO_STOCKP = "stock";
    public static final  String CAMPO_PRODUCTOIDTIENDA = "idTienda";
    public static final String CREAR_TABLA_PRODUCTO = "CREATE TABLE "+
            TABLA_PRODUCTO+"("+CAMPO_IDP+" INTEGER primary key autoincrement,"
            +CAMPO_NOMBREP+" TEXT,"+CAMPO_PRECIOP+" DOUBLE,"+CAMPO_PRUTAP+
            " DOUBLE,"+CAMPO_STOCKP+" INTEGER,"+CAMPO_PRODUCTOIDTIENDA+" INTEGER)";

}
