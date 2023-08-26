package concurrency.synchronization;

public class Bench {
    private int availableSeats;

    // critical section: a part which we don't want several threads to run at the same time
    public synchronized void takeASeat() throws InterruptedException{
        if (availableSeats > 0) {
            Thread.sleep(100);
            availableSeats--;
            System.out.println("Taking a seat");
            System.out.println("Free seats available: " + availableSeats);
        } else {
            System.out.println("No more free seats. All taken!");
        }
    }

    public Bench(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
