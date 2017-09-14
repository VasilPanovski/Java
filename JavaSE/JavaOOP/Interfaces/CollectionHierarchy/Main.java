package pr9_CollectionHierarchy;

import pr9_CollectionHierarchy.classes.AddCollectionImpl;
import pr9_CollectionHierarchy.classes.AddRemoveCollection;
import pr9_CollectionHierarchy.classes.MyListImpl;
import pr9_CollectionHierarchy.interfaces.AddCollection;
import pr9_CollectionHierarchy.interfaces.MyList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mm on 13.7.2016 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        AddCollection addCollection = new AddCollectionImpl();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyList myList = new MyListImpl();

        String[] params = reader.readLine().trim().split("\\s+");

        for (String param : params) {
            int index = addCollection.add(param);
            System.out.print(index + " ");
        }
        System.out.println();

        for (String param : params) {
            int index = addRemoveCollection.add(param);
            System.out.print(index + " ");
        }
        System.out.println();

        for (String param : params) {
            int index = myList.add(param);
            System.out.print(index + " ");
        }
        System.out.println();

        int removeCount = Integer.valueOf(reader.readLine());

        for (int i = 0; i < removeCount; i++) {
            String currentItem = addRemoveCollection.remove();
            System.out.print(currentItem + " ");
        }
        System.out.println();
        for (int i = 0; i < removeCount; i++) {
            String currentItem = myList.remove();
            System.out.print(currentItem + " ");
        }
    }
}
