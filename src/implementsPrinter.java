import java.util.concurrent.Semaphore;

public class implementsPrinter {

    boolean evenFlag = false;

    // creating instance of 2 semaphores , one is for even and another for odd
    Semaphore evenSemaphore = new Semaphore(0);
    Semaphore oddSemaphore = new Semaphore(1);

    /**
     * Method for printing even numbers
     *
     * @param num
     */
    public void printEvenNumber(int num) {
        try {
            evenSemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(num);
        oddSemaphore.release();
    }

    // Method for printing odd numbers
    public void printOddNum(int num) {
        try {
            oddSemaphore.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(num);
        evenSemaphore.release();
    }
}
