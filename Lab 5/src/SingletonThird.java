public class SingletonThird {
    private SingletonThird() {}
    public static class SingletonHolder {
        public static final SingletonThird HOLDER_INSTANCE = new SingletonThird();
    }
    public static SingletonThird getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }
}
