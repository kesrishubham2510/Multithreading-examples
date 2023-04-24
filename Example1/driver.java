package Example1;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class driver {
    
    public static void main(String[] args) {
        
        //  Create the object of HelloWorldPrinter
        HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter();

        // Create a Thread object
        Thread thread = new Thread(helloWorldPrinter);

        // starting the thread
        thread.start();

        // Create object of the NumberPrinter
        int i=1;
        
        // for(;i<=100;i++){
            
        //     // The threads executed but the sequence was altered
        //     NumberPrinter numberPrinter = new NumberPrinter(i);
        //     Thread t2 = new Thread(numberPrinter);
        //     t2.start();
        // }

        // running the Number Printer using Executor framework
        Executor executor =  Executors.newFixedThreadPool(20); 
        i = 1;
        
        for(;i<=100;i++){
            
            // The threads executed but the sequence was altered
            NumberPrinter numberPrinter = new NumberPrinter(i);
            executor.execute(numberPrinter);
        }
    }
}
