package com.problem1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by sowmyaparameshwara on 9/2/18.
 */
public class ImportantJava {

    public static void main(String[] args) {
        ImportantJava java = new ImportantJava();
        java.iterateMap();
    }

    private void iterateMap() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        for( Map.Entry<String, Integer> entry: map.entrySet()){
            System.out.println("Key: "+entry.getKey());
            System.out.println("Key: "+entry.getValue());
        }
        //Using Iterator
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> it = entrySet.iterator();
        while(it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            System.out.println("Key :"+entry.getKey()+" Value: "+entry.getValue());
        }


    }

}
