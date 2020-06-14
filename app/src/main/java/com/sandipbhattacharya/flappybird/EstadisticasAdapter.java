package com.sandipbhattacharya.flappybird;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

class EstadisticasAdapter extends RecyclerView.Adapter<EstadisticasAdapter.EstadisticasViewHolder> {
    Context context;
    ArrayList<MiCuenta> micuenta;

    public EstadisticasAdapter(Context context, ArrayList<MiCuenta> micuenta) {
        this.context = context;
        this.micuenta = micuenta;
    }

    @NonNull
    @Override
    public EstadisticasViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.puntos_linea,null, false);
        return new EstadisticasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EstadisticasViewHolder estadisticasViewHolder, int i) {
        estadisticasViewHolder.txtPuntos.setText(String.valueOf(micuenta.get(i).getPuntos()));
        estadisticasViewHolder.txtPosicion.setText(String.valueOf(i));
    }

    @Override
    public int getItemCount() {
        return micuenta.size();
    }

    public class EstadisticasViewHolder extends RecyclerView.ViewHolder {
        TextView txtPuntos, txtPosicion;

        public EstadisticasViewHolder(@NonNull View itemView) {
            super(itemView);
            int Posicion = getAdapterPosition();
            txtPosicion = itemView.findViewById(R.id.txtPosicion);
            txtPuntos = itemView.findViewById(R.id.txtpuntos);
        }
    }
}
