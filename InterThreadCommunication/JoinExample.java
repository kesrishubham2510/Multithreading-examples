package InterThreadCommunication;

public class JoinExample implements Runnable {
    public void run() {
        System.out.println("Child thread is running");
        for (int i = 1; i <= 4; i++) {
            System.out.println("I: " + i);
            try {
                Thread.sleep(2000); // Pauses the execution of child thread for 2 sec.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Child thread is ending");
    }

    public static void main(String[] args) {
        JoinExample x = new JoinExample();
        Thread t = new Thread(x);
        Thread t2 = new Thread(x);
        t.start(); // thread t is ready to run.
        t2.start();
        // join() method is called inside the main thread (current thread) through
        // Thread t.
        try {
            t.join(); // Wait for thread t to end till 1 sec.
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        
        System.out.println("Main Thread is ending");
    }
}