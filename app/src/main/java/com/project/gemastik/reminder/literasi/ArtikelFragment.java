package com.project.gemastik.reminder.literasi;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.project.gemastik.reminder.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtikelFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<ArtikelItem> itemList;
    ShimmerFrameLayout shimmerFrameLayout;
    Handler handler;

    public ArtikelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_artikel, container, false);

        recyclerView = view.findViewById(R.id.rv_artikel);
        recyclerView.setHasFixedSize(true);

        dataArtikel();

        ArtikelAdapter adapter = new ArtikelAdapter(this.getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter.setArtikelItems(itemList);
        recyclerView.setAdapter(adapter);

        handler = new Handler();
        shimmerFrameLayout = view.findViewById(R.id.shimmer_rv_artikel);
        shimmerFrameLayout.startShimmer();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                shimmerFrameLayout.stopShimmer();
            }
        },3000);
        return view;
    }

    private void dataArtikel(){
        itemList = new ArrayList<>();
        itemList.add(new ArtikelItem(R.drawable.ali,"Ali (Udin)","Aliudin","Pengembangan Diri","22 Halaman","Hnaya Test"));
        itemList.add(new ArtikelItem(R.drawable.ali,"Ali (Udin)","Aliudin","Pengembangan Diri","22 Halaman","Hnaya Test"));
        itemList.add(new ArtikelItem(R.drawable.ali,"Ali (Udin)","Aliudin","Pengembangan Diri","22 Halaman","Hnaya Test"));
    }
}
