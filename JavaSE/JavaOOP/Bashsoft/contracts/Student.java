package main.bg.softuni.contracts;

import java.util.Map;

/**
 * Created by mm on 23.7.2016 г..
 */
public interface Student extends Comparable<Student> {

    String getUserName();
    void setMarkOnCourse(String courseName, int[] scores);
    Map<String, Course> getEnrolledCourses();
    Map<String, Double> getMarksByCourseName();
    String getMarkForCourse(String courseName);
    void enrollInCourse(Course course);
}
