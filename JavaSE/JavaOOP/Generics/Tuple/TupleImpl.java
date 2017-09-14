package pr10_Tuple;


public class TupleImpl<K, V> implements Tuple<K, V> {
    private K kye;
    private V value;

    public TupleImpl(K kye, V value) {
        this.setKey(kye);
        this.setValue(value);
    }


    @Override
    public K getKey() {
        return this.kye;
    }

    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public void setKey(K key) {
        this.kye = key;
    }

    @Override
    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", this.getKey(), this.getValue());
    }
}
