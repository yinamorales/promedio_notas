package com.example.promedio_notas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IngresoNotasActivity extends AppCompatActivity {

    Button btnCalcularNotas;
    EditText eTxtNota1,eTxtNota2,eTxtNota3,eTxtNota4, eTxtNota5;
    private float Not1, Not2, Not3, Not4, Not5, promedio;

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

        Not1 = Float.parseFloat(eTxtNota1.getText().toString());
        Not2 = Float.parseFloat(eTxtNota2.getText().toString());
        Not3 = Float.parseFloat(eTxtNota3.getText().toString());
        Not4 = Float.parseFloat(eTxtNota4.getText().toString());
        Not5 = Float.parseFloat(eTxtNota5.getText().toString());


        btnCalcularNotas.setOnClickListener(view -> {

            promedio = (Not1 + Not2 + Not3 + Not4 + Not5) / 5;
            if(promedio >= 3){
                Toast.makeText(this, "Aprobo la asignatura con "+promedio, Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Aprobo la asignatura con "+promedio, Toast.LENGTH_LONG).show();

            }
        });

    }
}