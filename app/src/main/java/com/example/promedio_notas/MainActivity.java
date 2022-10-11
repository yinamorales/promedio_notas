package com.example.promedio_notas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnInsertNot, btnInf;
    EditText eTxTNom, eTxTCod;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsertNot = findViewById(R.id.btnInsertNotas);
        btnInf = findViewById(R.id.btnInforme);
        eTxTNom =  findViewById(R.id.txtNombre);
        eTxTCod = findViewById(R.id.eTxTCod);

        if (!eTxTNom.getText().equals("") || !eTxTCod.getText().equals("")){
            btnInsertNot.setOnClickListener(view -> {
                Intent intent = new Intent(this,IngresoNotasActivity.class);

                startActivity(intent);
            });
        }else{
            Toast.makeText(this, "Campos vacios", Toast.LENGTH_LONG).show();
        }
    }

    public void registrarUsuario(){
        try {
            //conexion  con la bd
            DbHelper helper = new DbHelper(this);

            //obj para la interaccioncon la base de datos
            SQLiteDatabase datos = helper.getWritableDatabase();

            //inserccion con bd
            ContentValues values = new ContentValues();
            values.put("NOMBRE",eTxTNom.getText().toString());
            values.put("CODIGO", Integer.parseInt(eTxTCod.getText().toString()));

            //insertar dato
            long id = datos.insert(Constantes.NOMBRE_TABLA_USUARIO, null,values);
            datos.close();

            if(id>0){
                Toast.makeText(this, "REGISTRO DE USUARIO CREADO", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(this, MainActivity.class);
                intent.putExtra("NOMBRE", eTxTNom.getText().toString());
                startActivity(intent);
            }
            else {
            }

        }
        catch (Exception e){
            Toast.makeText(this, "NO FUE POSIBLE REGISTRAR LA INFORMACION", Toast.LENGTH_LONG).show();
        }
    }
}