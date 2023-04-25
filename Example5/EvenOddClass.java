package Example5;

import java.util.concurrent.locks.ReentrantLock;

public class EvenOddClass {
    
    int counter;
    final int limit = 5;

    EvenOddClass(){
        this.counter = 0;
    }

    public void printEvenNumber(){
         System.out.println("Even Accessed by Thread:- "+Thread.currentThread().getName()+" i:- "+this.counter);
        }
        
    public void printOddNumber(){
        System.out.println("Odd Accessed by Thread:- "+Thread.currentThread().getName()+" i:- "+this.counter);    
    }

    public boolean increment(){
      
    synchronized(this){
        if(counter==limit)
           return false;
            counter++;
            
            if(counter%2==0)
             printEvenNumber();
            else
             printOddNumber();
        }
        
        return true;
      }
}

