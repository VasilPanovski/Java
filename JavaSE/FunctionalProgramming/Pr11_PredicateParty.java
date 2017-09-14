import java.util.*;
import java.util.function.Predicate;


public class Pr11_PredicateParty {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        List<String> names = Arrays.asList(scn.nextLine().split("\\s+"));

        String inputLine;
        while (!"Party!".equals(inputLine = scn.nextLine())) {
            String[] tokens = inputLine.split("\\s+");
            String command = tokens[0];
            String modifier = tokens[1];
            String variable = tokens[2];

            Predicate<String> tester = buildPredicate(modifier, variable);
            if (command.equals("Remove")) {
                names = proccesRemoveCommand(names, tester);
            } else if (command.equals("Double")) {
                names = proccesDoubleCommand(names, tester);
            }
        }
        if (names.size() == 0) {
            System.out.println("Nobody is going to the party!");
        } else {
            String printNames = names.toString().substring(1, names.toString().length() - 1);
            String result = String.format("%s are going to the party!%n", printNames);
            System.out.println(result);
        }
    }

    private static List<String> proccesDoubleCommand(List<String> names, Predicate<String> tester) {
        List<String> result = new ArrayList<>();
        for (String name : names) {
            if (tester.test(name)) {
                result.add(name);
            }
            result.add(name);
        }
        return result;
    }

    private static List<String> proccesRemoveCommand(List<String> names, Predicate<String> tester) {
        List<String> result = new ArrayList<>();
        for (String name : names) {
            if (!tester.test(name)) {
                result.add(name);
            }
        }
        return result;
    }

    private static Predicate<String> buildPredicate(String modiffier, String variable) {
        switch (modiffier) {
            case "StartsWith":
                return name -> name.startsWith(variable);
            case "EndsWith":
                return name -> name.endsWith(variable);
            case "Length":
                return name -> name.length() == Integer.parseInt(variable);
            default:
                return null;
        }
    }
}
