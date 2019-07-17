import java.util.concurrent.Semaphore;

public class DeadlockPrinter {

    boolean evenFlag = false;

    // creating instance of 2 semaphores , one is for even and another for odd
    Semaphore devenSemaphore = new Semaphore(1);
    Semaphore doddSemaphore = new Semaphore(3);
    /**
     * Method for printing even numbers
     *
     * @param num
     */
    public void printEvenNumber(int num) throws InterruptedException {
        devenSemaphore.release();
        System.out.println(num);
        doddSemaphore.acquire();
    }

    // Method for printing odd numbers
    public void printOddNum(int num) throws InterruptedException {
        doddSemaphore.acquire();
        System.out.println(num);
        devenSemaphore.release();
    }
}
