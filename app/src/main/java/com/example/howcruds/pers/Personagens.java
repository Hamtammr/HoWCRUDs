package com.example.howcruds.pers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.howcruds.BDHow;
import com.example.howcruds.MainActivity;
import com.example.howcruds.R;

public class Personagens extends AppCompatActivity {


    private EditText nomeCharTxtEdit, classeCharTxtEdit, racaTxtEdit;
    private Button salvarCharbtn,listarCharbtn;
    private BDHow bdHow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personagens);

        nomeCharTxtEdit = findViewById(R.id.txNomeChar);
        classeCharTxtEdit = findViewById(R.id.txClasseChar);
        racaTxtEdit = findViewById(R.id.txRacaChar);
        listarCharbtn = findViewById(R.id.btnListarChar);
        salvarCharbtn = findViewById(R.id.btnSalvarChar);


        bdHow = new BDHow(Personagens.this);

        salvarCharbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String charNome = nomeCharTxtEdit.getText().toString();
                String charClasse = classeCharTxtEdit.getText().toString();
                String charRaca = racaTxtEdit.getText().toString();

                if (charNome.isEmpty() || charClasse.isEmpty() && charRaca.isEmpty()) {
                    Toast.makeText(Personagens.this, "Não deixe campos em branco", Toast.LENGTH_SHORT).show();
                    return;
                }

                bdHow.inserirPersonagem(charNome, charClasse, charRaca);
                Toast.makeText(Personagens.this, "Personagem adicionado.", Toast.LENGTH_SHORT).show();
                nomeCharTxtEdit.setText("");
                classeCharTxtEdit.setText("");
                racaTxtEdit.setText("");
            }
        });
        listarCharbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Personagens.this, ListarPersonagens.class);
                startActivity(i);
            }
        });
    }
    public void onBackPressed(){
        Intent i = new Intent(Personagens.this, MainActivity.class);
        startActivity(i);
    }
}