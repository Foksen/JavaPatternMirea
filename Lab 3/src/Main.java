import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        testArrayList();
        testSynchronizedList();
        testHashSet();
        testSemaphoreSet();
    }

    private static void testArrayList() throws InterruptedException {
        ArrayList <Integer> arrayList = new ArrayList<>(Collections.nCopies(10000, 1));
        Thread t1 = new Thread() {
            public void run() {
                System.out.println("ArrayList T1 (" + currentThread().getName() + ") start");
                for (int i = 0; i < 5000; ++i) {
                    arrayList.remove(0);
                }
                System.out.println("ArrayList T1 (" + currentThread().getName() + ") finish");
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                System.out.println("ArrayList T2 (" + currentThread().getName() + ") start");
                for (int i = 0; i < 5000; ++i) {
                    arrayList.remove(0);
                }
                System.out.println("ArrayList T2 (" + currentThread().getName() + ") finish");
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("ArrayList size: " + arrayList.size() + " (should be 0)");
    }

    private static void testSynchronizedList() throws InterruptedException {
        SynchronizedList<Integer> synchronizedList = new SynchronizedList<>(Collections.nCopies(10000, 1));
        Thread t1 = new Thread() {
            public void run() {
                System.out.println("SynchronizedList T1 (" + currentThread().getName() + ") start");
                for (int i = 0; i < 5000; ++i) {
                    synchronizedList.remove(0);
                }
                System.out.println("SynchronizedList T1 (" + currentThread().getName() + ") finish");
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                System.out.println("SynchronizedList T2 (" + currentThread().getName() + ") start");
                for (int i = 0; i < 5000; ++i) {
                    synchronizedList.remove(0);
                }
                System.out.println("SynchronizedList T2 (" + currentThread().getName() + ") finish");
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("SynchronizedList size: " + synchronizedList.size() + " (should be 0)");
    }

    private static void testHashSet() throws InterruptedException {
        HashSet<Integer> hashSet = new HashSet<>();
        Thread t1 = new Thread() {
            public void run() {
                System.out.println("HashSet T1 (" + currentThread().getName() + ") start");
                for (int i = 0; i < 20000; ++i)
                    hashSet.add(i);
                System.out.println("HashSet T1 (" + currentThread().getName() + ") finish");
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                System.out.println("HashSet T2 (" + currentThread().getName() + ") start");
                for (int i = 20000; i < 40000; ++i)
                    hashSet.add(i);
                System.out.println("HashSet T2 (" + currentThread().getName() + ") finish");
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Hash set size: " + hashSet.size() + " (should be 40000)");
    }

    private static void testSemaphoreSet() throws InterruptedException {
        SemaphoreSet<Integer> semaphoreSet = new SemaphoreSet<>();
        Thread t1 = new Thread() {
            public void run() {
                System.out.println("SemaphoreSet T1 (" + currentThread().getName() + ") start");
                for (int i = 0; i < 20000; ++i)
                    semaphoreSet.add(i);
                System.out.println("SemaphoreSet T1 (" + currentThread().getName() + ") finish");
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                System.out.println("SemaphoreSet T2 (" + currentThread().getName() + ") start");
                for (int i = 20000; i < 40000; ++i)
                    semaphoreSet.add(i);
                System.out.println("SemaphoreSet T2 (" + currentThread().getName() + ") finish");
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("SemaphoreSet set size: " + semaphoreSet.size() + " (should be 40000)");
    }
}