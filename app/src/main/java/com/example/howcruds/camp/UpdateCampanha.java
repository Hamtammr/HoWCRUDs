package com.example.howcruds.camp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.howcruds.BDHow;
import com.example.howcruds.R;

public class UpdateCampanha extends AppCompatActivity {

    private EditText editNomeCamp, editSistema;
    private Button atualizarCamp,deletarCamp;
    private BDHow dbHandler;
    String nomeCamp, sistemaCamp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_campanha);

        editNomeCamp = findViewById(R.id.editNomeCamp);
        editSistema = findViewById(R.id.editSistema);
        deletarCamp =findViewById(R.id.deletarCamp);
        atualizarCamp = findViewById(R.id.atualizarCamp);

        dbHandler = new BDHow(UpdateCampanha.this);


        nomeCamp = getIntent().getStringExtra("nomeCampanha");
        sistemaCamp = getIntent().getStringExtra("sistema");


        editNomeCamp.setText(nomeCamp);
        editSistema.setText(sistemaCamp);

        atualizarCamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                if (editNomeCamp.getText().toString().trim().length() > 0 && editSistema.getText().toString().trim().length() > 0){
                dbHandler.updateCampanha(nomeCamp, editNomeCamp.getText().toString(), editSistema.getText().toString());

                Toast.makeText(UpdateCampanha.this, "Campanha Atualizada", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(UpdateCampanha.this, Campanhas.class);
                startActivity(i);}else {
                    Toast.makeText(UpdateCampanha.this, "Preencher todos os campos", Toast.LENGTH_SHORT).show();

                }
            }
        });
        deletarCamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.deleteCampanha(nomeCamp);
                Toast.makeText(UpdateCampanha.this, "Campanha Excluido", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateCampanha.this, Campanhas.class);
                startActivity(i);
            }
        });
    }
}