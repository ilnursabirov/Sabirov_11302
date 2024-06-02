package hw2;

public interface IList<T> {
    int size();
    boolean isEmpty();
    boolean contains(T value);
    boolean containsIndex(int index);
    int indexOf(T value);
    boolean add(T value);
    void add(int index, T value);
    T get(int index);
    T getByValue(T value);
    void removeByIndex(int index);
    boolean remove(T value);
}
