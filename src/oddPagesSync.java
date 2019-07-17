import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class oddPagesSync extends Thread {

    implementsPrinter printer;
    int maxNumberTobePrint;


    oddPagesSync(implementsPrinter ip, int index) {
        this.printer = ip;
        this.maxNumberTobePrint = index;

    }
    @Override
    public void run() {
        for (int i = 1; i <= maxNumberTobePrint; i = i + 2) {
            try {
                ThreadLocal<Page> TLPageSync = new ThreadLocal<>();
                TLPageSync.set(new Page(i));
                printer.printOddNum(TLPageSync);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
