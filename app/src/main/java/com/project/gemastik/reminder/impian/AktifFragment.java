package com.project.gemastik.reminder.impian;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.gemastik.reminder.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AktifFragment extends Fragment {

    List<ImpianItem> items = new ArrayList<>();
    public AktifFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_aktif, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rv_impian_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        ImpianAdapter adapter = new ImpianAdapter(items);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

}
