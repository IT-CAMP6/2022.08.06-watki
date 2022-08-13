package pl.camp.it.watki.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        /*ExecutorService singleExecutor = Executors.newSingleThreadExecutor();

        singleExecutor.submit(new Watek());
        singleExecutor.submit(new Watek());
        singleExecutor.submit(new Watek());*/

        /*ExecutorService multiExecutor = Executors.newFixedThreadPool(3);

        multiExecutor.submit(new Watek());
        multiExecutor.submit(new Watek());
        multiExecutor.submit(new Watek());
        multiExecutor.submit(new Watek());
        multiExecutor.submit(new Watek());

        multiExecutor.shutdown();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        multiExecutor.submit(new Watek());*/

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

        scheduledExecutorService.schedule(new Watek(), 0, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(new Watek(), 5, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(new Watek(), 2, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(new Watek(), 7, TimeUnit.SECONDS);

        scheduledExecutorService.shutdown();
    }
}
