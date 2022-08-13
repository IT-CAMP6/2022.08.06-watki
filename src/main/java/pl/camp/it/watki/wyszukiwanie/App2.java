package pl.camp.it.watki.wyszukiwanie;

import java.util.ArrayList;
import java.util.List;

public class App2 {
    public static void main(String[] args) {
        int[] tab = new int[700000000];
        final List<Integer> partialMins = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        final int threadsNumber = 10000;

        long startTime = System.currentTimeMillis();

        for(int i = 0; i < threadsNumber; i++) {
            int startIndex = (int) (((long) i) * ((long) tab.length) / threadsNumber);
            int endIndex = (int) (((long) (i + 1)) * ((long) tab.length) / threadsNumber);
            Thread t = new Thread(new MinFinder(tab, startIndex, endIndex, partialMins));
            t.start();
            threads.add(t);
        }

        try {
            for(Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int min = partialMins.get(0);
        for(int element : partialMins) {
            if(min > element) {
                min = element;
            }
        }

        long endTime = System.currentTimeMillis();

        System.out.println(min);
        System.out.println(endTime - startTime);


    }
}
