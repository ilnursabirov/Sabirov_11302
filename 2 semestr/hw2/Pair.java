package hw2;

public class Pair<K, V> {
    final private K key;
    private V value;
    public K getKey() { return key; }
    public V getValue() { return value; }
    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }
    public void setValue(V value){
        this.value = value;
    }
    @Override
    public String toString(){
        return "key: " + key + " value: " + value;
    }
}
