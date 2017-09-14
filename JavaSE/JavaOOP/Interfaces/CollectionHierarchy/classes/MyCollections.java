package pr9_CollectionHierarchy.classes;

import pr9_CollectionHierarchy.interfaces.AddCollection;
import pr9_CollectionHierarchy.interfaces.MyList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mm on 13.7.2016 г..
 */
public abstract class MyCollections implements AddCollection, MyList {
    private List<String> elements;

    public MyCollections() {
        this.elements = new ArrayList<>();
    }

    protected List<String> getElements() {
        return elements;
    }

    @Override
    public int add(String item) {
        this.elements.add(0, item);
        return 0;
    }

    @Override
    public int getUsed() {
        return this.getElements().size();
    }
}
