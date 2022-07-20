package com.example.howcruds.pers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.howcruds.BDHow;
import com.example.howcruds.MainActivity;
import com.example.howcruds.R;
import com.example.howcruds.jogs.UpdateJogador;

public class UpdatePersonagem extends AppCompatActivity {

    private EditText editNomePerso, editClassePerso, editRacaPerso;
    private Button atualizarPerso, deletarPerso;
    private BDHow dbHandler;
    String nomeChar, classeChar, racaChar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_personagem);

        editNomePerso = findViewById(R.id.editNomeChar);
        editClassePerso = findViewById(R.id.editClasseChar);
        editRacaPerso = findViewById(R.id.editRacaChar);
        deletarPerso = findViewById(R.id.deletarChar);
        atualizarPerso = findViewById(R.id.atualizarChar);

        dbHandler = new BDHow(UpdatePersonagem.this);


        nomeChar = getIntent().getStringExtra("NomePersonagem");
        classeChar = getIntent().getStringExtra("Classe");
        racaChar = getIntent().getStringExtra("Raca");


        editNomePerso.setText(nomeChar);
        editClassePerso.setText(classeChar);
        editRacaPerso.setText(racaChar);



        atualizarPerso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editNomePerso.getText().toString().trim().length() > 0 && editClassePerso.getText().toString().trim().length() > 0 && editRacaPerso.getText().toString().trim().length() > 0 ){
                dbHandler.updatePersonagem(nomeChar, editNomePerso.getText().toString(), editClassePerso.getText().toString(), editRacaPerso.getText().toString());

                Toast.makeText(UpdatePersonagem.this, "Personagem Atualizado", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(UpdatePersonagem.this, Personagens.class);
                startActivity(i);}else {
                    Toast.makeText(UpdatePersonagem.this, "Preencher todos os campos", Toast.LENGTH_SHORT).show();

                }
            }
        });


        deletarPerso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.deletePersonagem(nomeChar);
                Toast.makeText(UpdatePersonagem.this, "Personagem Excluido", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdatePersonagem.this, Personagens.class);
                startActivity(i);
            }
        });
    }

}