package com.example.examensimulator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MateActivity extends AppCompatActivity {

    RadioGroup p1RadioGroup;
    // Añade más RadioGroups para las demás preguntas

    Button calificarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mate);

        p1RadioGroup = findViewById(R.id.preguntaOneRadioGroup);
        // Inicializa los RadioGroups de las otras preguntas R.id.p1RadioGroup

        calificarButton = findViewById(R.id.calificarBtn);

        calificarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p1Answer = p1RadioGroup.getCheckedRadioButtonId() == R.id.preguntaOneTwo ? 1 : 0;
                // Similarmente calcula las demás respuestas

                Intent intent = new Intent(MateActivity.this, com.example.examensimulator.CalificarActivity.class);
                intent.putExtra("exam", 1);
                intent.putExtra("p1", p1Answer);
                // Pasa las respuestas restantes
                startActivity(intent);
            }
        });
    }
}
