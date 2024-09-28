package org.example;

import java.util.HashMap;
import java.util.Map;

public class ObjectContainer {

    private final Map<String,Object> objectMap = new HashMap<>();

    public void registerObject(String name, Object obj){
        objectMap.put(name, obj);
    }

    public Object get(String key){
        return objectMap.get(key);
    }
}
