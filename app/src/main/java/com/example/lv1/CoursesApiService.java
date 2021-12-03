package com.example.lv1;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoursesApiService {

    @GET("/v1/courses")
    Call<CourseResponse> getCourses();
}
