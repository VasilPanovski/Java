import java.io.*;
import java.util.Arrays;
import java.util.List;

public class SaveCustomObjectInFile {
    public static class Course implements Serializable {
        private String name;
        private int numberOfStudents;

        public Course(String aName, int aNumbersOfStudenta) {
            this.name = aName;
            this.numberOfStudents = aNumbersOfStudenta;
        }
    }

//    public void main(String[] args) {
//        Course cSharp = new Course("C# Fundamentals", 200);
//        Course java = new Course("Java Fundamentals", 250);
//        Course oopJava = new Course("Java OOP", 100);
//    }
//
//    public static void saveObjects(Course course) {
//        try(
//                ObjectOutputStream objWriter = new ObjectOutputStream(
//                        new BufferedOutputStream(new FileOutputStream("src/course.save")))) {
//                        objWriter.writeObject(course);
//
//        } catch (FileNotFoundException e) {
//            System.err.println("File not found!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public static void loadObject(Course course) {
//        try(ObjectInputStream objReader = new ObjectInputStream(
//                new BufferedInputStream(new FileInputStream("src/course.save")))) {
//                String newObject = objReader.readObject().toString();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        List<Course> cources = Arrays.asList(
                new Course("C# Fundamentals", 200),
                new Course("Java Fundamentals", 250),
                new Course("Java OOP", 100));
        try (
                ObjectOutputStream writer =
                        new ObjectOutputStream(
                                new BufferedOutputStream(
                                        new FileOutputStream("sources/course.save")))
        ) {
            writer.writeObject(cources);
        }
        try (
                ObjectInputStream reader =
                        new ObjectInputStream(
                                new BufferedInputStream(
                                        new FileInputStream("sources/course.save")))
        ) {
            String fileRead = reader.readObject().toString();
            System.out.println(fileRead);
        }
    }
}