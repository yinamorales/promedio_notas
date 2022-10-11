package com.example.promedio_notas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE "+ Constantes.NOMBRE_TABLA_USUARIO +
            "(NOMBRE TEXT NOT NULL,"+
            "CODIGO INTEGER NOT NULL)";

    public DbHelper(@Nullable Context context) {
        super(context, Constantes.NOMBRE_BD, null, Constantes.VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Creacion tabla USUARIO
        sqLiteDatabase.execSQL(CREAR_TABLA_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Elimina tabla si existe
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ Constantes.NOMBRE_TABLA_USUARIO);
        sqLiteDatabase.execSQL(CREAR_TABLA_USUARIO);


        //Creacion tabla
        sqLiteDatabase.execSQL(CREAR_TABLA_USUARIO);

    }
}
