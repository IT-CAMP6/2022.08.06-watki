package pl.camp.it.watki.notify;

public class Receiver implements Runnable {

    @Override
    public void run() {
        try {
            synchronized (Main.notifyObject) {
                System.out.println("Odbiorca odpalony !!");
                System.out.println("Odbiorca czeka !!");

                while (!Main.notifyFlag) {
                    Main.notifyObject.wait();
                }

                System.out.println("Odbiorca odebral sygnal !!");
                System.out.println("Wiadomosc: " + Main.message);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
