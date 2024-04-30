package thread;

import imb.MediaItem;

public class ReaderThread extends Thread{
    private final MediaItem mediaItem;

    public ReaderThread(MediaItem mediaItem) {
        this.mediaItem = mediaItem;
    }
    @Override
    public void run() {
        for (int i = 0; i < mediaItem.getNumberEpisodesInTheMedia(); i++) {
            int theTimeThisEpisode = mediaItem.getEpisodeFromEpisodes(i);
            System.out.println("Read: " + theTimeThisEpisode + " from position " + i);
        }
    }
}
