package com.project.gemastik.reminder.cnbfragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.project.gemastik.reminder.R;
import com.project.gemastik.reminder.impian.AddImpianActivity;
import com.project.gemastik.reminder.impian.AktifFragment;
import com.project.gemastik.reminder.impian.TercapaiFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImpianFragment extends Fragment {

    CardView btn_aktif, btn_capai;
    ImageView imgAktif, imgCapai;
    TextView txAktif, txCapai;
    public ImpianFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewFrag = inflater.inflate(R.layout.fragment_impian, container, false);

        FloatingActionButton fab = viewFrag.findViewById(R.id.fabAddImpian);
        btn_aktif = viewFrag.findViewById(R.id.active_goals);
        btn_aktif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragAktif();
            }
        });

        btn_capai = viewFrag.findViewById(R.id.complete_goals);
        btn_capai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragCapai();
            }
        });
        imgAktif = viewFrag.findViewById(R.id.img_aktif);
        imgCapai = viewFrag.findViewById(R.id.img_capai);
        txAktif = viewFrag.findViewById(R.id.tx_aktif);
        txCapai = viewFrag.findViewById(R.id.tx_capai);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),AddImpianActivity.class);
                startActivity(intent);
            }
        });
        fragAktif();
        return viewFrag;
    }

    private void fragAktif(){
        imgAktif.setImageResource(R.drawable.ic_goals_active_check);
        txAktif.setTextColor(Color.WHITE);

        FragmentTransaction transaction1 = getChildFragmentManager().beginTransaction();
        transaction1.replace(R.id.container_impian,new AktifFragment());
        transaction1.commit();
    }

    private void fragCapai(){
        imgCapai.setImageResource(R.drawable.ic_goals_complete_check);
        txCapai.setTextColor(Color.WHITE);

        FragmentTransaction transaction2 = getChildFragmentManager().beginTransaction();
        transaction2.replace(R.id.container_impian,new TercapaiFragment());
        transaction2.commit();
    }

}
