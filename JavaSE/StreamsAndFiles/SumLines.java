import java.io.*;

public class Task1_SumLines {
    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("sources/sometext.txt"))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                getCharactersSum(line);
            }
        } catch (FileNotFoundException fnf) {
            System.out.println("File doesn't exist");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getCharactersSum(String line) {
        int sum = 0;
        for (int i = 0; i < line.length(); i++) {
            sum += (int)line.charAt(i);
        }
        System.out.println(sum);
    }
}
