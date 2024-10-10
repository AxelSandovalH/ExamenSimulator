package com.example.examensimulator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MateActivity extends AppCompatActivity {

    RadioGroup p1RadioGroup, p2RadioGroup, p3RadioGroup, p4RadioGroup; // Añadimos las otras preguntas

    Button calificarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mate);

        // Inicializa los RadioGroups para las 4 preguntas
        p1RadioGroup = findViewById(R.id.preguntaOneRadioGroup);
        p2RadioGroup = findViewById(R.id.preguntaTwoRadioGroup);
        p3RadioGroup = findViewById(R.id.preguntaThreeRadioGroup);
        p4RadioGroup = findViewById(R.id.preguntaFourRadioGroup);

        calificarButton = findViewById(R.id.calificarBtn);

        calificarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica cuál opción está seleccionada para cada pregunta
                int p1Answer = p1RadioGroup.getCheckedRadioButtonId() == R.id.preguntaOneTwo ? 1 : 0; // Respuesta correcta es 2 (4)
                int p2Answer = p2RadioGroup.getCheckedRadioButtonId() == R.id.preguntaTwoTwo ? 1 : 0; // Respuesta correcta es 2 (2)
                int p3Answer = p3RadioGroup.getCheckedRadioButtonId() == R.id.preguntaThreeTwo ? 1 : 0; // Respuesta correcta es 2 (9)
                int p4Answer = p4RadioGroup.getCheckedRadioButtonId() == R.id.preguntaFourTwo ? 1 : 0; // Respuesta correcta es 2 (2)

                // Extraer el nombre del Intent
                String nombreUsuario = getIntent().getStringExtra("name");

                // Crea un intent para pasar las respuestas a la actividad de calificación
                Intent intent = new Intent(MateActivity.this, CalificarActivity.class);
                intent.putExtra("exam", 1); // Identifica que es el examen de matemáticas
                intent.putExtra("p1", p1Answer);
                intent.putExtra("p2", p2Answer);
                intent.putExtra("p3", p3Answer);
                intent.putExtra("p4", p4Answer);
                intent.putExtra("name", nombreUsuario); // Pasa el nombre también

                startActivity(intent); // Inicia la actividad de calificación
            }

        });
    }
}
