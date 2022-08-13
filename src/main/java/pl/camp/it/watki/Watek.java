package pl.camp.it.watki;

public class Watek extends Thread {

    int threadNumber;

    public Watek(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            System.out.println("watek: " + this.threadNumber + " i:" + i);
        }
    }
}
