package com.example.lv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class PersonalInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);

        Button btn_otvoriActivitiy = (Button)findViewById(R.id.btn_otvoriActivitiy);
        TextInputLayout input_ime = (TextInputLayout)findViewById(R.id.input_ime);
        TextInputLayout input_prezime = (TextInputLayout)findViewById(R.id.input_prezime);
        TextInputLayout input_datum = (TextInputLayout)findViewById(R.id.input_datum);

        btn_otvoriActivitiy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PersonalInfoActivity.this, StudentInfoActivity.class);
                i.putExtra("ime", input_ime.getEditText().getText().toString());
                i.putExtra("prezime", input_prezime.getEditText().getText().toString());
                i.putExtra("datum", input_datum.getEditText().getText().toString());
                startActivity(i);
            }
        });
    }
}