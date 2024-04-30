package runnable;

public class WriterRunnable implements Runnable{
    private final MediaItemSynchronizer synchronizer;

    public WriterRunnable(MediaItemSynchronizer synchronizer) {
        this.synchronizer = synchronizer;
    }

    @Override
    public void run() {
        try {
            while (synchronizer.canWrite()) {
                synchronizer.write((int) (Math.random() * 99 + 1)); // Записываем случайное значение от 1 до 100
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
