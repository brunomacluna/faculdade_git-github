package com.example.prova01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText resposta1;
    private EditText resposta2;
    private EditText resposta3;
    private EditText resposta4;
    private Button enviarProva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });//ViewCompat

        resposta1 = findViewById(R.id.editTextResposta1);
        resposta2 = findViewById(R.id.editTextResposta2);
        resposta3 = findViewById(R.id.editTextResposta3);
        resposta4 = findViewById(R.id.editTextResposta4);
        enviarProva = findViewById(R.id.buttonEnviarProva);

        enviarProva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarRespostas();
            }//setOnClickListener
        });

    }//onCreate

    private void enviarRespostas(){
        String resposta1STR = resposta1.getText().toString();
        String resposta2STR = resposta2.getText().toString();
        String resposta3STR = resposta3.getText().toString();
        String resposta4STR = resposta4.getText().toString();

        if(resposta1.getText().toString().isEmpty() || resposta2.getText().toString().isEmpty() ||
                resposta3.getText().toString().isEmpty() || resposta4.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Atenção: Uma ou mais respostas não estão preenchidas!", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent segundaTela = new Intent(MainActivity.this, TelaResultado.class);
        segundaTela.putExtra("chaveResposta1", resposta1STR);
        segundaTela.putExtra("chaveResposta2", resposta2STR);
        segundaTela.putExtra("chaveResposta3", resposta3STR);
        segundaTela.putExtra("chaveResposta4", resposta4STR);
        startActivity(segundaTela);
    }//enviarRespostas

}//MainActivity


















































