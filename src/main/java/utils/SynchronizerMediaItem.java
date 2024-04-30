package utils;

import imb.MediaItem;

import java.io.OutputStream;
import java.io.Writer;
import java.util.Iterator;

public class SynchronizerMediaItem implements MediaItem {
    private final MediaItem item;
    private final Object lock = new Object();

    public SynchronizerMediaItem(MediaItem item) {
        this.item = item;
    }

    @Override
    public String getName() {
        synchronized (lock) {
            return item.getName();
        }
    }

    @Override
    public int getTotalDuration() {
        synchronized (lock) {
            return item.getTotalDuration();
        }
    }

    @Override
    public int totalMinutesOfAllEpisodes() {
        synchronized (lock) {
            return item.totalMinutesOfAllEpisodes();
        }
    }

    @Override
    public void output(OutputStream out) {
        synchronized (lock) {
            item.output(out);
        }

    }

    @Override
    public void write(Writer out) {
        synchronized (lock) {
            item.write(out);
        }

    }

    @Override
    public int getNumberEpisodesInTheMedia() {
        synchronized (lock) {
            return item.getNumberEpisodesInTheMedia();
        }
    }

    @Override
    public int getEpisodeFromEpisodes(int index) {
        synchronized (lock) {
            return item.getEpisodeFromEpisodes(index);
        }
    }

    @Override
    public void setEpisodeToEpisodes(int index, int value) {
        synchronized (lock) {
            item.setEpisodeToEpisodes(index, value);
        }
    }
    //6
    @Override
    public Iterator<Integer> iterator() {
        synchronized (lock) {
            return item.iterator();
        }
    }
}
