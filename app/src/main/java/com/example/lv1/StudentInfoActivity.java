package com.example.lv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class StudentInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        Button btn_otvoriActivitiy2 = (Button)findViewById(R.id.btn_otvoriActivitiy2);
        TextInputLayout input_predmet = (TextInputLayout)findViewById(R.id.input_predmet);

        btn_otvoriActivitiy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(StudentInfoActivity.this, SummaryActivity.class);
                i.putExtra("predmet", input_predmet.getEditText().getText().toString());

                Bundle extras = getIntent().getExtras();
                if(extras != null){
                    i.putExtra("ime", extras.getString("ime"));
                }

                startActivity(i);
            }
        });
    }
}