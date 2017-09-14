package httpProtocol.greetings;


import utils.WebUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Greetings {

    public static final String DATA_FILE =
            "C:\\Apache24\\htdocs\\others\\greetings.txt";

    public static void main(String[] args) {
       setContent();
       setResponse();
    }

    private static void setResponse() {
        try(BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String params = reader.readLine();
            String[] tokens = params.split(",");
            String firstName = tokens[0];
            String lastName = tokens[1];
            String age = WebUtils.getParameters().get("age");
            System.out.println(String.format("Hello %s %s at age %s!", firstName, lastName, age));
            WebUtils.writeToFile(DATA_FILE, "", false);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void setContent() {
        String type = "Content-Type: text/html\n";
        System.out.println(type);
    }
}
