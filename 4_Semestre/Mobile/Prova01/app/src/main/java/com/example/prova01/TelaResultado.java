package com.example.prova01;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaResultado extends AppCompatActivity {

    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_resultado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });//ViewCompat

        resultado = findViewById(R.id.textViewResultado);

        String resposta1 = getIntent().getStringExtra("chaveResposta1");
        String resposta2 = getIntent().getStringExtra("chaveResposta2");
        String resposta3 = getIntent().getStringExtra("chaveResposta3");
        String resposta4 = getIntent().getStringExtra("chaveResposta4");

        int totalPontos = calcularPontuacao(resposta1, resposta2, resposta3, resposta4);

        if(totalPontos == 4){
            resultado.setText("Sua nota é: 10");
        } else if (totalPontos == 2) {
            resultado.setText("Sua nota é: 5");
        } else {
            resultado.setText("Sua nota é: 0");
        }


    }//onCreate

    private int calcularPontuacao(String resposta1, String resposta2, String resposta3, String resposta4 ){
        int pontos = 0;

        if(resposta1.equalsIgnoreCase("certo")){
            pontos++;
        } else {
            pontos--;
        }
        if (resposta2.equalsIgnoreCase("certo")) {
            pontos++;
        } else {
            pontos--;
        }
        if (resposta3.equalsIgnoreCase("errado")) {
            pontos++;
        } else {
            pontos--;
        }
        if (resposta4.equalsIgnoreCase("certo")) {
            pontos++;
        } else {
            pontos--;
        }
        if(pontos < 0) {
            pontos = 0;
        }

        return pontos;
    }//qtdDeAcertos

}//TelaResultado













