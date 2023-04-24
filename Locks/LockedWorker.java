package Locks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.locks.ReentrantLock;

public class LockedWorker implements Runnable {

    public String workerIdentifier;
    public ReentrantLock reentrantLock;

    LockedWorker(String workerIdentifier, ReentrantLock lock){
        this.workerIdentifier = workerIdentifier;
        this.reentrantLock = lock;
    }

    @Override
    public void run() {
        
        boolean persistLoop = true;
       
        // accessing the lock 
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
        while(persistLoop){
            
            boolean lockAcquired = reentrantLock.tryLock();
            
            if(lockAcquired){
                
                try {
                    
                    LocalDate timeStamp = LocalDate.now();

                    System.out.println("The worker "+this.workerIdentifier+" has acquired the thread at "+timeStamp.format(dateTimeFormatter)+" successfully :), Lock count:- "+reentrantLock.getHoldCount());

                    Thread.sleep(1000);

                    // trying to get another lock
                    reentrantLock.lock();

                    try {
                      System.out.println("The worker "+this.workerIdentifier+" has acquired the inner lock at "+LocalDate.now().format(dateTimeFormatter)+" successfully :), Lock count:- "+reentrantLock.getHoldCount()); 
                      Thread.sleep(1500);
                    } catch (Exception e) {
                        System.out.println("The worker "+this.workerIdentifier+" has failed to acquire the inner lock at "+LocalDate.now().format(dateTimeFormatter)+" :(, Lock count:- "+reentrantLock.getHoldCount()); 
                    }finally{
                        //  releasing the inner acquired lock
                        reentrantLock.unlock();
                    }

                    persistLoop = false;

                } catch (Exception e) {
                    System.out.println("The worker "+this.workerIdentifier+" has failed to acquire the lock at "+LocalDate.now().format(dateTimeFormatter)+" :(, Lock count:- "+reentrantLock.getHoldCount()); 
                }finally{
                    reentrantLock.unlock();
                }
                
                System.out.println("The worker "+this.workerIdentifier+" has completed at:- "+LocalDate.now().format(dateTimeFormatter)+" :), Lock count:- "+reentrantLock.getHoldCount()); 



           }else{
              System.out.println("The "+this.workerIdentifier+" is waiting for the lock");
              // putting thread to sleep
              try {
                 Thread.sleep(100);
              } catch (Exception e) {
                System.out.println("Could not put thread to sleep");
              }
           }

        }    

    }
    
}
