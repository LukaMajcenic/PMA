package com.example.lv1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentInfoFragment extends Fragment implements Callback<CourseResponse>
{
    public FragmentListener fragmentListener;
    private View view;
    private EditText input_godina, input_sati_predavanja, input_sati_lv;
    private ArrayList<Course> courses = new ArrayList<>();

    public StudentInfoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ApiManager.getInstance().service().getCourses().enqueue(this); //asinkroni poziv
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_student_info, container, false);

        input_godina = view.findViewById(R.id.input_godina);
        input_sati_predavanja = view.findViewById(R.id.input_sati_predavanja);
        input_sati_lv = view.findViewById(R.id.input_sati_lv);

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

    @Override
    public void onResponse(Call<CourseResponse> call, Response<CourseResponse> response) {
        if (response.isSuccessful() && response.body() != null){
            for(Course course : response.body().courses)
            {
                if(course.instructors != null)
                {
                    courses.add(course);
                }
            }
        }

        PredmetSpinnerAdapter predmetSpinnerAdapter = new PredmetSpinnerAdapter(getActivity(),
                android.R.layout.simple_spinner_item,
                courses);
        Spinner predmetSpinner = (Spinner) view.findViewById(R.id.spinner_predmet);
        predmetSpinner.setAdapter(predmetSpinnerAdapter);
        predmetSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                fragmentListener.setPredmet(courses.get(position));

                ProfesorSpinnerAdapter profesorSpinnerAdapter = new ProfesorSpinnerAdapter(getActivity(),
                        android.R.layout.simple_spinner_item,
                        fragmentListener.getPredmet().instructors);
                Spinner profesorSpinner = (Spinner) view.findViewById(R.id.spinner_profesor);
                profesorSpinner.setAdapter(profesorSpinnerAdapter);

                profesorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                        fragmentListener.setProfesor(fragmentListener.getPredmet().instructors.get(position));
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onFailure(Call<CourseResponse> call, Throwable throwable) {
        throwable.printStackTrace();
    }

}