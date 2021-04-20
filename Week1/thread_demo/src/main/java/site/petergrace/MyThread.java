package site.petergrace;

public class MyThread extends Thread {
    public MyThread(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        System.out.println("Hello from "+Thread.currentThread());
        for(int i=0; i<5; i++) {
            System.out.println("In "+Thread.currentThread().getName()+" "+i);
        }
    }
}
