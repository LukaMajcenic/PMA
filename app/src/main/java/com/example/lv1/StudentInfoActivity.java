package com.example.lv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

public class StudentInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        Button btn_otvoriActivitiy2 = (Button)findViewById(R.id.btn_otvoriActivitiy2);
        TextInputLayout input_predmet = (TextInputLayout)findViewById(R.id.input_predmet);
        TextInputLayout input_profesor = (TextInputLayout)findViewById(R.id.input_profesor);
        EditText editText_godina = (EditText)findViewById(R.id.editTextGodina);
        EditText editText_satiPredavanja = (EditText)findViewById(R.id.editTextSatiPredavanja);
        EditText editText_satiLV = (EditText)findViewById(R.id.editTextSatiLV);
        TextView textViewIme = (TextView)findViewById(R.id.textViewIme);
        TextView textViewPrezime = (TextView)findViewById(R.id.textViewPrezime);
        TextView textViewDatum = (TextView)findViewById(R.id.textViewDatum);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            textViewIme.setText(extras.getString("ime"));
            textViewPrezime.setText(extras.getString("prezime"));
            textViewDatum.setText(extras.getString("datum"));
        }

        btn_otvoriActivitiy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(StudentInfoActivity.this, SummaryActivity.class);
                i.putExtra("predmet", input_predmet.getEditText().getText().toString());
                i.putExtra("ime", extras.getString("ime"));
                i.putExtra("prezime", extras.getString("prezime"));
                i.putExtra("datum", extras.getString("datum"));
                i.putExtra("godina", editText_godina.getText().toString());
                i.putExtra("satiPredavanja", editText_satiPredavanja.getText().toString());
                i.putExtra("satiLV", editText_satiLV.getText().toString());
                i.putExtra("profesor", input_profesor.getEditText().getText().toString());

                startActivity(i);
            }
        });
    }
}