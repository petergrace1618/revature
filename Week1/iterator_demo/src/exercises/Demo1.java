package exercises;

import java.util.*;

public class Demo1 {

    public static void main(String[] args) {
        Map<Integer, String> hm = new HashMap<>();
        hm.put(12, "Jee");
        hm.put(120, "Java");
        hm.put(14, null);
        hm.put(142, "Jee");
        hm.put(122, null);
        hm.put(110, "Jee");
        hm.put(129, "Jee");
        hm.put(212, "Jee");
        hm.put(212, null);
        hm.put(132, "Jee");
        System.out.println("Before deletion");
        System.out.println(hm);

//        for(Map.Entry<Integer, String> e: hm.entrySet()) {
//            if(e.getKey()==null || e.getValue() == null || e.getKey() % 10 == 0) {
//                hm.remove(e.getKey());
//            }
//        }
        Iterator<Map.Entry<Integer, String>> i = hm.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry<Integer, String> e = i.next();
            if(e.getKey()==null || e.getValue() == null || e.getKey() % 10 == 0) {
                i.remove();
            }
        }
        System.out.println("After deletion");
        System.out.println(hm);

        List<Integer> li = Arrays.asList(1,2,3,4,5,67,8,9,90,6,4);
        Iterator<Integer> i2 = li.iterator();
        while(i2.hasNext()) {
            System.out.println(i2.next());
        }
        // Enumerator: read from top to bottom
        // Iterator: read and remove top to bottom
        // ListIterator: applicable only on list interface
        //      can traverse both the side and read, add and remove
    }
}
