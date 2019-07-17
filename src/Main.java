public class Main {

    public static void main(String[] args) {

        DeadlockPrinter printer = new DeadlockPrinter();

        System.out.println("Printing: \n");

        Thread T1 = new oddPages(printer, 10);
        Thread T2 = new evenPages(printer, 10);
        Thread T3 = new oddPages(printer, 10);
        Thread T4 = new evenPages(printer, 10);

        T1.start();
        T2.start();
        T3.start();
        T4.start();

    }
}
