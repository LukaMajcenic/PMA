package com.example.lv1;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Course {

    public String title;
    public ArrayList<Instructor> instructors;
    @SerializedName("apply_required")
    public boolean applyRequired;
    public boolean available;
    @SerializedName("banner_image")
    public String bannerImage;
    public boolean capped;
    @SerializedName("expected_duration")
    public int expectedDuration;

    @Override
    public String toString() {
        return this.title; // What to display in the Spinner list.
    }
}
