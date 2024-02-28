public class SingletonFirst {
    private static SingletonFirst instance;
    public synchronized static SingletonFirst getInstance() {
        if (instance == null) {
            instance = new SingletonFirst();
        }
        return instance;
    }
}
