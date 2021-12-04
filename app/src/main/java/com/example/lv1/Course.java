package com.example.lv1;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Course implements Serializable {

    public String title;
    public ArrayList<Instructor> instructors;
    public String level;
    public boolean starter;

    @SerializedName("launch_date") public String launchDate;
}
