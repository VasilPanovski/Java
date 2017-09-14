package pr4_Telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mm on 11.7.2016 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] phoneNumbers = reader.readLine().trim().split("\\s+");
        String[] sites = reader.readLine().trim().split("\\s+");


        for (String phoneNumber : phoneNumbers) {
            try {
                Callable smartphone = new Smartphone(phoneNumber, "");
                smartphone.callPhoneNumber();
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        for (String site : sites) {
            try {
                Brawsable siteToBrowse = new Smartphone("1", site);
                siteToBrowse.browseSite();
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

    }
}
