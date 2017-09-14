package main.bg.softuni.contracts;

/**
 * Created by mm on 23.7.2016 г..
 */
public interface FilteredTaker {

    void filterAndTake(String courseName, String filter);
    void filterAndTake(String courseName, String filter, int studentsToTake);
}
