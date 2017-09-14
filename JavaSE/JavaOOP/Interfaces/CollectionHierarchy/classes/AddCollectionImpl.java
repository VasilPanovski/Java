package pr9_CollectionHierarchy.classes;


import pr9_CollectionHierarchy.interfaces.AddCollection;

public class AddCollectionImpl extends MyCollections implements AddCollection{

    public AddCollectionImpl() {
        super();
    }


    @Override
    public int add(String item) {
        super.getElements().add(item);
        return super.getElements().size() - 1;
    }

    @Override
    public String remove() {
        return null;
    }
}
