package com.example.ejercicio24_firmas;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.SignViewHolder> {
    private List<firmas> items;

    public Adapter(List<firmas> items) {
        this.items = items;
    }

    @Override
    public SignViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.tokens_firmas, viewGroup, false);
        return new SignViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SignViewHolder viewHolder, int i) {
        Bitmap BMP = BitmapFactory.decodeByteArray(items.get(i).getImage(), 0,items.get(i).getImage().length);

        viewHolder.imagen.setImageBitmap(BMP);
        viewHolder.descripcion.setText(items.get(i).getDescripcion());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class SignViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagen;
        public TextView  descripcion;

        public SignViewHolder(View visualizador) {
            super(visualizador);
            imagen = (ImageView) visualizador.findViewById(R.id.txt_firma);
            descripcion = (TextView) visualizador.findViewById(R.id.txt_descripcion);
        }
    }
}
