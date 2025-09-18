package com.example.revisaoprova01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioButton certoP1;
    private RadioButton erradoP1;
    private RadioButton certoP2;
    private RadioButton erradoP2;
    private RadioButton certoP3;
    private RadioButton erradoP3;
    private Button enviarRespostas;
    private TextView feedback;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
        certoP1 = findViewById(R.id.radioButtonCertoP01);
        erradoP1 = findViewById(R.id.radioButtonErradoP01);
        certoP2 = findViewById(R.id.radioButtonCertoP02);
        erradoP2 = findViewById(R.id.radioButtonErradoP02);
        certoP3 = findViewById(R.id.radioButtonCertoP03);        
        erradoP3 = findViewById(R.id.radioButtonErradoP03);
        
        enviarRespostas = findViewById(R.id.buttonEnviarRespostas);
        feedback = findViewById(R.id.textViewFeedback);
        
        enviarRespostas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if ((certoP1.isChecked() == false && erradoP1.isChecked() == false) || (certoP2.isChecked() == false && erradoP2.isChecked() == false)
                            || (certoP3.isChecked() == false && erradoP3.isChecked() == false)) {
                        feedback.setText("ERRO: Pelo menos uma resposta [CERTO] ou [ERRADO] de cada pergunta deve ser marcada.");
                    } else if ((certoP1.isChecked() == true && erradoP1.isChecked() == true) || (certoP2.isChecked() == true && erradoP2.isChecked() == true)
                            || (certoP3.isChecked() == true && erradoP3.isChecked() == true)) {
                        feedback.setText("ERRO: Somente uma resposta [CERTO] ou [ERRADO] de cada pergunta deve ser marcada.");
                    } else if (erradoP1.isChecked() && erradoP2.isChecked() && erradoP3.isChecked()) {
                        feedback.setText("Você acertou todas, nota 10!");

                    } else if ((erradoP1.isChecked() && erradoP2.isChecked() && certoP3.isChecked()) ||
                            (erradoP1.isChecked() && erradoP3.isChecked() && certoP2.isChecked()) ||
                            (erradoP2.isChecked() && erradoP3.isChecked() && certoP1.isChecked())) {
                        feedback.setText("Você acertou duas, nota 6!");

                    } else if ((erradoP1.isChecked() && certoP2.isChecked() && certoP3.isChecked()) ||
                            (erradoP2.isChecked() && certoP1.isChecked() && certoP3.isChecked()) ||
                            (erradoP3.isChecked() && certoP1.isChecked() && certoP2.isChecked())) {
                        feedback.setText("Você acertou uma, nota 3!");

                    } else if (certoP1.isChecked() && certoP2.isChecked() && certoP3.isChecked()) {
                        feedback.setText("Você errou todas, nota 0!");

                    }//if else
                }

        });
        
    }//method onCreate
}//method MainActivity