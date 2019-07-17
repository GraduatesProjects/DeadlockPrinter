import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

        DeadlockPrinter deadlockPrinter = new DeadlockPrinter();
        implementsPrinter implementsPrinter = new implementsPrinter();

        System.out.println("Printing: \n");

        //Thread T1 = new oddPages(deadlockPrinter, 10);
        //Thread T2 = new evenPages(deadlockPrinter, 10);
        Thread T3 = new oddPagesSync(implementsPrinter, 10);
        Thread T4 = new evenPagesSync(implementsPrinter, 10);
        implementsPrinter = new implementsPrinter();
        Thread T5 = new oddPagesSync(implementsPrinter, 3);
        Thread T6 = new evenPagesSync(implementsPrinter, 3);
        implementsPrinter = new implementsPrinter();
        Thread T8 = new oddPagesSync(implementsPrinter, 10);
        Thread T9 = new evenPagesSync(implementsPrinter, 10);

        T5.start();
        T6.start();
        try {
            T5.join();
            T6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        T3.start();
        T4.start();
        try {
            T3.join();
            T4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        T8.start();
        T9.start();
        //T1.start();
        //T2.start();

    }
}
