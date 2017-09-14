import com.sun.imageio.plugins.common.BogusColorSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Pr6_TruckTour {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int pumpsCount = Integer.parseInt(reader.readLine());
        ArrayDeque<String> pumpsData = new ArrayDeque<>();

        for (int i = 0; i < pumpsCount; i++) {
            pumpsData.offer(reader.readLine());
        }

        for (int i = 0; i < pumpsCount; i++) {
            long tankFuel = 0;
            long distance = 0;
            boolean isPossible = true;
            for (String pumps : pumpsData) {
                tankFuel += Long.parseLong(pumps.split(" ")[0]);
                distance += Long.parseLong(pumps.split(" ")[1]);

                if (tankFuel < distance) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                System.out.println(i);
                return;
            }
            String temp = pumpsData.pollFirst();
            pumpsData.offer(temp);
        }
    }
}
