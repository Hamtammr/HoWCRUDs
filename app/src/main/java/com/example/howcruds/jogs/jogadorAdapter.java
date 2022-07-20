package com.example.howcruds.jogs;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.howcruds.R;

import java.util.ArrayList;

public class jogadorAdapter extends RecyclerView.Adapter<jogadorAdapter.ViewHolder> {

    private ArrayList<jogador>  jogadorArrayList;
    private Context context;

    public jogadorAdapter(ArrayList<jogador> jogadorArrayList, Context context) {
        this.jogadorArrayList = jogadorArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.jogador_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        jogador modal = jogadorArrayList.get(position);
        holder.jogaNome.setText(modal.getJogaNome());
        holder.jogaFavClass.setText(modal.getFavClasse());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, UpdateJogador.class);

                i.putExtra("nomeJogador", modal.getJogaNome());
                i.putExtra("classeFavorita", modal.getFavClasse());

                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return jogadorArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView jogaNome, jogaFavClass;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            jogaNome = itemView.findViewById(R.id.playerNome);
            jogaFavClass = itemView.findViewById(R.id.playerFavClass);
        }
    }
}