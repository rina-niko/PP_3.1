package thread;

import imb.MediaItem;

import java.util.Random;

public class WriterThread extends Thread{
private final MediaItem mediaItem;

    public WriterThread(MediaItem mediaItem) {
        this.mediaItem = mediaItem;
    }
    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < mediaItem.getNumberEpisodesInTheMedia(); i++) {
            int rndDurationEpisode = random.nextInt(99) + 1; // Генерируем случайное число от 1 до 100
            mediaItem.setEpisodeToEpisodes(i, rndDurationEpisode);
            System.out.println("Write: " + rndDurationEpisode + " to position " + i);
        }
    }
}
