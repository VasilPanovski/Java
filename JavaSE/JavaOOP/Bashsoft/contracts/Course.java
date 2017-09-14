package main.bg.softuni.contracts;

import java.util.Map;

/**
 * Created by mm on 23.7.2016 г..
 */
public interface Course extends Comparable<Course> {

    String getName();
    Map<String, Student> getStudentsByName();
    void enrollStudent(Student student);
}
