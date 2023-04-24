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
public class SynchronizedMethod {

    public static void main(String[] args) {
        
     /*
          Dummy dummy = new Dummy();

          Thread t1 = new Thread(dummy, "First thread");
          Thread t2 = new Thread(dummy, "Second Thread");

          t1.start();
          t2.start();
     */

       /*
          Using static synchronization,

          * d1 and d2 are different objects hence at object level threads will be synchronised
          * using static or class level synchronization, all threads will be synchronized
       */
      

       Dummy d1 = new Dummy();
       Dummy d2 = new Dummy();

       Thread t1 = new Thread(d1, "First Thread");
       Thread t2 = new Thread(d1,"Second Thread");
       Thread t3 = new Thread(d2,"Third Thread");
       Thread t4 = new Thread(d2,"Fourth Thread");

       t1.start();
       t2.start();
       t3.start();
       t4.start();

    }
    
}
