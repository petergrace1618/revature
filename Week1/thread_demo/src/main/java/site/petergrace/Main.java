package site.petergrace;

public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        Thread.currentThread().setName("Main thread");

        System.out.println(Thread.currentThread());

        MyThread t1 = new MyThread("new thread 1");
//        t1.setName("new thread 1");
        MyThread t2 = new MyThread("new thread 2");
//        t1.setName("new thread 2");
        MyThread t3 = new MyThread("new thread 3");
//        t1.setName("new thread 3");
        MyThread t4 = new MyThread("new thread 4");
//        t1.setName("new thread 4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main ends here");
    }
}
