package com.example.howcruds;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class campanhaAdapter extends RecyclerView.Adapter<campanhaAdapter.ViewHolder> {

    private ArrayList<campanha> campanhaArrayList;
    private Context context;

    public campanhaAdapter(ArrayList<campanha> campanhaArrayList, Context context) {
        this.campanhaArrayList = campanhaArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.campanha_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        campanha modalcamp = campanhaArrayList.get(position);
        holder.campNomee.setText(modalcamp.getCampNome());
        holder.campSistema.setText(modalcamp.getSistema());
    }

    @Override
    public int getItemCount() {
        return campanhaArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView campNomee, campSistema;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            campNomee = itemView.findViewById(R.id.campaNome);
            campSistema = itemView.findViewById(R.id.campaSistema);
        }
    }
}