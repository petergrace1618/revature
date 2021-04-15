package pkg1;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello Java");
        helloStatic();
        Helloworld helloworld = new Helloworld();
        helloworld.nonStaticHello();

        Integer i = 0;
        System.out.println(System.identityHashCode(i));
        int j = 1;
        i = j;
        System.out.println(System.identityHashCode(i));

    }

    public static void helloStatic() {
        System.out.println("Hello from helloStatic()");
    }

    public void nonStaticHello() {
        System.out.println("Hello from nonStaticHello()");
    }
}
