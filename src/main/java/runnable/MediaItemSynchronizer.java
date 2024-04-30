package runnable;

import imb.MediaItem;

public class MediaItemSynchronizer {
        private final MediaItem mediaItem;
        private volatile int current = 0;
        private final Object lock = new Object();
        private boolean set = false;

        public MediaItemSynchronizer(MediaItem mediaItem) {
            this.mediaItem = mediaItem;
        }

        public int read() throws InterruptedException {
            int val;
            synchronized (lock) {
                if(!canRead()) throw new InterruptedException();
                while (!set)
                    lock.wait();
                val = mediaItem.getEpisodeFromEpisodes(current);
                System.out.println("Read: " + val + " from position " + current);
                set = false;
                current++;
                lock.notifyAll();

            }
            return val;
        }

        public void write(int val) throws InterruptedException {
            synchronized (lock) {
                if (!canWrite()) throw new InterruptedException();
                while (set)
                    lock.wait();
                mediaItem.setEpisodeToEpisodes(current, val);
                System.out.println("Write: " + val + " to position " + current);
                set = true;

                lock.notifyAll();
            }
        }

        public boolean canRead() {
            return current < mediaItem.getNumberEpisodesInTheMedia();
        }
        public boolean canWrite() {
            return (!set && current < mediaItem.getNumberEpisodesInTheMedia()) || (set && current < mediaItem.getNumberEpisodesInTheMedia()- 1);
        }
    }




