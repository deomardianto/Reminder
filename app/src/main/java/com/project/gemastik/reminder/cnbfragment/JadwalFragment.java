package com.project.gemastik.reminder.cnbfragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.jhonnyx2012.horizontalpicker.DatePickerListener;
import com.github.jhonnyx2012.horizontalpicker.HorizontalPicker;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.project.gemastik.reminder.R;
import com.project.gemastik.reminder.jadwal.AddJadwalActivity;
import com.project.gemastik.reminder.jadwal.adapterAgenda;
import com.project.gemastik.reminder.jadwal.dataAgenda;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class JadwalFragment extends Fragment implements DatePickerListener {

    GoogleSignInClient mGoogleSignInClient;
    String personEmail;
    private FirebaseAuth mAuth;
    FirebaseUser mUser;
    private DatabaseReference reference;
    private RecyclerView mRecycler;
    private LinearLayoutManager mManager;
    List<dataAgenda> list;
    adapterAgenda adapter;

    public JadwalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jadwal, container, false);

        FloatingActionButton fab = view.findViewById(R.id.fabAddJadwal);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddJadwalActivity.class);
                startActivity(intent);
            }
        });

        HorizontalPicker picker = view.findViewById(R.id.datePicker);
        picker.setListener(this)
                .setDays(120)
                .setOffset(7)
                .setDateSelectedColor(getResources().getColor(R.color.colorPrimary))
                .setDateSelectedTextColor(Color.WHITE)
                .setMonthAndYearTextColor(Color.DKGRAY)
                .setTodayButtonTextColor(getResources().getColor(R.color.colorPrimary))
                .setTodayDateTextColor(getResources().getColor(R.color.colorPrimary))
                .showTodayButton(false)
                .init();

        picker.setBackgroundColor(Color.WHITE);
        picker.setDate(new DateTime());

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getActivity());
        if (acct != null) {
            personEmail = acct.getEmail();

        }else {
            personEmail = mUser.getEmail();
        }

        mRecycler = view.findViewById(R.id.rv_agenda);
        mRecycler.setHasFixedSize(true);
        mManager = new LinearLayoutManager(getActivity());
        mManager.setReverseLayout(true);
        mManager.setStackFromEnd(true);
        mRecycler.setLayoutManager(mManager);

        reference = FirebaseDatabase.getInstance().getReference().child("Agenda");
        Query query = reference.orderByChild("email").equalTo(personEmail);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    dataAgenda data = ds.getValue(dataAgenda.class);
                    list.add(data);

                }
                adapter = new adapterAgenda(getActivity(),list);
                mRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getActivity(),""+databaseError.getMessage(),Toast.LENGTH_LONG).show();

            }
        });


        return view;
    }

    @Override
    public void onDateSelected(DateTime dateSelected) {

    }
}
