package main.bg.softuni.contracts;

import java.util.HashMap;

/**
 * Created by mm on 23.7.2016 г..
 */
public interface DataFilter {

    void printFilteredStudents(
            HashMap<String, Double> studentsWithMarks,
            String filterType,
            Integer numberOfStudents);
}
