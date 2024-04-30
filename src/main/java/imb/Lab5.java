package imb;

import runnable.MediaItemSynchronizer;
import runnable.ReaderRunnable;
import runnable.WriterRunnable;
import thread.ReaderThread;
import thread.WriterThread;
import utils.IOMediaItem;
import utils.UtilsMediaItem;

public class Lab5 {
    public static void main(String[] args) {
        //1 задание
        MediaItem loki = new Series(new int[8], "Локи", 2);
        System.out.println(loki);
        Thread writers = new WriterThread(loki);
        Thread readers = new ReaderThread(loki);
        writers.start();
        try {
            writers.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(loki);
        readers.start();
        try {
            readers.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("-----------");
        Series whoIsIt = new Series(new int[6],"Что если?", 1);
        MediaItem whoIsItSync = UtilsMediaItem.synchronizedMediaItem(whoIsIt);

        MediaItemSynchronizer synchronizer = new MediaItemSynchronizer(whoIsItSync);
        Thread writerThread = new Thread(new WriterRunnable(synchronizer));
        Thread readerThread = new Thread(new ReaderRunnable(synchronizer));
        System.out.println(whoIsIt);
        writerThread.start();
        readerThread.start();
        try {
            writerThread.join();
            readerThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(whoIsIt);
    }
}
