package hw2;

public interface IMap<K, V> {
    V put(K key, V value);
    boolean containsKey(K key);
    boolean containsValue(V value);
    V get(K key);
    V remove(K key);
}
