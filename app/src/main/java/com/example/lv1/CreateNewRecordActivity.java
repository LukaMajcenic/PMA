package com.example.lv1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.textfield.TextInputLayout;

public class CreateNewRecordActivity extends AppCompatActivity {

    ViewPager2 pager2;
    FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_record);

        pager2 = findViewById(R.id.viewPager);

        FragmentManager fm = getSupportFragmentManager();
        adapter = new FragmentAdapter(fm, getLifecycle());
        pager2.setAdapter(adapter);

        // Create new fragment and transaction
        //Fragment newFragment = new PersonalInfoFragment();
        //FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        //transaction.replace(R.id.viewPager, newFragment);

        //transaction.commit();
    }
}