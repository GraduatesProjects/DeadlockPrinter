public class evenPages extends Thread {

    implementsPrinter ip;
    DeadlockPrinter dip;
    int maxNumberTobePrint;

     evenPages(implementsPrinter ip, int index) {
        this.ip = ip;
        this.maxNumberTobePrint = index;
    }

    evenPages(DeadlockPrinter ip, int index) {
        this.dip = ip;
        this.maxNumberTobePrint = index;
    }

    @Override
    public void run() {
        for (int i = 2; i <= maxNumberTobePrint; i = i + 2) {
            try {
                dip.printEvenNumber(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
