package com.example.promedio_notas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IngresoNotasActivity extends AppCompatActivity {

    Button btnCalcularNotas;
    EditText eTxtNota1,eTxtNota2,eTxtNota3,eTxtNota4, eTxtNota5;
    double Not1, Not2, Not3, Not4, Not5, promedio;
    String recover_name, recover_cod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_notas);


        btnCalcularNotas = findViewById(R.id.btnCalNotas);
        eTxtNota1 = findViewById(R.id.eTxtNota1);
        eTxtNota2 = findViewById(R.id.eTxtNota2);
        eTxtNota3 = findViewById(R.id.eTxtNota3);
        eTxtNota4 = findViewById(R.id.eTxtNota4);
        eTxtNota5 = findViewById(R.id.eTxtNota5);

        recover_name = getIntent().getStringExtra("NOMBRE");
        recover_cod = getIntent().getStringExtra("CODIGO");

        btnCalcularNotas.setOnClickListener(view -> {
            promedio();
        });

    }


    public void promedio(){

        Not1 = Double.parseDouble(eTxtNota1.getText().toString());
        Not2 = Double.parseDouble(eTxtNota2.getText().toString());
        Not3 = Double.parseDouble(eTxtNota3.getText().toString());
        Not4 = Double.parseDouble(eTxtNota4.getText().toString());
        Not5 = Double.parseDouble(eTxtNota5.getText().toString());

        promedio = (Not1 + Not2 + Not3 + Not4 + Not5) / 5;
        if(promedio >= 3){
            Toast.makeText(this, "Aprobo la asignatura con "+promedio, Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Reprobo la asignatura con "+promedio, Toast.LENGTH_LONG).show();

        }
        registrarUsuario();
    }

    public void registrarUsuario(){
        try {
            //conexion  con la bd
            DbHelper helper = new DbHelper(this);

            //obj para la interaccioncon la base de datos
            SQLiteDatabase datos = helper.getWritableDatabase();

            //inserccion con bd
            ContentValues values = new ContentValues();
            values.put("NOMBRE", recover_name);
            values.put("CODIGO", recover_cod);
            values.put("NOTA", promedio);
            datos.insert("USUARIOS", null, values);



            /*/insertar dato
            long id = datos.insert(Constantes.NOMBRE_TABLA_USUARIO, null,values);
            datos.close();*/



        }
        catch (Exception e){
            Toast.makeText(this, "NO FUE POSIBLE REGISTRAR LA INFORMACION", Toast.LENGTH_LONG).show();
        }
    }
}