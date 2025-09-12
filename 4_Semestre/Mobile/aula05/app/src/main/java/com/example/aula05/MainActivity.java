package com.example.aula05;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText nota01 = findViewById(R.id.editTextNota01);
        EditText nota02 = findViewById(R.id.editTextNota02);
        EditText nota03 = findViewById(R.id.editTextNota03);
        Button calcular = findViewById(R.id.buttonCalcular);
        TextView resultado = findViewById(R.id.textViewResultado);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nota01Str = nota01.getText().toString();
                String nota02Str = nota02.getText().toString();
                String nota03Str = nota03.getText().toString();

                float notaFloat01 = Float.parseFloat(nota01Str);
                float notaFloat02 = Float.parseFloat(nota02Str);
                float notaFloat03 = Float.parseFloat(nota03Str);

                float notaFinal = ((notaFloat01 * 3) + (notaFloat02 * 3) + (notaFloat03 * 4)) / 10;

                resultado.setText("A nota final do aluno foi: "+ notaFinal);
            }
        });
    }
}
