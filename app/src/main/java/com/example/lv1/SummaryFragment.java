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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SummaryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SummaryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView txt_ime, txt_prezime, txt_datum, txt_godina, txt_predmet, txt_satiPredavanja, txt_satiLV, txt_profesor;
    ImageView imageViewProfilna;
    Button btn_spremi;

    public FragmentListener fragmentListener;

    public SummaryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SummaryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SummaryFragment newInstance(String param1, String param2) {
        SummaryFragment fragment = new SummaryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_summary, container, false);

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
    public void onResume(){
        super.onResume();

        if(fragmentListener != null) {
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