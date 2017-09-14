package pr1_ListyIterator.models;

import javax.naming.OperationNotSupportedException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/**
 * Created by mm on 19.7.2016 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> elements = new ArrayList<>();

        String[] tokens = reader.readLine().split("\\s+");

        for (int i = 1; i < tokens.length; i++) {
            elements.add(tokens[i]);
        }

        ListyIterator list = null;
        try {
           list = new ListyIteratorImpl<>(elements);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return;
        }


        String command = null;
        while (!"END".equals(command = reader.readLine())) {
            try {
                switch (command.toLowerCase()) {
                    case "hasnext":
                        System.out.println(list.hasNext());
                        break;
                    case "move":
                        System.out.println(list.move());
                        break;
                    case "print":
                        try {
                            list.print();
                        } catch (OperationNotSupportedException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "printall":
                        list.printAll();
                        break;

                    default:
                        throw new InputMismatchException("Invalid command!");
                }
            } catch (InputMismatchException ime) {
                System.out.println(ime.getMessage());
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }
}
