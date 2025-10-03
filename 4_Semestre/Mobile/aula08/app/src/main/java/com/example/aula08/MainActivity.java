package com.example.aula08;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private RadioGroup pergunta1, pergunta2, pergunta3;
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
        });//onCreate

        pergunta1 = findViewById(R.id.radioGroupPergunta1);
        pergunta2 = findViewById(R.id.radioGroupPergunta2);
        pergunta3 = findViewById(R.id.radioGroupPergunta3);

        enviarProva = findViewById(R.id.buttonEnviar);

        enviarProva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validaProva();
            }
        });
    }//onCreate

    private void validaProva() {
        int idResposta1 = pergunta1.getCheckedRadioButtonId();
        int idResposta2 = pergunta2.getCheckedRadioButtonId();
        int idResposta3 = pergunta3.getCheckedRadioButtonId();

        RadioButton resposta1 = findViewById(idResposta1);
        RadioButton resposta2 = findViewById(idResposta2);
        RadioButton resposta3 = findViewById(idResposta3);

        String resposta1Str = resposta1.getText().toString();
        String resposta2Str = resposta2.getText().toString();
        String resposta3Str = resposta3.getText().toString();

        Intent segundaTela = new Intent(MainActivity.this, Resultado.class);

        segundaTela.putExtra("idResposta1",resposta1Str);
        segundaTela.putExtra("idResposta1",resposta2Str);
        segundaTela.putExtra("idResposta1",resposta3Str);
    }
}//MainActivity