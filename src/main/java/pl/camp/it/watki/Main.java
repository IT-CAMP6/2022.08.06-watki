package pl.camp.it.watki;

public class Main {
    public static void main(String[] args) {
        /*Watek watek1 = new Watek(1);
        Watek watek2 = new Watek(2);
        Watek watek3 = new Watek(3);
        Watek watek4 = new Watek(4);

        watek1.start();
        watek2.start();
        watek3.start();
        watek4.start();*/

        Thread t1 = new Thread(new LepszyWatek());

        t1.start();

        System.out.println("komunikat !!!");
    }
}
