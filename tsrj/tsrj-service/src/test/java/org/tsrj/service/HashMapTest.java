package org.tsrj.service;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashMapTest extends BaseTestInit {

    public static void main(String[] args){
        Map map = new HashMap<>();
        map.put(null, null);
        Map hashTable = new Hashtable<>();
        hashTable.put(null, null);
    }
}
