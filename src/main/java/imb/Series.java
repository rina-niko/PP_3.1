package imb;

import excep.MyRuntimeException;
import utils.IteratorMediaItem;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class Series implements MediaItem {
    private int[] durationEpisode; //Длительность каждого эпизода
    private String name;
    private int durationIntro; //Длительность заставки
    private int totalDuration; //Общая длительность сериала

    public Series() {
    }

    public Series(int[] durationEpisode, String name, int durationIntro) {
        this.durationEpisode = durationEpisode;
        this.name = name;
        this.durationIntro = durationIntro;
        this.totalDuration = totalMinutesOfAllEpisodes();
    }

    @Override
    public int totalMinutesOfAllEpisodes() {  //Функциональный метод по нахождению общего хронометража
        int total = 0;  // Переменная для хранения общей длительности всех эпизодов
        try {  // Начало блока try для обработки возможных исключений
            for (int episode : this.durationEpisode) {  // Итерация по массиву durationEpisode
                if (episode <= 0) {  // Проверка длительности эпизода на отриц. знач. или 0
                    throw new MyRuntimeException("Отрицательный хронометраж серии");  // Генерация исключения, если длительность отриц. или = 0
                } else {
                    total += episode;  // Добавление длительности эпизода к общей длительности, если она положительная
                }
            }
            return total;  // Возврат общей длительности всех эпизодов в случае успешного выполнения цикла
        } catch (MyRuntimeException e) {  // Обработка исключения типа MyRuntimeException
            System.err.println("Ошибка: " + e.getMessage());  // Вывод сообщения об ошибке в случае возникновения исключения
            return 0;  // Возврат нуля в случае возникновения исключения, обозначая ошибку в вычислении общей длительности
        }
    }

    public int[] getDurationEpisode() {
        return durationEpisode;
    }
    @Override
    public int getEpisodeFromEpisodes(int index) {
        return this.durationEpisode[index];
    }

    public void setDurationEpisode(int[] durationEpisode) {
        this.durationEpisode = durationEpisode;
    }
    @Override
    public void setEpisodeToEpisodes(int index, int value) {
        this.durationEpisode[index] = value;
    }


    public void addEpisodeToEpisodes(int value) {
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
        return String.format("Сериал - %s, длительность заставки = %s минуты, общая длительность сериала = %s мин., " +
                        "длительность серий в сезоне = %s; hashcode = %s."
                , name, durationIntro, totalDuration, Arrays.toString(durationEpisode), hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Series series = (Series) obj;
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
