package Synchronised;

/*
    * When we have multiple threads accessing the same resource concurrently,
      there is a chance that the threads will be updating the resource concurrently,
      this may lead to inconsistency in result.
    
    * Scenario:- Suppose one thread is updating the resource and context switch happens
      now, the second thread reads the data and perform some operations and gets
      completed. Now, context switch will happen again and the first thread will start 
      execution from where it had left, it now updates the resource and gets completed.
      Now because the second thread read intermediate-state data from the shared resource 
      the produced result would be different than expected.

    * To tackle above issue, we need to have synchronization of resources between threads in
      a mutli-threaded environment.
    
    * Synchronization is acheived using 'synchronized' keyword in java
    
*/

public class Dummy implements Runnable{

    /*
       * In case where we need synchronization at the class level, i.e, synchronization between all
         the object of a class, then we can leverage static synchronization
     
    */

    public synchronized static void staticSyncronizedMethod(){
         for(int i=0;i<5;i++){
            System.out.println("Thread under execution is:- "+Thread.currentThread().getName()+", value:- "+i);

            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println("Exception occured while putting "+Thread.currentThread().getName()+" to sleep");
            }
         }
    }

    /*
       * when this method is first called by a thread (either t1 or t2), that thread acquires a lock
         on this method and keeps it until the function (a critical section) is completely executed by
         the thread.
       
       * The other thread is denied access to the method because the lock is acquired by the first thread
       
       * Thus this method produces a result in which threads print their information 5 times then
         other thread starts
    */
    public synchronized void printDetails_Synchronized(){
       doSomething();
    }

     /*
       * when this method is first called by a thread (either t1 or t2), it starts execution and after the context
         switch other threads starts or resumes (if it had made some progress during previous execution) execution.

       * Thus this method produces a result in which threads print their information in inter-leaved fashion.
    */
    public void printDetails(){
       doSomething();
    }

    @Override
    public void run(){
        // printDetails();
        // printDetails_Synchronized();  
        // doSomething_SynchronisedBlock();
        // Dummy.staticSyncronizedMethod();
    }

    private void doSomething(){
        for(int i=0;i<=4;i++){
            System.out.println("Thread under execution is:- "+Thread.currentThread().getName()+", value:- "+i);

            try {
                 Thread.sleep(400);
                }catch(Exception e){
                            System.out.println("Exception occured while putting "+Thread.currentThread().getName()+" to sleep");
            }
        } 
    }

    /*
        * The method produces a result in which threads print their information 5 times then
         other thread starts.
    */
    private void doSomething_SynchronisedBlock(){
        synchronized(this){
            doSomething();
        }
    }
}
