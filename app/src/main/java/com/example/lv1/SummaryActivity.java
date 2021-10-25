package com.example.lv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        TextView txt_predmet = (TextView)findViewById(R.id.txt_predmet);
        TextView txt_ime = (TextView)findViewById(R.id.txt_ime);
        Button btn_exit = (Button)findViewById(R.id.btn_exit);

        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            txt_predmet.setText(extras.getString("predmet"));
            txt_ime.setText(extras.getString("ime"));
        }

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SummaryActivity.this, PersonalInfoActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
    }
}