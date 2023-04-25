package Example5;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadHandler implements Runnable {

    EvenOddClass evenOddClass;
    ReentrantLock lock;

    public ThreadHandler(ReentrantLock lock, EvenOddClass evenOddClass) {
        this.evenOddClass = evenOddClass;
        this.lock = lock;
    }

    @Override
    public void run() {
        
        boolean validCounter = evenOddClass.increment();

        while(validCounter){
            validCounter = evenOddClass.increment();
        }

    }
}
