import java.util.concurrent.Semaphore;

public class DeadlockPrinter {

    boolean evenFlag = false;

    // creating instance of 2 semaphores , one is for even and another for odd
    Semaphore devenSemaphore = new Semaphore(1);
    Semaphore doddSemaphore = new Semaphore(2);
    /**
     * Method for printing even numbers
     *
     *
     */
    public void printEvenNumber(ThreadLocal<Page> page) throws InterruptedException {
        devenSemaphore.release();
        //System.out.println();
        System.out.println(page.get().toString());
        doddSemaphore.acquire();
    }

    // Method for printing odd numbers
    public void printOddNum(ThreadLocal<Page>page) throws InterruptedException {
        doddSemaphore.acquire();
        System.out.println(page.get().toString());
        devenSemaphore.release();
    }
}
