package pl.camp.it.watki.pl;

import java.util.Random;

public class App1 {
    public static void main(String[] args) {
        int allPoints = 2100000000;
        int pointsInCircle = 0;

        long startTime = System.currentTimeMillis();
        Random random = new Random();
        for(int i = 0; i < allPoints; i++) {
            double x = random.nextDouble() * 2 - 1;
            double y = random.nextDouble() * 2 - 1;

            double distanceFormCenter = Math.sqrt(x*x + y*y);

            if(distanceFormCenter <= 1) {
                pointsInCircle++;
            }
        }

        double PI = (4.0 * (double) pointsInCircle) / (double) allPoints;
        long endTime = System.currentTimeMillis();
        System.out.println(PI);
        System.out.println(endTime - startTime);
    }
}
