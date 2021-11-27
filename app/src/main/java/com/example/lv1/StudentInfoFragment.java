package com.example.lv1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StudentInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudentInfoFragment extends Fragment {

    public FragmentListener fragmentListener;

    EditText input_predmet, input_profesor, input_godina, input_sati_predavanja, input_sati_lv;

    public StudentInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_info, container, false);

        input_predmet = view.findViewById(R.id.input_predmet);
        input_profesor = view.findViewById(R.id.input_profesor);
        input_godina = view.findViewById(R.id.input_godina);
        input_sati_predavanja = view.findViewById(R.id.input_sati_predavanja);
        input_sati_lv = view.findViewById(R.id.input_sati_lv);

        input_predmet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                fragmentListener.setPredmet(input_predmet.getText().toString());
            }
        });

        input_profesor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                fragmentListener.setProfesor(input_profesor.getText().toString());
            }
        });

        input_godina.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                fragmentListener.setGodina(input_godina.getText().toString());
            }
        });

        input_sati_predavanja.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                fragmentListener.setSatiPredavanja(input_sati_predavanja.getText().toString());
            }
        });

        input_sati_lv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                fragmentListener.setSatiLV(input_sati_lv.getText().toString());
            }
        });

        return view;
    }
}