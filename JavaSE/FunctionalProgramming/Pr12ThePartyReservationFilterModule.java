import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Predicate;

/**
 * Created by mm on 9.6.2016 г..
 */
public class Pr12ThePartyReservationFilterModule {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] invitationNames = reader.readLine().trim().split("\\s+");
            ArrayList<String> result = new ArrayList<String>(Arrays.asList(invitationNames));

            String inputLine = null;
            while (!"Print".equals(inputLine = reader.readLine())) {
                String[]tokens = inputLine.trim().split(";");
                String command = tokens[0];
                String filterType = tokens[1];
                String parameter = tokens[2];

                Predicate<String> predicate = findCurrentPredicate(filterType, parameter);

                if (command.equals("Add filter")) {
                    result = proccesAddCommand(result, predicate);
                } else {
                    result = proccesRemoveCommand(result, predicate, invitationNames);
                }
            }
            for (String name : result) {
                System.out.print(name + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<String> proccesRemoveCommand(ArrayList<String> result, Predicate<String> predicate, String[] invitationNames) {
        for (String invitationName : invitationNames) {
            if (predicate.test(invitationName)) {
                result.add(invitationName);
            }
        }
        Collections.reverse(result);
        return result;
    }

    private static ArrayList<String> proccesAddCommand(ArrayList<String> invitationNames, Predicate<String> predicate) {
        ArrayList<String> result = new ArrayList<>();
        for (String invitationName : invitationNames) {
            if (!predicate.test(invitationName)) {
                result.add(invitationName);
            }
        }
        return result;
    }

    private static Predicate<String> findCurrentPredicate(String filterType, String parameter) {
        switch (filterType) {
            case "Starts with":
                return name -> name.startsWith(parameter);
            case "Ends with":
                return name -> name.endsWith(parameter);
            case "Length":
                return name -> name.length() == Integer.parseInt(parameter);
            case "Contains":
                return name -> name.contains(parameter);
            default:
                return null;
        }
    }

}
