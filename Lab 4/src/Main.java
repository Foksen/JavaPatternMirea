import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 6; ++i) {
            executorService.submit(() -> {
                System.out.println("Thread " + Thread.currentThread().getName() + " started");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread " + Thread.currentThread().getName() + " finished");
            });
        }
        executorService.shutdown();
    }
}