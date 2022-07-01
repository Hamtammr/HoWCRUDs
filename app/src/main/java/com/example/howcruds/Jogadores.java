package com.example.howcruds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Jogadores extends AppCompatActivity {


    private EditText nomeJogaTxtEdit, favClasseTxtEdit;
    private Button salvarJogabtn, listarJogabtn;
    private BDHow bdHow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogadores);

        nomeJogaTxtEdit = findViewById(R.id.txNomeJoga);
        favClasseTxtEdit = findViewById(R.id.txFavClasse);
        listarJogabtn = findViewById(R.id.btnListarJogadores);
        salvarJogabtn = findViewById(R.id.btnSalvarJoga);

        bdHow = new BDHow(Jogadores.this);

        salvarJogabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String jogaNome = nomeJogaTxtEdit.getText().toString();
                String jogaFavClasse = favClasseTxtEdit.getText().toString();

                if (jogaNome.isEmpty() && jogaFavClasse.isEmpty()) {
                    Toast.makeText(Jogadores.this, "Não deixe campos em branco", Toast.LENGTH_SHORT).show();
                    return;
                }

                bdHow.inserirJogador(jogaNome, jogaFavClasse);


                Toast.makeText(Jogadores.this, "Jogador adicionado.", Toast.LENGTH_SHORT).show();
                nomeJogaTxtEdit.setText("");
                favClasseTxtEdit.setText("");
            }
        });
        listarJogabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Jogadores.this, ListarJogadores.class);
                startActivity(i);
            }
        });
    }
}