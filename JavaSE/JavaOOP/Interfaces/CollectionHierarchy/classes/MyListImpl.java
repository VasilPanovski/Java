package pr9_CollectionHierarchy.classes;

import pr9_CollectionHierarchy.interfaces.RemoveCollection;

public class MyListImpl extends MyCollections implements RemoveCollection {

    public MyListImpl() {
        super();
    }

    @Override
    public String remove() {
        return super.getElements().remove(0);
    }
}
