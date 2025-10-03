package com.example.aula08;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Resultado extends AppCompatActivity {

    private TextView notaFinal;
    private ImageView imagemNotaFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });//setOnApplyWindowInsetsListener

        notaFinal = findViewById(R.id.textViewNotaFinal);
        imagemNotaFinal = findViewById(R.id.imageViewNotaFinal);

        String resposta1 = getIntent().getStringExtra("idResposta1");
        String resposta2 = getIntent().getStringExtra("idResposta2");
        String resposta3 = getIntent().getStringExtra("idResposta3");

        int qtdAcertos = verificaQtdAcertos(resposta1, resposta2, resposta3);
            if(qtdAcertos == 3){
                notaFinal.setText("Parabéns. você tirou 10");
            } else if (qtdAcertos == 2) {
                notaFinal.setText("Mais ou menos");
            } else if (qtdAcertos == 1) {
                notaFinal.setText("Melhore");
            } else{
                notaFinal.setText("Deu ruim");
            }
    }//onCreate

    private int verificaQtdAcertos(String resposta1, String resposta2, String resposta3) {
        int qtdAcertos = 0;
        if(resposta1.equalsIgnoreCase("Certo")){
            qtdAcertos++;
        }
        if(resposta2.equalsIgnoreCase("Certo")){
            qtdAcertos++;
        }
        if(resposta3.equalsIgnoreCase("Errado")){
            qtdAcertos++;
        }
        return qtdAcertos;
    }
}//Resultado