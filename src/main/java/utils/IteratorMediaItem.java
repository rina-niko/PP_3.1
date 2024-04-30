package utils;

import java.util.Iterator;

public class IteratorMediaItem implements Iterator<Integer> {

    private final int[] episode;
    private int current = 0;

    public IteratorMediaItem(int[] episode) {
        this.episode = episode;
    }

    @Override
    public boolean hasNext() {
        return current < episode.length;
    }

    @Override
    public Integer next() {
        return episode[current++];
    }
}
