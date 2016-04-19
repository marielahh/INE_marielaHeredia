package com.example.mariela.proyectoandroid1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;


public class Base_datos extends SQLiteOpenHelper
{
    public static final String NOMBREBD = "carrito.sqlite";
    public static final int VERSION = 1;
    //Versión de la base de datos
    public Base_datos(Context context)
    {
        super(context, NOMBREBD, null, VERSION);

    }

    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table producto (_id integer primary key autoincrement not null, producto text, precio integer,cantidad integer);");
        db.execSQL("create table cliente (_id integer primary key autoincrement not null, nombres varchar, apellidos varchar, nrodocumento varchar,usuario varchar, contrasena varchar,rol varchar);");
        db.execSQL("create table pedido (_id integer primary key autoincrement not null, id_producto integer, id_cliente integer,cant_pedido integer,fechapedido date);");
        db.execSQL("insert into  producto (producto,precio,cantidad) values('Monitor','670','5');");
        db.execSQL("insert into  producto (producto,precio,cantidad) values('Teclado','89','10');");
        db.execSQL("insert into  producto (producto,precio,cantidad) values('Mouse','70','8');");

        //Log.d("Todos los tablas: ", "Se crearon las tablas");
    }

    //Método utilizado cuando se actualiza la base de datos
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    public void insert(String tabla, String[] variables,String[] valores)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues insertar = new ContentValues();
        for(int i=0;i<variables.length;i++)
        {
            insertar.put(variables[i].toString(), valores[i].toString());
        }
        database.insert(tabla,null, insertar);

    }



}