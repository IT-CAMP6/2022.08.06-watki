package pl.camp.it.watki.notify;

public class Sender implements Runnable {

    @Override
    public void run() {
        try {
            synchronized (Main.notifyObject) {
                System.out.println("Nadawca coś robi !!!");
                Thread.sleep(1000);
                System.out.println("Nadawca dalej cos robi !!");
                Thread.sleep(1000);
                System.out.println("Nadawca nadal cos robi !!");
                Thread.sleep(1000);
                System.out.println("Nadawca wysyla !!");
                Main.message = "Jakas wiadomosc";
                Main.notifyFlag = true;
                Main.notifyObject.notify();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
