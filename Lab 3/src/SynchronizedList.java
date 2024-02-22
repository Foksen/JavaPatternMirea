import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SynchronizedList<T> {
    private final Object lock;
    private final ArrayList<T> list;

    public SynchronizedList() {
        this.lock = new Object();
        this.list = new ArrayList<>();
    }

    public SynchronizedList(List<T> list) {
        this.lock = new Object();
        this.list = new ArrayList<>(list);
    }

    public void add(T x) {
        synchronized (lock) {
            list.add(x);
        }
    }

    public T remove(int index) {
        synchronized (lock) {
            return list.remove(index);
        }
    }

    public T get(int index) {
        synchronized (lock) {
            return list.get(index);
        }
    }

    public int size() {
        synchronized (lock) {
            return list.size();
        }
    }

    public void set(int index, T value) {
        synchronized (lock) {
            list.set(index, value);
        }
    }

    public void print() {
        synchronized (lock) {
            list.forEach(t -> System.out.print(t + " "));
            System.out.println();
        }
    }
}
