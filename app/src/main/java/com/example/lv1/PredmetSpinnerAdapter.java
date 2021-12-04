package com.example.lv1;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class PredmetSpinnerAdapter extends ArrayAdapter<Course> {

    private Context context;
    private ArrayList<Course> courses;

    public PredmetSpinnerAdapter(@NonNull Context context, int textViewResourceId, ArrayList<Course> courses) {
        super(context, textViewResourceId, courses);
        this.context = context;
        this.courses = courses;
    }

    @Override
    public int getCount(){
        return courses.size();
    }

    @Override
    public Course getItem(int position){
        return courses.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return setLayout(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        return setLayout(position, convertView, parent);
    }

    public View setLayout(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.predmet_spinner_single_item, null);

            Course selectedCourse = courses.get(position);

            TextView textViewNaziv = (TextView) convertView.findViewById(R.id.spinner_txt_predmet_naziv);
            textViewNaziv.setText(selectedCourse.title);

            TextView textViewDetalji = (TextView) convertView.findViewById(R.id.spinner_txt_predmet_detalji);
            textViewDetalji.setText(selectedCourse.level + (selectedCourse.starter ? " • starter" : ""));
        }

        return convertView;
    }
}
