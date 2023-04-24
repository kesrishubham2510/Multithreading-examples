package Example1;

public class NumberPrinter implements Runnable{

    public int number;

    NumberPrinter(int i){
        this.number = i;
    }

    @Override
    public void run() {
        System.out.println("Executing the thread:- "+Thread.currentThread().getName()+" value is:- "+number);   
    }
    
}
