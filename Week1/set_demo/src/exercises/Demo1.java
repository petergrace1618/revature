package exercises;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Demo1 {
    public static void main(String[] args) {
        Set<String> hs = new HashSet<>();
        hs.add("hello");
        hs.add("hello");
        hs.add("navigable");
        hs.add("java se");
        hs.add("norvig");
        hs.add(null);
        System.out.println("hs: "+hs);

        Set<String> lhs = new LinkedHashSet<>();
        lhs.add("hello");
        lhs.add("hello");
        lhs.add("navigable");
        lhs.add("java se");
        lhs.add("norvig");
        lhs.add(null);
        System.out.println("lhs: "+lhs);

        Set<String> ts = new TreeSet<>();
        ts.add("hello");
        ts.add("hello");
        ts.add("navigable");
        ts.add("java se");
        ts.add("norvig");
//        ts.add(null);
        System.out.println("ts: "+ts);
    }
}
