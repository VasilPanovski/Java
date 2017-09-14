package main.bg.softuni.io.commands;

import main.bg.softuni.anotation.Alias;
import main.bg.softuni.anotation.Inject;
import main.bg.softuni.contracts.Course;
import main.bg.softuni.contracts.Database;
import main.bg.softuni.contracts.Student;
import main.bg.softuni.dataStructures.SimpleSortedList;
import main.bg.softuni.exceptions.InvalidInputException;
import main.bg.softuni.io.OutputWriter;

import java.util.Comparator;

@Alias("display")
public class DisplayCommand extends Command {

    @Inject
    private Database database;

    public DisplayCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 3) {
            throw new InvalidInputException(this.getInput());
        }

        String entityToDisplay = data[1];
        String sortType = data[2];
        if (entityToDisplay.equalsIgnoreCase("students")) {
            Comparator<Student> studentComparator = this.createStudentComparator(sortType);
            SimpleSortedList<Student> sortedStudents = this.database.getAllStudentSorted(studentComparator);
            OutputWriter.writeMessageOnNewLine(sortedStudents.joinWith(System.lineSeparator()));
        } else if (entityToDisplay.equalsIgnoreCase("courses")) {
            Comparator<Course> courseComparator = this.createCourseComparator(sortType);
            SimpleSortedList<Course> sortedCourses = this.database.getAllCoursesSorted(courseComparator);
            OutputWriter.writeMessageOnNewLine(sortedCourses.joinWith(System.lineSeparator()));
        } else {
            throw new InvalidInputException(this.getInput());
        }
    }

    private Comparator<Course> createCourseComparator(String sortType) {
        if (sortType.equalsIgnoreCase("ascending")) {
            return (o1, o2) -> o1.compareTo(o2);
        } else if (sortType.equalsIgnoreCase("descending")) {
            return (o1, o2) -> o2.compareTo(o1);
        } else {
            throw new InvalidInputException(this.getInput());
        }
    }

    private Comparator<Student> createStudentComparator(String sortType) {
        if (sortType.equalsIgnoreCase("ascending")) {
            return (o1, o2) -> o1.compareTo(o2);
        } else if (sortType.equalsIgnoreCase("descending")) {
            return (o1, o2) -> o2.compareTo(o1);
        } else {
            throw new InvalidInputException(this.getInput());
        }
    }
}
