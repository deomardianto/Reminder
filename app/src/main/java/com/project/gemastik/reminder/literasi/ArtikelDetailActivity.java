package com.project.gemastik.reminder.literasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.project.gemastik.reminder.R;

public class ArtikelDetailActivity extends AppCompatActivity {

    public static final String EXTRA_ARTIKEL = "DataArtikel";

    TextView txJudul, txDesk, txPengarang, txJml, txKat;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artikel_detail);

        txJudul = findViewById(R.id.title_ebook);
        txDesk = findViewById(R.id.desk_ebook);
        txPengarang = findViewById(R.id.pengarang);
        txKat = findViewById(R.id.kategori);
        txJml = findViewById(R.id.jumlah_hal);
        imgView = findViewById(R.id.img_cover);

        ArtikelItem item = getIntent().getParcelableExtra(EXTRA_ARTIKEL);

        txJudul.setText(item.getNamaEbook());
        txDesk.setText(item.getDeskEbook());
        txPengarang.setText(item.getPengarang());
        txKat.setText(item.getKategori());
        txJml.setText(item.getJmlHal());

        Glide.with(this)
                .load(item.getPosterEbook())
                .into(imgView);
    }
}
