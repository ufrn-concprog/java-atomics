import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        Runnable increment = () -> {
            for (int i = 1; i <= 1000; i++) {
                counter.incrementAndGet();
            }
        };

        Thread t1 = new Thread(increment);
        Thread t2 = new Thread(increment);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final value of counter: " + counter);
    }
}