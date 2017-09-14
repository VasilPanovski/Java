package pr10_Tuple;


public interface Tuple<K, V> {

    K getKey();

    V getValue();

    void setKey(K key);

    void setValue(V value);
}
