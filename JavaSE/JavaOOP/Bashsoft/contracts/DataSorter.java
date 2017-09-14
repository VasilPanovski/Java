package main.bg.softuni.contracts;

import java.util.HashMap;

/**
 * Created by mm on 23.7.2016 г..
 */
public interface DataSorter {

    void printSortedStudents(
            HashMap<String, Double> courseData,
            String comparisonType,
            int numberOfStudents);
}
