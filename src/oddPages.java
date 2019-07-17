public class oddPages extends Thread {

    implementsPrinter printer;
    DeadlockPrinter dprinter;
    int maxNumberTobePrint;

    oddPages(implementsPrinter ip, int index) {
        this.printer = ip;
        this.maxNumberTobePrint = index;
    }

    oddPages(DeadlockPrinter ip, int index) {
        this.dprinter = ip;
        this.maxNumberTobePrint = index;
    }

    @Override
    public void run() {
        for (int i = 1; i <= maxNumberTobePrint; i = i + 2) {
            try {
                dprinter.printOddNum(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
