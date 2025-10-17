package com.example.aula09;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private EditText telefone;
    private Button salvarContato;
    private DataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.editTextText);
        telefone = findViewById(R.id.editTextPhone);
        salvarContato = findViewById(R.id.button);
        db = Room.databaseBuilder(getApplicationContext(), DataBase.class, "contatos.db").build();

        salvarContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarBancoDeDados();
            }
        });
    }

    private void salvarBancoDeDados() {
        String nomeInformado = nome.getText().toString();
        String telefoneInformado = telefone.getText().toString();;
        Contato contatoAtual = new Contato();
        contatoAtual.setNome(nomeInformado);
        contatoAtual.setTelefone(telefoneInformado);
        db.contatoDAO().insertContato(contatoAtual);
    }
}