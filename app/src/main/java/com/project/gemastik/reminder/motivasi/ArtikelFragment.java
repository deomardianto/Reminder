package com.project.gemastik.reminder.motivasi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.gemastik.reminder.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtikelFragment extends Fragment {

    public ArtikelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_artikel, container, false);
    }
}
