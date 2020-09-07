package com.project.gemastik.reminder.jadwal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.project.gemastik.reminder.R;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class adapterAgenda extends RecyclerView.Adapter<adapterAgenda.Myholder> {

    Context context;
    List<dataAgenda> agendas;

    public adapterAgenda(Context context, List<dataAgenda> agendas) {
        this.context = context;
        this.agendas = agendas;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.agenda_item, parent,false);

        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Myholder holder, int position) {

        String judul = agendas.get(position).getJudul();
        String waktu = agendas.get(position).getWaktu();
        final String timeStamp = agendas.get(position).getTimeStamp();

        holder.mJudul.setText(judul);
        holder.mWaktu.setText(waktu);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String option[] = {"Edit Agenda","Hapus Agenda"};

                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setTitle("Choose Action");
                builder.setItems(option, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == 1) {

                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference reference = database.getReference().child("Order");
                            Query query = reference.orderByChild("timeStamp").equalTo(timeStamp);
                            query.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    for (DataSnapshot appleSnapshot: snapshot.getChildren()) {
                                        appleSnapshot.getRef().removeValue();
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {
                                    Toast.makeText(context, error.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            });

                        }else if (which == 0){



                        }
                    }
                });
                builder.create().show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return agendas.size();
    }

    class Myholder extends RecyclerView.ViewHolder{

        TextView mJudul;
        TextView mWaktu;
        LinearLayout linearLayout;


        public Myholder(@NonNull View itemView) {
            super(itemView);

            mJudul = itemView.findViewById(R.id.judul);
            mWaktu = itemView.findViewById(R.id.waktu);
            linearLayout =(LinearLayout) itemView.findViewById(R.id.linearAgenda);
        }
    }
}