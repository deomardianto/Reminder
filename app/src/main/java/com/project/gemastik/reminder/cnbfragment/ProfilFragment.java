package com.project.gemastik.reminder.cnbfragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.project.gemastik.reminder.MainActivity;
import com.project.gemastik.reminder.R;
import com.project.gemastik.reminder.verify.LoginActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilFragment extends Fragment {

    CardView btnLogout;
    TextView txEmail, txUsername;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    public ProfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profil, container, false);

        btnLogout = view.findViewById(R.id.btnlogout);
        txEmail = view.findViewById(R.id.mailProfile);
        txUsername = view.findViewById(R.id.userProfile);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        txEmail.setText(mUser.getEmail());
        txUsername.setText(mUser.getDisplayName());

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent(getActivity(), LoginActivity.class));
                getActivity().finish();
            }
        });
        return view;
    }

//    public void checkStatus(){
//
//        if (mUser != null){
//
//        }else {
//            startActivity(new Intent(getActivity(), LoginActivity.class));
//            getActivity().finish();
//        }
//    }
//
//
//    @Override
//    public void onStart() {
//        checkStatus();
//        super.onStart();
//    }
}
