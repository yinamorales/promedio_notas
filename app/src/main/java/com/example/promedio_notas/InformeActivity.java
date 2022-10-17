package com.example.promedio_notas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class InformeActivity extends AppCompatActivity {
    TextView txtInforme;
    Button btnInicio;
    ListView listviewUsuarios;



    Usuario usuario = new Usuario();
    DbHelper con = new DbHelper(this);


    ArrayList<String> listInfo; //= new ArrayList<String>();
    ArrayList<Usuario> listInforme = new ArrayList<Usuario>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informe);

        txtInforme = findViewById(R.id.txtInforme);
        btnInicio = findViewById(R.id.btnHome);
        listviewUsuarios = findViewById(R.id.listViewUsuarios);

        btnInicio.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });


        informe();

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listInfo);
        listviewUsuarios.setAdapter(adaptador);

    }

    public void informe(){

        usuario = null;

        SQLiteDatabase bd = con.getReadableDatabase();

       Cursor fila = bd.rawQuery("SELECT * FROM "+ Constantes.NOMBRE_TABLA_USUARIO,null);

       while (fila.moveToNext()){

           usuario = new Usuario();

           usuario.setCODIGO(fila.getInt(0));
           usuario.setNOMBRE(fila.getString(1));
           usuario.setNOTA(fila.getString(2));
           usuario.setAPROBAR(fila.getString(3));

           listInforme.add(usuario);

           mostrarInforme();

       }

    }

    private void mostrarInforme() {

        listInfo = new ArrayList<String>();


        for ( int i=0 ; i< listInforme.size();i++){
            listInfo.add(listInforme.get(i).getCODIGO()+" - "
                    + listInforme.get(i).getNOMBRE()+" - "
                    + listInforme.get(i).getNOTA() + " - "
                    + listInforme.get(i).getAPROBAR());
        }
    }


}