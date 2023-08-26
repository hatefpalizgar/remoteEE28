package concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/*

Once upon a time, there were two friends, Jack and Jill, who loved to play games together. One day, they decided to play a game of tag in the park.

As they were running around, they came across a shiny red ball. They both wanted to play with the ball, but they knew that they couldn't play with it at the same time. So they came up with a plan: they would take turns playing with the ball.

Jack and Jill decided to use an atomic variable to keep track of whose turn it was to play with the ball. They called it the "turn" variable. They both knew that the "turn" variable could only be changed by one person at a time, so they wouldn't accidentally change it at the same time.

Jack and Jill played their game for hours, taking turns with the ball and keeping track of whose turn it was using the "turn" variable.

*/
public class Main {

    // Non-atomic count
    // Because the count variable is not atomic,
    // it is possible for the threads to interfere with each other and produce an incorrect result
    private static int count = 0;

    // Atomic count
    private static AtomicInteger atomicCount = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<1000; i++){
                    count++;
                    atomicCount.incrementAndGet();
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<1000; i++){
                    count++;
                    atomicCount.incrementAndGet();
                }
            }
        });


        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count: " + count);
        System.out.println("Final atomicCount: " + atomicCount);

    }
}
