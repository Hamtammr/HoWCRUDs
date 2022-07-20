package com.example.howcruds.camp;

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
import com.example.howcruds.pers.Personagens;

public class Campanhas extends AppCompatActivity {


    private EditText nomeCampTxtEdit, sistemaTxtEdit;
    private Button salvarCampbtn,listarCampbtn;
    private BDHow bdHow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campanhas);

        nomeCampTxtEdit = findViewById(R.id.txNomeCamp);
        sistemaTxtEdit = findViewById(R.id.txSistema);
        listarCampbtn = findViewById(R.id.btnListarCamp);
        salvarCampbtn = findViewById(R.id.btnSalvarCamp);


        bdHow = new BDHow(Campanhas.this);
        salvarCampbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String campNome = nomeCampTxtEdit.getText().toString();
                String sistema = sistemaTxtEdit.getText().toString();

                if (campNome.isEmpty() && sistema.isEmpty()) {
                    Toast.makeText(Campanhas.this, "Não deixe campos em branco", Toast.LENGTH_SHORT).show();
                    return;
                }

                bdHow.inserirCampanha(campNome, sistema);
                Toast.makeText(Campanhas.this, "Campanha adicionada.", Toast.LENGTH_SHORT).show();
                nomeCampTxtEdit.setText("");
                sistemaTxtEdit.setText("");
            }
        });
        listarCampbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Campanhas.this, ListarCampanhas.class);
                startActivity(i);
            }
        });
    }
    public void onBackPressed(){
        Intent i = new Intent(Campanhas.this, MainActivity.class);
        startActivity(i);
    }
}