import java.util.*;

public class Problem4_LogsAggregator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int linesCount = Integer.parseInt(input.nextLine());

        TreeMap<String, TreeMap<String, Integer>> users = new TreeMap<>();

        String ipAddress, user;
        int duration = 0;

        for (int i = 0; i < linesCount; i++) {
            String[] currentLineArgs = input.nextLine().split("\\s+");
            ipAddress = currentLineArgs[0];
            user = currentLineArgs[1];
            duration = Integer.parseInt(currentLineArgs[2]);

            if (!users.containsKey(user)) {
                users.put(user, new TreeMap<String, Integer>());
            }

            TreeMap<String, Integer> ips = users.get(user);

            int updatedDuration = duration;
            if (ips.containsKey(ipAddress)) {
                updatedDuration += ips.get(ipAddress);
            }

            ips.put(ipAddress, updatedDuration);
        }

        for (String us : users.keySet()) {
            System.out.print(us + ": ");
            
            int totalMinutes = 0;
            for (String ip : users.get(us).keySet()) {
                totalMinutes += users.get(us).get(ip);
            }
            System.out.println(totalMinutes + " " + users.get(us).keySet());
        }
    }
}
