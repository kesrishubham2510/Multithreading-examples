package Example1;

public class HelloWorldPrinter implements Runnable{

    @Override
    public void run() {
         System.out.println("Executing the thread:- "+Thread.currentThread().getName());
         System.out.println("This is first hands on multi-threading");   
    }
    
}
