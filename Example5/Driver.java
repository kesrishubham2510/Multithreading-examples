package Example5;

import java.util.concurrent.locks.ReentrantLock;

public class Driver {
    
    public static void main(String[] args) throws InterruptedException {
        
        ReentrantLock lock = new ReentrantLock();
        EvenOddClass evenOdd = new EvenOddClass();

        ThreadHandler threadHandler1 = new ThreadHandler(lock,evenOdd);

        Thread t1 = new Thread(threadHandler1,"odd Thread"); 
        Thread t2 = new Thread(threadHandler1,"even thread");

        t1.start();
        t2.start();
    }
}
