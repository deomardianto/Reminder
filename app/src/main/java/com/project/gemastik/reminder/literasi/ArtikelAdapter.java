package com.project.gemastik.reminder.literasi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.project.gemastik.reminder.R;

import java.util.ArrayList;
import java.util.List;

public class ArtikelAdapter extends RecyclerView.Adapter<ArtikelAdapter.ArtikelHolder> {

    private ArrayList<ArtikelItem> artikelItems;
    private Context context;

    public ArrayList<ArtikelItem> getArtikelItems() {
        return artikelItems;
    }

    public void setArtikelItems(ArrayList<ArtikelItem> artikelItems) {
        this.artikelItems = artikelItems;
    }

    public ArtikelAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ArtikelAdapter.ArtikelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.artikel_item,parent,false);

        return new ArtikelHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtikelAdapter.ArtikelHolder holder, int position) {
        ArtikelItem artikelItem = artikelItems.get(position);
        holder.title.setText(artikelItem.getNamaEbook());
        holder.kategori.setText(artikelItem.getKategori());
        Glide.with(holder.itemView.getContext())
                .load(artikelItem.getPosterEbook())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return artikelItems.size();
    }

    public class ArtikelHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView title, kategori;

        public ArtikelHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.judul_ebook);
            kategori = itemView.findViewById(R.id.kat_ebook);
            imageView = itemView.findViewById(R.id.poster_ebook);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            ArtikelItem artikelItem = getArtikelItems().get(position);

            artikelItem.setNamaEbook(artikelItem.getNamaEbook());

            Intent moveObject = new Intent(itemView.getContext(), ArtikelDetailActivity.class);
            moveObject.putExtra(ArtikelDetailActivity.EXTRA_ARTIKEL,artikelItem);
            context.startActivity(moveObject);
        }
    }
}
