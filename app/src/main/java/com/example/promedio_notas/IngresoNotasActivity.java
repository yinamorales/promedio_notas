package com.example.promedio_notas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IngresoNotasActivity extends AppCompatActivity {

    EditText Nota1, Nota2, Nota3, Nota4, Nota5;
    Button btnCalcularNotas;
    private float  Not1, Not2, Not3, Not4, Not5;
    private float promedio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_notas);
        String recover_name = getIntent().getStringExtra("Nombre");
        String recover_code = getIntent().getStringExtra("Codigo");
        Nota1 = findViewById(R.id.eTxtNot1);
        Nota2 = findViewById(R.id.eTxtNot2);
        Nota3 = findViewById(R.id.eTxtNot3);
        Nota4 = findViewById(R.id.eTxtNot4);
        Nota5 = findViewById(R.id.eTxtNot5);
        btnCalcularNotas = findViewById(R.id.btnCalNotas);

        Not1 = Float.parseFloat(Nota1.getText().toString());
        Not2 = Float.parseFloat(Nota2.getText().toString());
        Not3 = Float.parseFloat(Nota3.getText().toString());
        Not4 = Float.parseFloat(Nota4.getText().toString());
        Not5 = Float.parseFloat(Nota5.getText().toString());


        System.out.println(recover_name);
        System.out.println(recover_code);

        btnCalcularNotas.setOnClickListener(view -> {

            promedio = (Not1 + Not2 + Not3 + Not4 + Not5) / 5;
            if(promedio >= 3 ){
                Toast.makeText(this, "Aprobo la asignatura", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Reprobo la asignatura", Toast.LENGTH_LONG).show();

            }
        });
    }
}