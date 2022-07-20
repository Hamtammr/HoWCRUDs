package com.example.howcruds.jogs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.howcruds.BDHow;
import com.example.howcruds.R;

public class UpdateJogador extends AppCompatActivity {

    private EditText editNomeJoga, editClasseJoga;
    private Button atualizarJoga, deletarJoga;
    private BDHow dbHandler;
    String nomeJoga, classeJoga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_jogador);

        editNomeJoga = findViewById(R.id.editNomeJoga);
        editClasseJoga = findViewById(R.id.editClasseJoga);
        deletarJoga = findViewById(R.id.deletarJoga);
        atualizarJoga = findViewById(R.id.atualizarJoga);

        dbHandler = new BDHow(UpdateJogador.this);


        nomeJoga = getIntent().getStringExtra("nomeJogador");
        classeJoga = getIntent().getStringExtra("classeFavorita");


        editNomeJoga.setText(nomeJoga);
        editClasseJoga.setText(classeJoga);

        atualizarJoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editNomeJoga.getText().toString().trim().length() > 0 && editClasseJoga.getText().toString().trim().length() > 0){
                dbHandler.updateJogador(nomeJoga, editNomeJoga.getText().toString(), editClasseJoga.getText().toString());

                Toast.makeText(UpdateJogador.this, "Jogador Atualizado", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(UpdateJogador.this, Jogadores.class);
                startActivity(i);} else {
                    Toast.makeText(UpdateJogador.this, "Preencher todos os campos", Toast.LENGTH_SHORT).show();

                }
            }
        });
        deletarJoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.deleteJogador(nomeJoga);
                Toast.makeText(UpdateJogador.this, "Jogador Excluido", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateJogador.this, Jogadores.class);
                startActivity(i);
            }
        });
    }
}