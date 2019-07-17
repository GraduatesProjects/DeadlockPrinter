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
                ThreadLocal<Page> TLPage = new ThreadLocal<>();
                TLPage.set(new Page(i));
                dip.printEvenNumber(TLPage);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
