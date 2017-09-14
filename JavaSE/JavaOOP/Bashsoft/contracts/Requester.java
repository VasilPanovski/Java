package main.bg.softuni.contracts;

import main.bg.softuni.dataStructures.SimpleSortedList;

import java.util.Comparator;

/**
 * Created by mm on 23.7.2016 г..
 */
public interface Requester {

    void getStudentMarkInCourse(String courseName, String studentName);
    void getStudentsByCourse(String courseName);

    SimpleSortedList<Course> getAllCoursesSorted(Comparator<Course> cmp);
    SimpleSortedList<Student> getAllStudentSorted(Comparator<Student> cmp);
}
