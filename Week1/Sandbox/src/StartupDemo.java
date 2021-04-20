public class StartupDemo {
    static {
        System.out.println("In static block");
    }

    {
        System.out.println("In anonymous block");
    }

    public static void main(String[] args) {
        System.out.println("In main");
        System.out.println("Creating object 1");
        StartupDemo o1 = new StartupDemo("object 1");
        System.out.println("Creating object 2");
        StartupDemo o2 = new StartupDemo("object 2");
    }

    public StartupDemo(String msg) {
        System.out.println("In "+msg+" constructor");
    }
}
