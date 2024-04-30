package utils;

import imb.Anime;
import imb.MediaDB;
import imb.MediaItem;
import imb.Series;

import java.io.*;
import java.util.List;

public class IOMediaItem {
    public static void outputMediaItem(MediaItem obj, OutputStream out) {
        obj.output(out);
    }

    public static List<MediaItem> inputMediaItem(InputStream in, MediaDB db) {
        MediaItem item = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("; ");
                String className = parts[0];
                String mediaItemName = parts[1];
                int durationIntro = Integer.parseInt(parts[2]);
                int[] durationEpisodes = parseDurationEpisodes(parts[3]);
                // Создаем объект на основе значения первой части строки
                if (className.equals("Series")) {
                    item = new Series(durationEpisodes, mediaItemName, durationIntro);
                } else if (className.equals("Anime")) {
                    item = new Anime(durationEpisodes, mediaItemName, durationIntro);
                }
                db.add(item);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return db.getDb();
    }

    public static void writeMediaItem(MediaItem obj, Writer out) {
        obj.write(out);
    }

    public static MediaItem readMediaItem(Reader in) {
        MediaItem item = null;
        try(BufferedReader reader = new BufferedReader(in)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("; ");
                // Предполагаем, что первый элемент в строке - это имя класса
                String className = "imb." + parts[0];
                String mediaItemName = parts[1];
                int durationIntro = Integer.parseInt(parts[2]);
                int[] durationEpisodes = parseDurationEpisodes(parts[3]);
                // Создаем объект на основе имени класса
                try {
                    Class<?> clazz = Class.forName(className);
                    item = (MediaItem) clazz.newInstance();
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                // Устанавливаем значения полей объекта
                if (item != null) {
                    if (item instanceof Series) {
                        item = new Series(durationEpisodes, mediaItemName, durationIntro);
                    } else if (item instanceof Anime) {
                        item = new Anime(durationEpisodes, mediaItemName, durationIntro);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return item;
    }

    private static int[] parseDurationEpisodes(String episode) {
        String filter = episode.substring(1, episode.length() - 1);
        String[] split = filter.split(", ");
        int[] episodes = new int[split.length];
        for (int i = 0; i < episodes.length; i++) {
            episodes[i] = Integer.parseInt(split[i]);
        }
        return episodes;
    }

}
