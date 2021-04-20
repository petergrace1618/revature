package real_objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo2 {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1,"widget", 2.5, 4.5f, 1000));
        productList.add(new Product(2,"widget", 4.5, 2.5f, 1000));
        productList.add(new Product(3,"widget", 3.5, 3.5f, 1000));
        productList.add(new Product(4,"widget", 5.5, 5.5f, 1000));
        productList.add(new Product(5,"widget", 2.5, 1.5f, 1000));
        productList.add(new Product(6,"widget", 6.5, 0.5f, 1000));

        System.out.println("All products: ");
        printProductList(productList);

        System.out.println("All products by id: ");
        printProductList(productList);

        Collections.sort(productList, (p1, p2)->{
            Float f1 = p1.getRating();
            Float f2 = p2.getRating();
            return f2.compareTo(f1);
        });
        System.out.println("Sorted by rating:");
        printProductList(productList);

        Collections.sort(productList, (p1, p2)->{
            Double d1 = p1.getCost();
            Double d2 = p2.getCost();
            int x = d1.compareTo(d2);
            if (x==0) {
                Float f1 = p1.getRating();
                Float f2 = p2.getRating();
                x = f2.compareTo(f1);
            }
            return x;
        });
        System.out.println("Sorted by rating:");
        printProductList(productList);
    }

    public static void printProductList(List<Product> productList) {
        for (Product p: productList) {
            System.out.println(p);
        }
    }
}
