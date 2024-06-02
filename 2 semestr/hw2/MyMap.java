package hw2;

import java.util.LinkedList;
import java.util.List;

public class MyMap <K, V> implements IMap<K, V> {
    int capacity = 8;
    List<Pair<K, V>>[] map = new LinkedList[capacity];
    int size = 0;

    public V remove(K key){ //удаление по ключу
        int index = Math.abs(key.hashCode()) % capacity;
        if (map[index] == null) return null;
        for (int i = 0; i < map[index].size(); i++){
            if (map[index].get(i).getKey().equals(key)){
                V returning = map[index].get(i).getValue();
                map[index].remove(map[index].get(i));
                size--;
                return returning;
            }
        }
        return null;
    }

    public V put(K key, V value){
        if (size > capacity * 2){
            capacity *= 2;
            List<Pair<K, V>>[] newMap = new LinkedList[capacity];
            for (List<Pair<K, V>> pairs : map) {
                if (pairs == null) continue;
                for (Pair<K, V> pair : pairs) {
                    int index = Math.abs(pair.getKey().hashCode()) % capacity;
                    if (newMap[index] == null) {
                        newMap[index] = new LinkedList<>();
                    }
                    newMap[index].add(pair);
                }
            }
            this.map = newMap;
        }
        int index = Math.abs(key.hashCode()) % capacity;
        if (map[index] == null){
            map[index] = new LinkedList<>();
            map[index].add(new Pair<>(key, value));
            size++;
            return null;
        }
        for (Pair<K, V> pair : map[index]) {
            if (pair.getKey().equals(key)) {
                V returning = pair.getValue();
                pair.setValue(value);
                return returning;
            }
        }
        map[index].add(new Pair<>(key, value));
        size++;
        return null;
    }

    public boolean containsValue(V value){
        for (List<Pair<K, V>> pairs : map){
            if (pairs == null) continue;
            for (Pair<K, V> pair : pairs){
                if (pair.getValue().equals(value)) return true;
            }
        }
        return false;
    }

    public boolean containsKey(K key){
        int index = Math.abs(key.hashCode()) % capacity;
        if (map[index] == null) return false;
        for (Pair<K, V> pair : map[index]){
            if (pair.getKey().equals(key)){
                return true;
            }
        }
        return false;
    }

    public void print(){
        for (List<Pair<K, V>> pairs : map){
            if (pairs == null) continue;
            for (Pair<K, V> pair : pairs){
                System.out.println(pair + " ");
            }
        }
    }

    public V get(K key){
        int index = Math.abs(key.hashCode()) % capacity;
        for (Pair<K, V> pair : map[index]){
            if (pair.getKey().equals(key)) return pair.getValue();
        }
        return null;
    }

}
