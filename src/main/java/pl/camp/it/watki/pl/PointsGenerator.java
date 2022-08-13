package pl.camp.it.watki.pl;

import java.util.Random;

public class PointsGenerator implements Runnable {

    long pointsToGenerate;

    public PointsGenerator(long pointsToGenerate) {
        this.pointsToGenerate = pointsToGenerate;
    }

    @Override
    public void run() {
        Random random = new Random();
        long pointsInCircle = 0;
        for(long i = 0; i < pointsToGenerate; i++) {
            double x = random.nextDouble() * 2 - 1;
            double y = random.nextDouble() * 2 - 1;

            double distanceFormCenter = Math.sqrt(x*x + y*y);

            if(distanceFormCenter <= 1) {
                pointsInCircle++;
            }
        }

        synchronized (App2.lock) {
            App2.pointsInCircle = App2.pointsInCircle + pointsInCircle;
        }
    }
}
