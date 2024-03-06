package Proxy;

import java.util.HashMap;

public class Proxy implements Server {
    private RealServer realServer;
    HashMap<String, Integer> cache;

    public Proxy() {
        realServer = new RealServer();
        cache = new HashMap<>();
    }

    @Override
    public Integer request(String str) {
        if (!cache.containsKey(str)) {
            System.out.println("Search in real server");
            cache.put(str, realServer.request(str));
        }
        else {
            System.out.println("Search in cache");
        }
        return cache.get(str);
    }
}
