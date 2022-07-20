package com.example.howcruds.pers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.howcruds.BDHow;
import com.example.howcruds.R;

import java.util.ArrayList;

public class ListarPersonagens extends AppCompatActivity {


        private ArrayList<personagem> personagemArrayList;
        private BDHow dbHandler;
        private personagemAdapter personagemAdapter;
        private RecyclerView personagensRV;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_listar_personagens);

            personagemArrayList = new ArrayList<>();
            dbHandler = new BDHow(ListarPersonagens.this);

            personagemArrayList = dbHandler.mostrarPersonagens();

            personagemAdapter = new personagemAdapter(personagemArrayList, ListarPersonagens.this);
            personagensRV = findViewById(R.id.charRV);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ListarPersonagens.this, RecyclerView.VERTICAL, false);
            personagensRV.setLayoutManager(linearLayoutManager);

            personagensRV.setAdapter(personagemAdapter);
    }
}