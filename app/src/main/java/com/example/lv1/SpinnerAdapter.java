package com.example.lv1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;

import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter<Course> {

    private Context context;
    private ArrayList<Course> courses;
    private int meh;

    public SpinnerAdapter(@NonNull Context context, int textViewResourceId, ArrayList<Course> courses, int meh) {
        super(context, textViewResourceId, courses);
        this.context = context;
        this.courses = courses;
        this.meh = meh;
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
        // I created a dynamic TextView here, but you can reference your own  custom layout for each spinner item
        TextView label = (TextView) super.getView(position, convertView, parent);

        switch (meh)
        {
            case 0:
                label.setText(courses.get(position).title);
                break;
            case 1:
                label.setText(courses.get(position).name);
                break;
            default:
                break;
        }

        return label;
    }

    // And here is when the "chooser" is popped up
    // Normally is the same view, but you can customize it if you want
    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);

        switch (meh)
        {
            case 0:
                label.setText(courses.get(position).title);
                break;
            case 1:
                label.setText(courses.get(position).name);
                break;
            default:
                break;
        }

        return label;
    }
}
