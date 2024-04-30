package imb;

import excep.MyException;
import excep.MyRuntimeException;
import utils.IteratorMediaItem;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class Anime implements MediaItem{
    private int[] durationEpisode;
    private String name;
    private int durationIntro;
    private int totalDuration;


    public Anime() {
    }

    public Anime(int[] durationEpisode, String name, int durationIntro) {
        this.durationEpisode = durationEpisode;
        this.name = name;
        this.durationIntro = durationIntro;
        this.totalDuration = totalMinutesOfAllEpisodes();
    }
    @Override
    public int totalMinutesOfAllEpisodes() {
        int total = 0;
        try {
            for (int episode : this.durationEpisode) {
                if (episode <= 0) {
                    throw new MyRuntimeException("Отрицательный хронометраж серии");
                } else {
                    total += episode;
                }
            }
            return total;
        } catch (MyRuntimeException e) {
            System.err.println("Ошибка: " + e.getMessage());
            return 0;
        }
    }

    public int[] getDurationEpisode() {
        return durationEpisode;
    }
    @Override
    public int getEpisodeFromEpisodes(int index){
        return this.durationEpisode[index];
    }

    public void setDurationEpisode(int[] durationEpisode) {
        this.durationEpisode = durationEpisode;
    }

    @Override
    public void setEpisodeToEpisodes(int index, int value) {
        this.durationEpisode[index] = value;
    }

    public void addEpisodeToEpisodes(int value){
        this.durationEpisode = Arrays.copyOf(this.durationEpisode, this.durationEpisode.length + 1);
        this.durationEpisode[this.durationEpisode.length - 1] = value;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationIntro() {
        return durationIntro;
    }

    public void setDurationIntro(int durationIntro) {
        this.durationIntro = durationIntro;
    }
    @Override
    public int getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(int totalDuration) {
        this.totalDuration = totalDuration;
    }

    @Override
    public String toString() {
        this.totalDuration = totalMinutesOfAllEpisodes(); //5
        return String.format("Аниме - %s, длительность опенинга = %s минуты, общая длительность аниме = %s мин., " +
                        "длительность серий в сезоне = %s; hashcode = %s."
                , name, durationIntro,totalDuration, Arrays.toString(durationEpisode), hashCode());
                }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Anime series = (Anime) obj;
        return durationIntro == series.durationIntro &&
                Arrays.equals(durationEpisode, series.durationEpisode) &&
                Objects.equals(name, series.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, durationIntro);
        result = 31 * result + Arrays.hashCode(durationEpisode);
        return result;
    }
    //4
    @Override
    public void output(OutputStream out) {
    String data = this.toString();
        try {
            out.write(data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //4
    @Override
    public void write(Writer out) {
    String data = this + "\n";
        try {
            out.write(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //5
    @Override
    public int getNumberEpisodesInTheMedia() {
        return this.durationEpisode.length;
    }
    //6
    @Override
    public Iterator<Integer> iterator() {
        return new IteratorMediaItem(durationEpisode);
    }
}
