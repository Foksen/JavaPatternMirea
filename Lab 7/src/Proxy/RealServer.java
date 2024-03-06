package Proxy;

public class RealServer implements Server {
    @Override
    public Integer request(String str) {
        return str.hashCode();
    }
}
