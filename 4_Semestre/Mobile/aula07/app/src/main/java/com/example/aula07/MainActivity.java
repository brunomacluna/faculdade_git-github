package com.example.aula07;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText resposta1;
    private EditText resposta2;
    private EditText resposta3;
    private Button enviarResposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //faça seu código aqui
        resposta1 = findViewById(R.id.editTextResposta1);
        resposta2 = findViewById(R.id.editTextResposta2);
        resposta3 = findViewById(R.id.editTextResposta3);
        enviarResposta = findViewById(R.id.buttonEnviar);

        enviarResposta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validaProva();
            }//setOnClickListerner
        });

    }//onCreate

    private void validaProva() {
        String respostas1STR = resposta1.getText().toString();
        String respostas2STR = resposta2.getText().toString();
        String respostas3STR = resposta3.getText().toString();

        Intent segundaTela = new Intent(MainActivity.this, TelaResultado.class);
        segundaTela.putExtra("chaveResposta1",respostas1STR);
        segundaTela.putExtra("chaveResposta2",respostas2STR);
        segundaTela.putExtra("chaveResposta3",respostas3STR);
        startActivity(segundaTela);
    }//validaProva


}//MainActivity