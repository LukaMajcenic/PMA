package com.example.lv1;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable {

    public String title;
    public ArrayList<Instructor> instructors;
    @SerializedName("expected_duration")
    public int expectedDuration;
}
