package pr9_CollectionHierarchy.classes;

import pr9_CollectionHierarchy.interfaces.RemoveCollection;

/**
 * Created by mm on 13.7.2016 г..
 */
public class AddRemoveCollection extends MyCollections implements RemoveCollection {


    public AddRemoveCollection() {
        super();
    }

    @Override
    public String remove() {
        int indexToRemove = super.getElements().size() - 1;
        String lastItem = super.getElements().get(indexToRemove);
        super.getElements().remove(lastItem);
        return lastItem;
    }
}
