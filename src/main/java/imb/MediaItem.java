package imb;

import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;

public interface MediaItem extends Serializable, Iterable<Integer>{

    public String getName();

    public int getTotalDuration();

    //Метод для возвращения общей длительности всех эпизодов в сериале(сезоне)
    public int totalMinutesOfAllEpisodes();

    // Метод для возвращения строкового представления медиа-элемента
    public String toString();

    // Метод для определения, равны ли два медиа-элемента
    public boolean equals(Object o);

    // Метод для возвращения хеш-кода медиа-элемента
    public int hashCode();
    //записи в байтовый поток
    public void output(OutputStream out);
    //записи в символьный поток
    public void write(Writer out);
    //5
    public int getNumberEpisodesInTheMedia();
    //5
    public int getEpisodeFromEpisodes(int index);
    //5
    public void setEpisodeToEpisodes(int index, int value);

}
