package com.sujina.prepacnc.models;

public class RecyclerDataRoom {
    String CourseYear;
    String IsRattrap;

    public RecyclerDataRoom(String courseYear, String isRattrap) {
        CourseYear = courseYear;
        IsRattrap = isRattrap;
    }
    public String getCourseYear() {
        return CourseYear;
    }

    public void setCourseYear(String courseYear) {
        CourseYear = courseYear;
    }

    public String getIsRattrap() {
        return IsRattrap;
    }

    public void setIsRattrap(String isRattrap) {
        IsRattrap = isRattrap;
    }
}
