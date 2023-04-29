package com.meteor.libs.subscriber;

import java.util.HashMap;
import java.util.Map;

public class DomainEventMap {
    private static Map<String, IEventHandler> map = new HashMap<>();
    public static void add(String key, IEventHandler handler) {
        map.put(key, handler);
    }

    public static IEventHandler get(String key) {
        System.out.println("Coming in");
        map.forEach((k, v) -> {
            System.out.println("key: " + k + ", value: " + v);
        });
        return map.get(key);
    }
}
