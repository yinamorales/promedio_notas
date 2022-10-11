package com.example.promedio_notas;

import androidx.appcompat.app.AppCompatActivity;

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



            });
        }else{
            Toast.makeText(this, "Campos vacios", Toast.LENGTH_LONG).show();

        }


    }
}