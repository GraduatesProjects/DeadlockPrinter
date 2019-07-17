import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class evenPagesSync extends Thread {

    implementsPrinter ip;
    int maxNumberTobePrint;


    evenPagesSync(implementsPrinter ip, int index) {
        this.ip = ip;
        this.maxNumberTobePrint = index;

    }

    @Override
    public void run() {
        for (int i = 2; i <= maxNumberTobePrint; i = i + 2) {
            try {
                ThreadLocal<Page> TLPageS = new ThreadLocal<>();
                TLPageS.set(new Page(i));
                ip.printEvenNumber(TLPageS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
