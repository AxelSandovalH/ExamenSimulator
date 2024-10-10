package com.example.examensimulator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class EspañolActivity extends AppCompatActivity {

    RadioGroup p1RadioGroup, p2RadioGroup, p3RadioGroup, p4RadioGroup;
    Button calificarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espanol);  // Asegúrate de que el archivo XML se llame activity_espanol

        // Inicializa los RadioGroups
        p1RadioGroup = findViewById(R.id.preguntaOneEspRadioGroup);
        p2RadioGroup = findViewById(R.id.preguntaTwoEspRadioGroup);
        p3RadioGroup = findViewById(R.id.preguntaThreeEspRadioGroup);
        p4RadioGroup = findViewById(R.id.preguntaFourEspRadioGroup);

        calificarButton = findViewById(R.id.calificarEspBtn);

        // Obtener el nombre desde el Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        calificarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica cuál opción está seleccionada para cada pregunta
                int p1Answer = p1RadioGroup.getCheckedRadioButtonId() == R.id.preguntaOneEspOption2 ? 1 : 0; // Respuesta correcta es "corre"
                int p2Answer = p2RadioGroup.getCheckedRadioButtonId() == R.id.preguntaTwoEspOption2 ? 1 : 0; // Respuesta correcta es "Contento"
                int p3Answer = p3RadioGroup.getCheckedRadioButtonId() == R.id.preguntaThreeEspOption2 ? 1 : 0; // Respuesta correcta es "rojo"
                int p4Answer = p4RadioGroup.getCheckedRadioButtonId() == R.id.preguntaFourEspOption1 ? 1 : 0; // Respuesta correcta es "Verbo"

                // Crea un intent para pasar las respuestas a la actividad de calificación
                Intent intent = new Intent(EspañolActivity.this, CalificarActivity.class);
                intent.putExtra("exam", 2); // Identifica que es el examen de español
                intent.putExtra("p1", p1Answer);
                intent.putExtra("p2", p2Answer);
                intent.putExtra("p3", p3Answer);
                intent.putExtra("p4", p4Answer);

                // Pasa el nombre también a la actividad de calificación
                intent.putExtra("name", name);

                startActivity(intent); // Inicia la actividad de calificación
            }
        });
    }
}
