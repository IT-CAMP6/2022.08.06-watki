package pl.camp.it.watki.wyszukiwanie;

import java.util.List;
import java.util.Random;

public class MinFinder implements Runnable {

    private final int[] tab;
    private final int startIndex;
    private final int endIndex;
    private final List<Integer> resultList;

    public MinFinder(int[] tab, int startIndex, int endIndex, List<Integer> resultList) {
        this.tab = tab;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.resultList = resultList;
    }

    @Override
    public void run() {
        Random random = new Random();
        for(int i = this.startIndex; i < this.endIndex; i++) {
            tab[i] = random.nextInt(1000000000);
        }

        int min = tab[this.startIndex];

        for(int i = this.startIndex + 1; i < this.endIndex; i++) {
            if(tab[i] < min) {
                min = tab[i];
            }
        }

        synchronized (resultList) {
            this.resultList.add(min);
        }
    }
}
