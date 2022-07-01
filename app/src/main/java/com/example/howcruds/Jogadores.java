package com.example.howcruds;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Jogadores extends AppCompatActivity {


    private EditText nomeJogaTxtEdit, favClasseTxtEdit;
    private Button salvarJogabtn;
    private BDHow bdHow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogadores);

        nomeJogaTxtEdit = findViewById(R.id.txNomeJoga);
        favClasseTxtEdit = findViewById(R.id.txFavClasse);
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


                Toast.makeText(Jogadores.this, "Personagem adicionado.", Toast.LENGTH_SHORT).show();
                nomeJogaTxtEdit.setText("");
                favClasseTxtEdit.setText("");
            }
        });
    }
}