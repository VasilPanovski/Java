import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mm on 9.6.2016 г..
 */
public class Pr11_StudentsJoinedToSpecialties {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String inputLine = null;
            List<StudentSpecialty> specialties = new ArrayList<>();
            while (!"Students:".equals(inputLine = reader.readLine())) {
                String[] tokens = inputLine.trim().split("\\s+");
                String specialty = tokens[0] + " " + tokens[1];
                int facultyNumber = Integer.parseInt(tokens[2]);

                specialties.add(new StudentSpecialty(specialty, facultyNumber));
            }

            List<Student> students = new ArrayList<>();
            while (!"END".equals(inputLine = reader.readLine())) {
                String[] tokens = inputLine.trim().split("\\s+");
                int facultyNumber = Integer.parseInt(tokens[0]);
                String studentName = tokens[1] + " " + tokens[2];

                students.add(new Student(studentName, facultyNumber));
            }
            List<String> joined = new ArrayList<>();
            students.stream().flatMap(student -> specialties.stream().filter(specialty -> {
                if (specialty.getFacultyNumber().equals(student.getFacultyNumber())){
                    joined.add(String.format("%s %s %s",
                            student.getStudentName(),
                            student.getFacultyNumber(),
                            specialty.getSpecialtyName()));
                }
                return specialty.getFacultyNumber().equals(student.getFacultyNumber());
            })).collect(Collectors.toList());

            joined.stream().sorted((s1, s2) -> s1.compareTo(s2)).forEach(System.out::println);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Student {
    private String studentName;
    private Integer facultyNumber;

    public Student(String studentName, Integer facultyNumber) {
        this.studentName = studentName;
        this.facultyNumber = facultyNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public Integer getFacultyNumber() {
        return facultyNumber;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setFacultyNumber(Integer facultyNumber) {
        this.facultyNumber = facultyNumber;
    }
}

class StudentSpecialty {
    private String specialtyName;
    private Integer facultyNumber;

    public StudentSpecialty(String specialtyName, Integer facultyNumber) {
        this.specialtyName = specialtyName;
        this.facultyNumber = facultyNumber;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public Integer getFacultyNumber() {
        return facultyNumber;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public void setFacultyNumber(Integer facultyNumber) {
        this.facultyNumber = facultyNumber;
    }
}
