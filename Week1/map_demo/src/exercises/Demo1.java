package exercises;

import java.util.*;

public class Demo1 {
    public static void main(String[] args) {
        Map<Integer, String> hm = new HashMap<>();
        hm.put(100, "Jane");
        hm.put(100, "Jane updated");
        hm.put(null, "Unknown");
        hm.put(3900, "jay");
        hm.put(1900, "jay");
        hm.put(390, null);
        hm.put(900, null);
        hm.put(2900, "dinesh");
        hm.put(5900, "dan");
        System.out.println("hm: "+hm);

        Map<Integer, String> lhm = new LinkedHashMap<>();
        lhm.put(100, "Jane");
        lhm.put(100, "Jane updated");
        lhm.put(null, "Unknown");
        lhm.put(3900, "jay");
        lhm.put(1900, "jay");
        lhm.put(390, null);
        lhm.put(900, null);
        lhm.put(2900, "dinesh");
        lhm.put(5900, "dan");
        System.out.println("lhm: "+lhm);

        Map<Integer, String> tm = new TreeMap<>();
        tm.put(100, "Jane");
        tm.put(100, "Jane updated");
//        tm.put(null, "Unknown");
        tm.put(3900, "jay");
        tm.put(1900, "jay");
        tm.put(390, null);
        tm.put(900, null);
        tm.put(2900, "dinesh");
        tm.put(5900, "dan");
        System.out.println("tm: "+tm);

        Map<Integer, String> ht = new Hashtable<>();
        ht.put(100, "Jane");
        ht.put(100, "Jane updated");
//        ht.put(null, "Unknown");
        ht.put(3900, "jay");
        ht.put(1900, "jay");
//        ht.put(390, null);
//        ht.put(900, null);
        ht.put(2900, "dinesh");
        ht.put(5900, "dan");
        System.out.println("ht: "+ht);

        System.out.println("ht.size: "+ht.size());
        System.out.println(ht.get(1000));
        System.out.println(ht.containsKey(1900));

        Set<Integer> set = ht.keySet();
        System.out.println("Traversing keyset");
        for (Integer i: set) {
            System.out.println("key: "+i+", value: "+ht.get(i));
        }

        System.out.println("Traversing entrySet");
        for(Map.Entry<Integer, String> e: ht.entrySet()) {
            System.out.println("key: "+e.getKey()+", value: "+e.getValue());
        }
    }
}
