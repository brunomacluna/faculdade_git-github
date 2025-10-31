package com.example.aula09;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText nome;
    private EditText telefone;
    private Button salvarContato;
    private Database db;
    private ListView listViewContatos;
    private List<Contato> listaContatos = new ArrayList<>();
    private ArrayAdapter<Contato> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        nome = findViewById(R.id.editTextNome);
        telefone = findViewById(R.id.editTextPhone);
        salvarContato = findViewById(R.id.buttonSalvar);
        listViewContatos = findViewById(R.id.listViewContatos);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaContatos);
        listViewContatos.setAdapter(adapter);

        db = Room.databaseBuilder(getApplicationContext(), Database.class, "contatos.db").build();
        buscarTodosContatos();
        salvarContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarContatoDb();
            }
        });
    }

    private void salvarContatoDb() {
        String nomeInformado = nome.getText().toString();
        String telefoneInformado = telefone.getText().toString();
        Contato contato = new Contato();
        contato.setNome(nomeInformado);
        contato.setTelefone(telefoneInformado);
        new Thread(new Runnable() {
            @Override
            public void run() {
                db.contatoDAO().insertContato(contato);
            }

        }).start();

    }

    private void buscarTodosContatos(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Contato> contatos = db.contatoDAO().getAllContatos();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        listaContatos.addAll(contatos);
                        adapter.notifyDataSetChanged();
                    }
                });

            }
        }).start();
    }//buscarTodosContatos
}