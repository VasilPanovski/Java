import java.io.*;

public class Task2_AllCapitals {
    private static String FILE_PATH = "sources/sometext.txt";
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;
            while ((line = reader.readLine()) != null) {
                convertToUpperCase(line);
            }


        } catch (FileNotFoundException fnf){
            System.out.println("File doesn't exist!");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void overwriteFile(StringBuilder sb, String filePath) {
        try(PrintWriter writer = new PrintWriter(new File(FILE_PATH))) {

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
    }

    public static void convertToUpperCase(String line){
        StringBuilder sb = new StringBuilder(line);
        for (int i = 0; i < sb.length(); i++) {
            char currentChar = sb.charAt(i);
            if (Character.isLowerCase(currentChar)) {
                sb.setCharAt(i, Character.toUpperCase(currentChar));
            }
        }
        overwriteFile(sb, FILE_PATH);
    }
}
