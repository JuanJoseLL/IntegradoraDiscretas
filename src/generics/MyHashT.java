package generics;
public interface MyHashT<K,V> {
    public void insert(K key, V value);
    public V search(K key);
    public void deleteKey(K key);

}
