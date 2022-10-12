package com.example.promedio_notas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class InformeActivity extends AppCompatActivity {
    TextView txtInforme;
    Button btnInicio;
    String usuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informe);

        txtInforme = findViewById(R.id.txtInforme);
        btnInicio = findViewById(R.id.btnHome);

        btnInicio.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        informe();




    }

    public void informe(){
        DbHelper con = new DbHelper(this);
        SQLiteDatabase bd = con.getReadableDatabase();



            Cursor fila = bd.rawQuery("SELECT * FROM "+ Constantes.NOMBRE_TABLA_USUARIO,null);

            fila.moveToFirst();

            do{
                String cod = fila.getString(0);
                String user = fila.getString(1);
                String nota = fila.getString(2);
                String report = fila.getString(3);
                txtInforme.setText("Codigo: "+cod+ " " + "Nombre: "+ user+ " " + "Nota: "+nota+" "+"Reporte: "+report);

            }while (fila.moveToNext());





    }

}