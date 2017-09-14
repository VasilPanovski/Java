import java.io.*;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class CSVDatabase {
    public static void main(String[] args) throws IOException {
        try(BufferedReader bufferReaderStudents = new BufferedReader(new FileReader("resources/students.txt"));
            BufferedReader bufferReaderGrades = new BufferedReader(new FileReader("resources/grades.txt"))) {

            Scanner scanner = new Scanner(System.in);
            executingCommands(bufferReaderGrades, bufferReaderStudents,scanner);
        } catch (NoSuchElementException noElementFound){

            System.err.println("Student does not exist");
        }
    }

    private static void executingCommands(BufferedReader bufferReaderGrades, BufferedReader bufferReaderStudents, Scanner scanner) throws IOException {
        boolean invalidCommand = true;
        while (invalidCommand){
            String command = scanner.nextLine();
            if(command.contains("Search-by-full-name")){
                searchingByName(command, bufferReaderGrades, bufferReaderStudents);
                invalidCommand = false;
            } else if(command.contains("Search-by-id")){
                searchingById(command, bufferReaderGrades, bufferReaderStudents);
                invalidCommand = false;
            } else if(command.contains("Delete-by-id")) {
                deletingById(command,bufferReaderGrades, bufferReaderStudents);
                invalidCommand = false;
            } else if(command.contains("Update-by-id")){
                updatingByID(command, bufferReaderGrades, bufferReaderStudents, scanner);
                invalidCommand = false;
            } else if(command.contains("Insert-student")) {
                insertingNewStudent(command,bufferReaderStudents);
                invalidCommand =false;
            } else if(command.contains("Insert-grade-by-id")){
                insertingGradeByID(command,bufferReaderGrades, bufferReaderStudents);
                invalidCommand =false;
            }
            if(invalidCommand) {
                System.out.println("Invalid command. Enter a command again: ");
            }
        }

    }

    private static void insertingGradeByID(String command, BufferedReader bufferReaderGrades, BufferedReader bufferReaderStudents) throws IOException {
        HashMap<String, String> grades = new HashMap<>();
        String gradesOfStudent;
        String[] gradeToInsert = command.split(" ");
        String searchedId = gradeToInsert[1];
        Integer biggestID  = 0;
        while (!((gradesOfStudent = bufferReaderGrades.readLine()) == null)) {
            String studentId = gradesOfStudent.split(",")[0];
            Integer currentStudentID = Integer.parseInt(studentId);
            if(currentStudentID > biggestID) {
                biggestID = currentStudentID;
            }
            // we check if we have entered the line containing the ID we are searching for and then update the grades of the student otherwise we just put the line as it is in the hashmap.
            if (studentId.equals(searchedId)) {

                String[] courses = gradesOfStudent.split(","); // splitting the courses so we can overwrite only the one we need
                StringBuilder updatedGrades = new StringBuilder();
                String updatedCourse = gradeToInsert[2]; // reading the course in which we must insert the
                // checking if this is a course the students attend or a new one.
                if (gradesOfStudent.contains(updatedCourse)) {
                    for (int i = 1; i < courses.length; i++) {
                        if (courses[i].contains(updatedCourse)) {
                            updatedGrades.append("," + courses[i] + " " + gradeToInsert[3]);
                        } else {
                            updatedGrades.append("," + courses[i]);
                        }
                    }
                } else {

                    for (int i = 1; i < courses.length ; i++) {
                        updatedGrades.append("," + courses[i]);
                    }
                    for (int i = 2; i < gradeToInsert.length; i++) {
                        updatedGrades.append("," + gradeToInsert[i]);
                    }

                }
                grades.put(studentId, updatedGrades.toString());
            } else {
                grades.put(studentId, gradesOfStudent.substring(studentId.length())); // here I am taking the substring after the id at the beginning and write the new ID after the student has been deleted
            }
        }

        try (BufferedWriter bufferWriterGrades = new BufferedWriter(new FileWriter("resources/grades.txt"))) {
            for (String id : grades.keySet()) {
                bufferWriterGrades.write(id + grades.get(id) + "\n");
            }
            // here I am checking if the id we are searching for is bigger than the biggest id of the grades. If it is I check in the students list if there is a student with this id and if there is I enter the grades of this student in the grades list.
            if(Integer.parseInt(searchedId) > biggestID) {
                if(bufferReaderStudents.lines().noneMatch(line-> line.split(",")[0].equals(searchedId))){
                    System.out.println("Students doesn't exist");
                } else {
                    String[] gradesToInsert = command.split(" ");
                    bufferWriterGrades.write(searchedId + "," + command.substring(gradesToInsert[0].length() + gradesToInsert[1].length() + 2) + "\n"); // it is plus 2 because of the whitespaces I have removed in the split.
                }

            }
        }
    }
    private static void insertingNewStudent(String command, BufferedReader bufferReaderStudents) throws IOException {
        Integer biggestId = 0;
        String student;
        HashMap<Integer, String> students = new HashMap<>();
        while (!((student = bufferReaderStudents.readLine()) == null)){
            String studentId = student.split(",")[0];
            Integer currentId = Integer.parseInt(studentId);
            students.put(currentId, student.substring(studentId.length()));
            if(currentId > biggestId){
                biggestId = currentId;
            }
        }
        StringBuilder newStudent = new StringBuilder();
        String[] dataOfNewStudent = command.split(" ");
        for (int i = 1; i < dataOfNewStudent.length; i++) {
            newStudent.append("," + dataOfNewStudent[i]);
        }
        try (BufferedWriter bufferWriterStudents = new BufferedWriter(new FileWriter("resources/students.txt"))) {
            for(Integer id: students.keySet()){
                bufferWriterStudents.write(id + students.get(id) + "\n");
            }
            bufferWriterStudents.write(biggestId + 1 + newStudent.toString() + "\n");
        }
    }


    private static void updatingByID(String command, BufferedReader bufferReaderGrades, BufferedReader bufferReaderStudents, Scanner scanner) throws IOException {
        Integer searchedId = Integer.parseInt(command.split(" ")[1]);
        HashMap<Integer, String> students = new HashMap<>();
        HashMap<Integer, String> grades = new HashMap<>();

        System.out.println("Write \"grades\" if you want to update the grades or write \"info\" if you want to update the info of the student: ");
        String chosenUpdate = scanner.nextLine();
        while (!(chosenUpdate.equals("info") || chosenUpdate.equals("grades"))) {
            System.out.println("You must enter \"info\" or \"grades\"");
            chosenUpdate = scanner.nextLine();
        }
        if (chosenUpdate.equals("info")) {
            updatingStudents(students, bufferReaderStudents, searchedId, scanner);
            try (BufferedWriter bufferWriterStudents = new BufferedWriter(new FileWriter("resources/students.txt"))) {
                for(Integer id: students.keySet()){

                    bufferWriterStudents.write(id + students.get(id) + "\n");
                }
            }
        } else {
            updatingGrades(grades, bufferReaderGrades, searchedId, scanner);
            try (BufferedWriter bufferWriterGrades = new BufferedWriter(new FileWriter("resources/grades.txt"))) {
                for (Integer id : grades.keySet()) {
                    bufferWriterGrades.write(id + grades.get(id) + "\n");
                }
            }
        }
    }
    private static void updatingGrades(HashMap<Integer, String> grades, BufferedReader bufferReaderGrades, Integer searchedId, Scanner scanner) throws IOException {
        String gradesOfStudent;

        while (!((gradesOfStudent = bufferReaderGrades.readLine()) == null)) {
            String studentId = gradesOfStudent.split(",")[0];
            Integer id = Integer.parseInt(studentId);
            // we check if we have entered the line containing the ID we are searching for and then update the grades of the student otherwise we just put the line as it is in the hashmap.
            if (id.equals(searchedId)) {
                System.out.println("Write the course you want to update and all the grades after that.If the student doesn't attend this course you should first insert it. You cannot enter more than one course at a time. Example: \"Literature 4.00, 5.25\"");
                StringBuilder updatedGrades = new StringBuilder(); // saving the whole grade in a stringBuilder
                String[] courses = gradesOfStudent.split(","); // splitting the courses so we can overwrite only the one we need
                String updatedCourse = scanner.nextLine(); // reading the course
                // checking if this is a course the students attend or a new one.
                if(gradesOfStudent.contains(updatedCourse)){
                    for (int i = 1; i < courses.length ; i++) {
                        if(courses[i].contains(updatedCourse.split(" ")[0])){
                            updatedGrades.append("," + updatedCourse);
                        } else {
                            updatedGrades.append("," + courses[i]);
                        }
                    }

                } else {
                    System.out.println("The student doesn't take this course you should update his information with the new course and the grade first.");
                }
                grades.put(id, updatedGrades.toString());
            } else {
                grades.put(id, gradesOfStudent.substring(studentId.length())); // here I am taking the substring after the id at the beginning and write the new ID after the student has been deleted
            }
        }
    }

    private static void updatingStudents(HashMap<Integer, String> students, BufferedReader bufferReaderStudents, Integer searchedId, Scanner scanner) throws IOException {

        String student;

        while (!((student = bufferReaderStudents.readLine()) == null)) {
            String studentId = student.split(",")[0];
            Integer id = Integer.parseInt(studentId);
            if (id.equals(searchedId)) {
                System.out.println("Write all the info after that. EX: \"First name, Second name, age, hometown\"");


                String updatedStudent = scanner.nextLine();
                students.put(id, "," + updatedStudent);

            } else {
                students.put(id, student.substring(studentId.length())); // here I am taking the substring after the id at the beginning and write the new ID after the student has been deleted
            }
        }
    }
    private static void deletingById(String command, BufferedReader bufferReaderGrades, BufferedReader bufferReaderStudents) throws IOException {
        Integer searchedId = Integer.parseInt(command.split(" ")[1]);
        HashMap<Integer, String> students = new HashMap<>();
        HashMap<Integer, String> grades = new HashMap<>();
        puttingTheStudentsInAHashMap(students, bufferReaderStudents, searchedId);
        puttingTheGradesInAHashMap(grades, bufferReaderGrades, searchedId);


        try (BufferedWriter bufferWriterStudents = new BufferedWriter(new FileWriter("resources/students.txt"));
             BufferedWriter bufferWriterGrades = new BufferedWriter(new FileWriter("resources/grades.txt"))) {
            for(Integer id: grades.keySet()){
                bufferWriterGrades.write(id + grades.get(id) + "\n");
            }
            for(Integer id: students.keySet()){
                bufferWriterStudents.write(id + students.get(id) + "\n");
            }
        }
    }
    private static void puttingTheGradesInAHashMap(HashMap<Integer, String> grades, BufferedReader bufferReaderGrades, Integer searchedId) throws IOException {
        String grade;

        while (!((grade = bufferReaderGrades.readLine()) == null)) {
            String studentId = grade.split(",")[0];
            Integer id = Integer.parseInt(studentId);
            if (id.equals(searchedId)) {
                continue;
            } else if (searchedId < id) {
                id--; // here I am reducing the Id with one to every student who has a bigger Id than the one we are deleting.
            }
            grades.put(id, grade.substring(studentId.length())); // here I am taking the substring after the id at the beginning and write the new ID after the student has been deleted
        }
    }
    private static void puttingTheStudentsInAHashMap(HashMap<Integer, String> students, BufferedReader bufferReaderStudents, Integer searchedId) throws IOException {
        String student;

        while (!((student = bufferReaderStudents.readLine()) == null)){
            String studentId = student.split(",")[0];
            Integer id = Integer.parseInt(studentId);
            if(id.equals(searchedId)){
                continue;
            } else if(searchedId < id){
                id--; // here I am reducing the Id with one to every student who has a bigger Id than the one we are deleting.
            }
            students.put(id, student.substring(studentId.length())); // here I am taking the substring after the id at the beginning and write the new ID after the student has been deleted
        }
    }

    private static void searchingById(String command, BufferedReader bufferReaderGrades, BufferedReader bufferReaderStudents) {
        String searchedId = command.split(" ")[1];
        String student = bufferReaderStudents
                .lines()
                .filter(studentID -> studentID.split(",")[0].equals(searchedId))
                .findFirst()
                .get();
        String grades = bufferReaderGrades
                .lines()
                .filter(gradeID -> gradeID.split(",")[0].equals(searchedId))
                .findFirst()
                .get();
        output(grades, student);
    }

    private static void searchingByName(String command, BufferedReader bufferReaderGrades, BufferedReader bufferReaderStudents) {
        String firstName = command.split(" ")[1];
        String lastName = command.split(" ")[2];
        String student = bufferReaderStudents
                .lines()
                .filter(studentName -> studentName.contains(firstName) && studentName.contains(lastName))
                .findFirst()
                .get();
        String studentId = student.split(",")[0];
        String grades = bufferReaderGrades
                .lines()
                .filter(gradeID -> gradeID.split(",")[0].equals(studentId))
                .findFirst()
                .get();
        output(grades, student);
    }

    private static void output(String grades, String student) {
        String[] studentData = student.split(",");
        String[] studentGrades = grades.split(",");
        System.out.printf("%s %s (age: %s, town: %s)\n", studentData[1], studentData[2], studentData[3], studentData[4]);
        for (int i = 1; i < studentGrades.length; i++) {
            String[] grade = studentGrades[i].split(" ");
            String subject = grade[0];

            System.out.printf("# %s: ", subject);
            for (int j = 1; j < grade.length; j++) {
                if(j == grade.length - 1){
                    System.out.println(grade[j]);
                } else {
                    System.out.print(grade[j] + ",");
                }
            }
        }
    }
}
