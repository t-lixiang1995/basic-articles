package ai.pcitc.lock;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
public class LockApplication {

    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("test",new Movie());
        System.out.println(concurrentHashMap.get("test"));
        System.out.println(concurrentHashMap.get("test"));
    }
}
