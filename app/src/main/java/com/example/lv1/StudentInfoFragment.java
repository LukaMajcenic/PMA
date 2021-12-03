package com.example.lv1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentInfoFragment extends Fragment implements Callback<CourseResponse>
{
    public FragmentListener fragmentListener;
    View view;
    EditText input_godina, input_sati_predavanja, input_sati_lv;
    ArrayList<Course> courses = new ArrayList<>();

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
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_student_info, container, false);

        Course newCourse = new Course();
        newCourse.title = "test";
        //courses.add(newCourse);

        // Initialize the adapter sending the current context
        // Send the simple_spinner_item layout
        // And finally send the Users array (Your data)

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
            courses.addAll(response.body().courses.subList(0,9));
        }

        SpinnerAdapter predmetSpinnerAdapter = new SpinnerAdapter(getActivity(),
                android.R.layout.simple_spinner_item,
                courses, 0);
        Spinner mySpinner = (Spinner) view.findViewById(R.id.spinner_predmet);
        mySpinner.setAdapter(predmetSpinnerAdapter);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int x = position;
                fragmentListener.setPredmet(courses.get(position).title);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SpinnerAdapter profesorSpinnerAdapter = new SpinnerAdapter(getActivity(),
                android.R.layout.simple_spinner_item,
                courses, 1);
        Spinner profesorSpinner = (Spinner) view.findViewById(R.id.spinner_profesor);
        profesorSpinner.setAdapter(profesorSpinnerAdapter);
    }

    @Override
    public void onFailure(Call<CourseResponse> call, Throwable throwable) {
        throwable.printStackTrace();
    }

}