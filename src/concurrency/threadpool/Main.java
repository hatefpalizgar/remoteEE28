package concurrency.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
    A thread pool is a collection of worker threads that are used to execute tasks.
    Instead of creating a new thread for each task, a thread from the pool is used to execute the task,
    and then returned to the pool when the task is complete.

    Using thread pools can have several benefits, including:
    - Improved performance: Creating a new thread is an expensive operation, as it involves allocating memory and other resources.
    By reusing existing threads from a pool, you can reduce the overhead of creating new threads and improve the overall performance of your application

    - Simplified thread management: Thread pools provide a way to manage and control the number of threads in your application,
    allowing you to adjust the size of the pool based on the workload.

    - Improved resource utilization: By using a thread pool, you can ensure that the number of active threads
    does not exceed the capacity of your system, allowing you to make better use of available resources

*/
public class Main {
    public static void main(String[] args) {
        // Java provides the Executor interface and the ExecutorService interface,
        // which define a thread pool and provide methods for managing and executing tasks
        // create a fixed-size thread pool with 5 threads
        // (better performance for longer-lived tasks)
        // (NO thread reuse)
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // creates a new thread pool that creates new threads as needed,
        // but reuses previously created threads when they are available.
        // The thread pool has an unbounded number of threads
        // (better performance for short-lived tasks)
        // (Thread reuse)
        ExecutorService executorCached = Executors.newCachedThreadPool();

        // submit a task for execution
        executor.submit(new Runnable() {
            @Override
            public void run() {
                // code to be executed by a thread from the pool
                System.out.println("Hello from a thread! Thread name: " + Thread.currentThread().getName());
            }
        });

        // shut down the executor to prevent any new task from being submitted
        executor.shutdown();
    }

        /*
        Here are some best practices when using thread pools in Java:
         - Use a fixed-size thread pool: A fixed-size thread pool is a thread pool with a fixed number of threads.
         This can be useful if you have a limited number of resources and want to ensure that the number of active threads does not exceed a certain threshold
         - Size the thread pool appropriately: It is important to size the thread pool appropriately based on the workload and the number of available resources.
         If the thread pool is too small, tasks may be executed serially, which can degrade performance.
         If the thread pool is too large, it can waste resources and lead to resource contention
         - Use an appropriate Executor implementation: Java provides several implementations of the Executor interface,
         including Executors.newFixedThreadPool(), Executors.newSingleThreadExecutor(), and Executors.newCachedThreadPool().
         - Avoid creating new threads unnecessarily
         - Shut down the thread pool when you are finished
         - Don't create a thread pool with an unbounded number of threads
         - Don't submit tasks to a shutdown thread pool: If you try to submit a task to a thread pool that has been shut down, it will throw a RejectedExecutionException.
          Be sure to check whether the thread pool is shutdown before submitting tasks.
     */
}
