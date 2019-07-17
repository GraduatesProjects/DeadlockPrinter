import java.util.concurrent.Semaphore;

public class implementsPrinter {

    boolean evenFlag = false;

    // creating instance of 2 semaphores , one is for even and another for odd
    Semaphore evenSemaphore = new Semaphore(0);
    Semaphore oddSemaphore = new Semaphore(1);

    /**
     * Method for printing even numbers
     * this is synced
     *
     *
     */

    public void printEvenNumber(ThreadLocal<Page>page) throws InterruptedException {

        evenSemaphore.acquire();
            System.out.println(page.get().toString());
        oddSemaphore.release();
    }

    // Method for printing odd numbers
    public void printOddNum(ThreadLocal<Page> page)throws InterruptedException {

        oddSemaphore.acquire();
            System.out.println(page.get().toString());
        evenSemaphore.release();
    }

}
