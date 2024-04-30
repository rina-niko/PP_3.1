package runnable;

public class ReaderRunnable implements Runnable{

    private final MediaItemSynchronizer synchronizer;

    public ReaderRunnable(MediaItemSynchronizer synchronizer) {
        this.synchronizer = synchronizer;
    }

    @Override
    public void run() {
        try {
            while (synchronizer.canRead()) {
                synchronizer.read();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
