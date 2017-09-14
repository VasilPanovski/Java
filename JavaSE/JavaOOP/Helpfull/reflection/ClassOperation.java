package reflection;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClassOperation {

    private static final String CLASS_PATH = "java.lang.";
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException,
            InstantiationException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String classToMake = reader.readLine();

        try {
            Class makeClass = Class.forName(CLASS_PATH + classToMake);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Class stringBuilderClass = StringBuilder.class;
        System.out.println(stringBuilderClass.getName()); // java.lang.StringBuilder
        System.out.println(stringBuilderClass.getSimpleName()); // StringBuilder

        // get Parent class from wonted class
        Class<StringBuilder> sbClass = (Class<StringBuilder>) StringBuilder.class.getSuperclass();

        // get all Interfaces implements class StringBuilder
        Class[] interfaces = StringBuilder.class.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

        //make instance with reflection
        StringBuilder builder = (StringBuilder) Class.forName("java.lang.StringBuilder").newInstance();
        Class sb = StringBuilder.class;
        StringBuilder newInstance = (StringBuilder) sb.newInstance();
    }
}
