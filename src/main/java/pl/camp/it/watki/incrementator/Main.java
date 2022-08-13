package pl.camp.it.watki.incrementator;

public class Main {
    public static int counter = 0;
    public static final Object lock = new Object();
    public static IncrementatorSynchronizedClass incrementator = new IncrementatorSynchronizedClass();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Incrementator());
        Thread t2 = new Thread(new Incrementator());
        Thread t3 = new Thread(new Incrementator());
        Thread t4 = new Thread(new Incrementator());

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
            throw new RuntimeException(e);
        }

        System.out.println(Main.counter);
    }
}
