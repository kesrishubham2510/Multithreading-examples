package Example2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class driver {
   public static void main(String[] args) throws InterruptedException, ExecutionException {
    
       RandomNumberGenerator g2 = new RandomNumberGenerator();
       RandomNumberGenerator g1 = new RandomNumberGenerator();

       ExecutorService executor =  Executors.newFixedThreadPool(4);

       Future<Integer> i = executor.submit(g1);
    //    line no. 18 will be blocked, until line 16 is executed
       Future<Integer> j = executor.submit(g2);

       // Line 21 will not be executed until both the futures will be completed because the get    
    //    method is blocking and will demand for the 

       System.out.println(i.get()+" "+j.get());
   }   
}
