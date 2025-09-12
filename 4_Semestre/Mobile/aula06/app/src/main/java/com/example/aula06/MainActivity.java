package com.example.aula06;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText nota01;
    private EditText nota02;
    private Button calcular;
    private TextView mediaFinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
        nota01 = findViewById(R.id.editTextNota01);
        nota02 = findViewById(R.id.editTextNota02);
        calcular = findViewById(R.id.button01);
        mediaFinal = findViewById(R.id.textViewNotaFinal);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nota01Str = nota01.getText().toString();
                String nota02Str = nota02.getText().toString();

                float nota01Float = Float.parseFloat(nota01Str);
                float nota02Float = Float.parseFloat(nota02Str);

                float mediaPonderada = calcularMediaPonderada(nota01Float, nota02Float);
                mediaFinal.setText("A media final do aluno foi: "+ mediaPonderada);
            }
        });


    }
    public float calcularMediaPonderada(float nota01, float nota02){
        return ((nota01 * 4) + (nota02 * 6)) / 10;
    }
}