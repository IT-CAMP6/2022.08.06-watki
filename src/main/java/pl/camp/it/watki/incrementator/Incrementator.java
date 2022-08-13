package pl.camp.it.watki.incrementator;

public class Incrementator implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i <1000; i++) {
            System.out.println(i);
            Main.incrementator.increment();
        }
    }

    private synchronized void increment() {
        Main.counter++;
    }
}
