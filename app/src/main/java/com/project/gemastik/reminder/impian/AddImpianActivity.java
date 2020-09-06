package com.project.gemastik.reminder.impian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.gemastik.reminder.R;

public class AddImpianActivity extends AppCompatActivity {

    LinearLayout layoutList;
    TextView addList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_impian);

        layoutList = findViewById(R.id.layout_list);
        addList = findViewById(R.id.btnTambahList);

        addList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addListHabits();
            }
        });
    }

    private void addListHabits(){
        final View habitsView = getLayoutInflater().inflate(R.layout.add_layout_habits,null,false);

        EditText editText = habitsView.findViewById(R.id.edt_habits);
        ImageButton imageButton = habitsView.findViewById(R.id.close_habits);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeView(habitsView);
            }
        });

        layoutList.addView(habitsView);
    }

    private void removeView(View view){
        layoutList.removeView(view);
    }
}
