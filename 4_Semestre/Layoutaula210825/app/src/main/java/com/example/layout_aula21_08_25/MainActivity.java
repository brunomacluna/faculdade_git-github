package com.example.layout_aula21_08_25;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView titulo = findViewById(R.id.textViewTitulo);
        TextView subtitulo = findViewById(R.id.textViewSubtitulo);

        titulo.setText("Ola, mundo!!!");
        subtitulo.setText("Bem vindo ao ultimo semestre. Não falte mais.");
    }
}