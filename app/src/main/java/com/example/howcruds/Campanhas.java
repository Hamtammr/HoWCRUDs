package com.example.howcruds;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Campanhas extends AppCompatActivity {


    private EditText nomeCampTxtEdit, sistemaTxtEdit;
    private Button salvarCampbtn;
    private BDHow bdHow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campanhas);

        nomeCampTxtEdit = findViewById(R.id.txNomeCamp);
        sistemaTxtEdit = findViewById(R.id.txSistema);
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
    }
}