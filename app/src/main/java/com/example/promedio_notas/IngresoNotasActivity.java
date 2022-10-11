package com.example.promedio_notas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class IngresoNotasActivity extends AppCompatActivity {

    Button btnCalcularNotas;
    EditText eTxtNota1,eTxtNota2,eTxtNota3,eTxtNota4, eTxtNota5;

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


        btnCalcularNotas.setOnClickListener(view -> {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        });

    }
}