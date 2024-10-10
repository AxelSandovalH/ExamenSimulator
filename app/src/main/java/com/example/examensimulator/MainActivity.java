package com.example.examensimulator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText;
    RadioGroup examRadioGroup;
    Button contestarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        examRadioGroup = findViewById(R.id.examRadioGroup);
        contestarButton = findViewById(R.id.contestarButton);

        contestarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                int selectedExamId = examRadioGroup.getCheckedRadioButtonId();

                if (selectedExamId == R.id.mateRadioButton) {
                    Intent intent = new Intent(MainActivity.this, com.example.examensimulator.MateActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("exam", 1);
                    startActivity(intent);
                } else if (selectedExamId == R.id.espanolRadioButton) {
                    Intent intent = new Intent(MainActivity.this, EspañolActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("exam", 2);
                    startActivity(intent);
                }
            }
        });
    }
}
