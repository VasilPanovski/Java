import sun.plugin.javascript.navig.Array;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SaveInArrayListOfDouble {
    public static void main(String[] args) {
        ArrayList<Double> doublesArr = new ArrayList<Double>();
        doublesArr.addAll(Arrays.asList(2.5, 3.4, 12.5, 22.22, 2.0));

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sources/doubles.list"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sources/doubles.list"));

            for (Double aDouble : doublesArr) {
                oos.writeDouble(aDouble);
            }

            for (int i = 0; i < doublesArr.size(); i++) {
                while (ois.available() > 0) {
                    System.out.println(ois.readDouble());
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
