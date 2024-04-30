package utils;

import imb.MediaItem;
import imb.MediaItemFactory;
import imb.Series;
import imb.SeriesFactory;

import java.io.*;

public class UtilsMediaItem {
    private static MediaItemFactory factory = new SeriesFactory();

    public static void setMediaItemFactory(MediaItemFactory factory) {
        UtilsMediaItem.factory = factory;
    }

    //сериализация
    public static void serializeMediaItem(MediaItem obj, OutputStream out) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(out)) {
            objectOutputStream.writeObject(obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //десериализация
    public static MediaItem deserializeMediaItem(InputStream in) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(in)) {
            return (MediaItem) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //5
    public static MediaItem synchronizedMediaItem(MediaItem item) {
        return new SynchronizerMediaItem(item);
    }

    //6
    public static MediaItem unmodifiableLibraryItem(MediaItem item) {
        return new UnmodifiableMediaItem(item);
    }
    //6
    public static MediaItem createInstance(){
        return factory.createInstance();
    }
    public static MediaItem createInstance(int[] durationEpisode, String name, int durationIntro){
        return factory.createInstance(durationEpisode, name, durationIntro);
    }

}
