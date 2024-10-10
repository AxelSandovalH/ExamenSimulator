package com.example.examensimulator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.examensimulator.MainActivity;

public class CalificarActivity extends AppCompatActivity {

    TextView nameTextView, materiaTextView, calificacionTextView, estadoTextView;
    Button volverButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificar);

        nameTextView = findViewById(R.id.nameTextView);
        materiaTextView = findViewById(R.id.materiaTextView);
        calificacionTextView = findViewById(R.id.calificacionTextView);
        estadoTextView = findViewById(R.id.estadoTextView);
        volverButton = findViewById(R.id.volverButton);

        // Recoge los datos pasados por el Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int exam = intent.getIntExtra("exam", 0);
        int p1 = intent.getIntExtra("p1", 0);
        int p2 = intent.getIntExtra("p2", 0);
        int p3 = intent.getIntExtra("p3", 0);
        int p4 = intent.getIntExtra("p4", 0);

        // Sumar respuestas correctas
        int correctAnswers = p1 + p2 + p3 + p4;
        float calificacion = correctAnswers * 2.5f;

        // Mostrar los datos en los TextView correspondientes
        nameTextView.setText("Nombre: " + name);
        materiaTextView.setText("Materia: " + (exam == 1 ? "Mate" : "Español"));
        calificacionTextView.setText("Calificación: " + calificacion);
        estadoTextView.setText(calificacion >= 6 ? "Aprobado" : "Reprobado");

        // Botón para volver al inicio
        volverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volverIntent = new Intent(CalificarActivity.this, MainActivity.class);
                startActivity(volverIntent);
            }
        });
    }
}

