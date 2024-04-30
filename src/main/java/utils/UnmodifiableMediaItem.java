package utils;

import excep.MyUnsupportedOperationException;
import imb.MediaItem;

import java.io.OutputStream;
import java.io.Writer;
import java.util.Iterator;

public class UnmodifiableMediaItem implements MediaItem {
    private final MediaItem mediaItem;

    public UnmodifiableMediaItem(MediaItem mediaItem) {
        this.mediaItem = mediaItem;
    }

    @Override
    public String getName() {
        return mediaItem.getName();
    }

    @Override
    public int getTotalDuration() {
        return mediaItem.getTotalDuration();
    }

    @Override
    public int totalMinutesOfAllEpisodes() {
        return mediaItem.totalMinutesOfAllEpisodes();
    }

    @Override
    public void output(OutputStream out) {
        mediaItem.output(out);
    }

    @Override
    public void write(Writer out) {
        throw new MyUnsupportedOperationException("Невозможно изменить неизменяемый элемент библиотеки");
    }

    @Override
    public int getNumberEpisodesInTheMedia() {
        return mediaItem.getNumberEpisodesInTheMedia();
    }

    @Override
    public int getEpisodeFromEpisodes(int index) {
        return mediaItem.getEpisodeFromEpisodes(index);
    }

    @Override
    public void setEpisodeToEpisodes(int index, int value) {
        throw new MyUnsupportedOperationException("Невозможно изменить неизменяемый элемент библиотеки");
    }

    @Override
    public Iterator<Integer> iterator() {
        return mediaItem.iterator();
    }
}
