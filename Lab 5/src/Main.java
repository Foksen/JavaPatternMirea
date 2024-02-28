public class Main {
    public static void main(String[] args) {
        SingletonFirst singletonFirst = SingletonFirst.getInstance();
        SingletonSecond singletonSecond = SingletonSecond.INSTANCE.getInstance();
        SingletonThird singletonThird = SingletonThird.getInstance();
    }
}