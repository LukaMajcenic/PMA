package com.example.lv1;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SummaryFragment extends Fragment implements FragmentObserver {

    View view;
    TextView txt_ime, txt_prezime, txt_datum, txt_godina, txt_predmet, txt_satiPredavanja, txt_satiLV, txt_profesor;
    ImageView imageViewProfilna;
    Button btn_spremi;

    public FragmentListener fragmentListener;

    public SummaryFragment() {
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
        view = inflater.inflate(R.layout.fragment_summary, container, false);

        txt_ime = view.findViewById(R.id.txt_ime);
        txt_prezime = view.findViewById(R.id.txt_prezime);
        txt_datum = view.findViewById(R.id.txt_datum);
        txt_godina = view.findViewById(R.id.txt_godina);
        txt_predmet = view.findViewById(R.id.txt_predmet);
        txt_satiPredavanja = view.findViewById(R.id.txt_satiPredavanja);
        txt_satiLV = view.findViewById(R.id.txt_satiLV);
        txt_profesor = view.findViewById(R.id.txt_profesor);
        imageViewProfilna = view.findViewById(R.id.imageViewSummary);
        btn_spremi = view.findViewById(R.id.btn_exit);

        updateValues();

        btn_spremi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), HomeActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Student newStudent = new Student(
                        fragmentListener.getIme(),
                        fragmentListener.getPrezime(),
                        fragmentListener.getPredmet());
                StudentList studentList = StudentList.getInstance();
                studentList.AddStudent(newStudent);
                i.putExtra("student", newStudent);
                startActivity(i);
            }
        });

        return view;
    }

    @Override
    public void updateValues() {
        if(fragmentListener != null && view != null) {
            txt_ime.setText(fragmentListener.getIme());
            txt_prezime.setText(fragmentListener.getPrezime());
            txt_datum.setText(fragmentListener.getDatum());
            txt_godina.setText(fragmentListener.getGodina());
            txt_predmet.setText(fragmentListener.getPredmet());
            txt_satiPredavanja.setText(fragmentListener.getSatiPredavanja());
            txt_satiLV.setText(fragmentListener.getSatiLV());
            txt_profesor.setText(fragmentListener.getProfesor());
            imageViewProfilna.setImageBitmap(fragmentListener.getProfilna());
        }
    }
}