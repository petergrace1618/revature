package exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        // create list with any type of elements
        List l = new LinkedList();
        l.add("hello");
        l.add(123);
        System.out.println("l: "+l);

        List<Integer> li = new ArrayList<>();
        li.add(10);
        li.add(20);
        System.out.println("li: "+li);
        li.add(1,15);
        System.out.println("li: "+li);

        Collections.reverse(li);
        System.out.println("li: "+li);
    }
}
