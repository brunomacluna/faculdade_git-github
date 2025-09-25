package com.example.aula07;

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
        });
        //faça seu código abaixo
        resultado = findViewById(R.id.textViewResultado);
        String resposta1 = getIntent().getStringExtra("chaveResposta1");
        String resposta2 = getIntent().getStringExtra("chaveResposta2");
        String resposta3 = getIntent().getStringExtra("chaveResposta3");

        int qtdAcertos = calcularQtdAcertos(resposta1, resposta2, resposta3);

        if(qtdAcertos == 3){
            resultado.setText("Parabens, acertou as 3.");
        } else if (qtdAcertos == 2) {
            resultado.setText("Parabens, acertou 2.");
        } else if (qtdAcertos == 1) {
            resultado.setText("Só acertou uma, melhore!");
        } else {
            resultado.setText("Nenhuma mano, você marcou que a terra é plana??? auahuahua");
        }

        private int calcularQtdAcertos (String resposta1, String resposta2, String resposta3) {
            int qtdAcertos = 0;
            if(resposta1.equalsIgnoreCase("errado")){
                qtdAcertos++;
            }
            if(resposta2.equalsIgnoreCase("errado")){
                qtdAcertos++;
            }
            if(resposta3.equalsIgnoreCase("errado")){
                qtdAcertos++;
            }
            return qtdAcertos;
        }


    }// onCreate
}//TelaResultado