package concurrency.synchronization;

public class SyncDemo {
    public static void main(String[] args) {
        Bench bench = new Bench(1);

        Thread player1 = new SeatTakerThread(bench);
        Thread player2 = new SeatTakerThread(bench);

        player1.start();
        player2.start();
    }
}
