package pl.camp.it.watki.pl;

import java.util.ArrayList;
import java.util.List;

public class App2 {

    static long pointsInCircle = 0;

    static final Object lock = new Object();

    public static void main(String[] args) {
        long allPoints = 21000000000L;
        List<Thread> threads = new ArrayList<>();
        int threadsNumber = 100;

        long startTime = System.currentTimeMillis();
        for(int i = 0; i < threadsNumber; i++) {
            Thread t = new Thread(new PointsGenerator(allPoints / threadsNumber));
            t.start();
            threads.add(t);
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        double PI = (4.0 * (double) pointsInCircle) / (double) allPoints;
        long endTime = System.currentTimeMillis();
        System.out.println(PI);
        System.out.println(endTime - startTime);
    }
}
