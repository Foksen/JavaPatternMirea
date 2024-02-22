import java.util.HashSet;
import java.util.concurrent.Semaphore;

public class SemaphoreSet<T> {
    private final Semaphore semaphore;
    private final HashSet<T> set;

    public SemaphoreSet() {
        semaphore = new Semaphore(1);
        set = new HashSet<>();
    }

    public void add(T x) {
        try {
            semaphore.acquire();
            set.add(x);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void remove(T x) {
        try {
            semaphore.acquire();
            set.remove(x);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int size() {
        int size = 0;
        try {
            semaphore.acquire();
            size = set.size();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return size;
    }
}
