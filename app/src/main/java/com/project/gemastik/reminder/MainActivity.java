package com.project.gemastik.reminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.project.gemastik.reminder.cnbfragment.MotivasiFragment;
import com.project.gemastik.reminder.cnbfragment.ImpianFragment;
import com.project.gemastik.reminder.cnbfragment.JadwalFragment;
import com.project.gemastik.reminder.cnbfragment.ProfilFragment;
import com.project.gemastik.reminder.verify.LoginActivity;

public class MainActivity extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;
    FragmentManager fragmentManager;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chipNavigationBar = findViewById(R.id.chipbar);
        firebaseAuth  = FirebaseAuth.getInstance();

        if (savedInstanceState == null){
            chipNavigationBar.setItemSelected(R.id.jadwal, true);
            fragmentManager = getSupportFragmentManager();
            JadwalFragment jadwalFragment = new JadwalFragment();
            fragmentManager.beginTransaction().replace(R.id.container, jadwalFragment).commit();
        }

        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {
                Fragment fragments = null;

                switch (id){
                    case R.id.jadwal:
                        JadwalFragment jadwalFragment = new JadwalFragment();
                        fragmentManager.beginTransaction().replace(R.id.container, jadwalFragment).commit();
                        break;
                    case R.id.impian:
                        ImpianFragment impianFragment = new ImpianFragment();
                        fragmentManager.beginTransaction().replace(R.id.container, impianFragment).commit();
                        break;
                    case R.id.artikel:
                        MotivasiFragment motivasiFragment = new MotivasiFragment();
                        fragmentManager.beginTransaction().replace(R.id.container, motivasiFragment).commit();
                        break;
                    case R.id.profile:
                        ProfilFragment profilFragment = new ProfilFragment();
                        fragmentManager.beginTransaction().replace(R.id.container, profilFragment).commit();
                        break;
                }

                if (fragments != null){
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.container,fragments).commit();
                }
            }
        });
    }

    public void checkStatus(){

        FirebaseUser User = firebaseAuth.getCurrentUser();
        if (User != null){

        }else {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
    }


    @Override
    public void onStart() {
        checkStatus();
        super.onStart();
    }

    @Override
    public void onBackPressed() {
        Intent close = new Intent(Intent.ACTION_MAIN);
        close.addCategory(Intent.CATEGORY_HOME);
        close.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(close);
    }
}