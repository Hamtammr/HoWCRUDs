package com.example.howcruds;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ListarJogadores extends AppCompatActivity {


    private ArrayList<jogador> jogadorArrayList;
    private BDHow dbHandler;
    private jogadorAdapter jogadorAdapter;
    private RecyclerView jogadorRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_jogadores);

        jogadorArrayList = new ArrayList<>();
        dbHandler = new BDHow(ListarJogadores.this);

        jogadorArrayList = dbHandler.mostrarJogador();

        jogadorAdapter = new jogadorAdapter(jogadorArrayList, ListarJogadores.this);
        jogadorRV = findViewById(R.id.jogaRV);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ListarJogadores.this, RecyclerView.VERTICAL, false);
        jogadorRV.setLayoutManager(linearLayoutManager);

        jogadorRV.setAdapter(jogadorAdapter);
    }
}