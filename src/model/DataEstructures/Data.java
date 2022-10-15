package model.DataEstructures;
public class Data<K,V> {
    private K key;
    private V value;

    private Data<K,V> next;

    private Data<K,V> previous;

    public Data(K key, V value) {
        this.value = value;
        this.key = key;
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

    public Data<K, V> getNext() {
        return next;
    }

    public void setNext(Data<K, V> next) {
        this.next = next;
    }

    public Data<K, V> getPrevious() {
        return previous;
    }

    public void setPrevious(Data<K, V> previous) {
        this.previous = previous;
    }
}
