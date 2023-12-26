package Lab10b.Ex1;

public class Word<K,V> {
    private K key;
    private V value;

    public Word(K key  ,V value  ) {
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }


    public boolean isKey(K key1) {
        return (this.key.equals(key1));
    }
}
