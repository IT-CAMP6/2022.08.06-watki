package pl.camp.it.watki.incrementator;

public class IncrementatorSynchronizedClass {
    public synchronized void increment() {
        Main.counter++;
    }
}
