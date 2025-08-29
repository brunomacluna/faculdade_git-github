package com.example.aula04;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView titulo = findViewById(R.id.textView);
        Button traduzirIngles = findViewById(R.id.ingles);
        Button traduzirPortugues = findViewById(R.id.button2);

        traduzirIngles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titulo.setText("No PEN, no gain");
            }

        });

        traduzirPortugues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titulo.setText("Sem dor não há ganho");
            }
        });
    }
}
