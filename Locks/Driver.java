package Locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Driver {
   public static void main(String[] args) {
      
       ReentrantLock lock = new ReentrantLock();
       
       LockedWorker l1 = new LockedWorker("Worker-1", lock);
       LockedWorker l2 = new LockedWorker("Worker-2", lock);
       LockedWorker l3 = new LockedWorker("Worker-3", lock);
       LockedWorker l4 = new LockedWorker("Worker-4", lock);

       ExecutorService threadExecutorService = Executors.newFixedThreadPool(2);
    //    threadExecutorService.execute(l1);
    //    threadExecutorService.execute(l2);
    //    threadExecutorService.execute(l3);
    //    threadExecutorService.execute(l4);
    
       threadExecutorService.submit(l1);
       threadExecutorService.submit(l2);
       threadExecutorService.submit(l3);
       threadExecutorService.submit(l4);



       threadExecutorService.shutdown();

   }   
}
