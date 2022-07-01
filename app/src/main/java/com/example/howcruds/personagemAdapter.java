package com.example.howcruds;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.howcruds.databinding.ActivityUpdatePersonagemBinding;

import java.util.ArrayList;

public class personagemAdapter extends RecyclerView.Adapter<personagemAdapter.ViewHolder> {

    private ArrayList<personagem> personagemArrayList;
    private Context context;

    public personagemAdapter(ArrayList<personagem> personagemArrayList, Context context) {
        this.personagemArrayList = personagemArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.personagem_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        personagem modal = personagemArrayList.get(position);
        holder.persoNome.setText(modal.getCharNome());
        holder.persoClasse.setText(modal.getCharClasse());
        holder.persoRaca.setText(modal.getCharRaca());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, UpdatePersonagem.class);

                i.putExtra("NomePersonagem", modal.getCharNome());
                i.putExtra("Classe", modal.getCharClasse());
                i.putExtra("Raca", modal.getCharRaca());

                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return personagemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView persoNome, persoClasse, persoRaca;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            persoNome = itemView.findViewById(R.id.charNome);
            persoClasse = itemView.findViewById(R.id.charClasse);
            persoRaca = itemView.findViewById(R.id.charRaca);
        }
    }
}