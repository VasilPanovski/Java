import java.io.*;

public class CountCharacterTypes {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("sources/words.txt"))) {
            String line;
            while ((line = br.readLine()) != null){
                writeInFile(printCharacterTipes(line));
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file doesn't exist!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String printCharacterTipes(String line){
        String vowels = "aeiou";
        int vowelsCount = 0;
        int consonantsCount = 0;
        int punctuations = 0;
        for (int i = 0; i < line.length(); i++) {
            if (!Character.isLetter(line.charAt(i)) && line.charAt(i) != ' ') {
                punctuations++;
            } else if (vowels.contains(Character.toString(line.charAt(i)))){
                vowelsCount++;
            } else if (!vowels.contains(Character.toString(line.charAt(i))) &&
                    line.charAt(i) != ' ') {
                consonantsCount++;
            }
        }
        String result = "Vowels: " + vowelsCount + "\nConsonants: " + consonantsCount +
                                                    "\nPunctuation: " + punctuations;
        return result;
    }

    public static void writeInFile(String line) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File("sources/count-chars.txt")))) {
            PrintWriter writer = new PrintWriter(bw, true);
            writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
