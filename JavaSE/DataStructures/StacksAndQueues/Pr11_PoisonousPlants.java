import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by mm on 5.6.2016 г..
 */
public class Pr11_PoisonousPlants {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        ArrayDeque<Integer> plants = new ArrayDeque<>();
        ArrayDeque<Integer> diesPlants = new ArrayDeque<>();
        int plantsCount = scn.nextInt();
        scn.nextLine();
        int day = 1;
        int plantsPreciosDay = plantsCount;

        plants.push(scn.nextInt());
        for (int i = 0; i < plantsCount; i++) {
            plants.push(scn.nextInt());
        }

        int plantsCurrentDay = 0;
        while (true) {
            int previosPlant = plants.poll();
            if (previosPlant <= plants.peek()) {

            }
        }
    }
}
