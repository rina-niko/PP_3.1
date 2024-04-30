package imb;

import excep.MyUnsupportedOperationException;
import utils.IOMediaItem;
import utils.UtilsMediaItem;

public class Lab6 {
    public static void main(String[] args) {
        //2 задание
        MediaItem loki = new Series(new int[]{20, 40, 48, 60}, "Локи", 2);
        System.out.println(loki);
        for (int durationEpisode : loki) {
            System.out.println(durationEpisode);
        }
        System.out.println("------------------");
        //3 задание
        MediaItem mutableItem = new Series(new int[]{100, 150, 210}, "House M.D.", 10);
        MediaItem unmodifiableItem = UtilsMediaItem.unmodifiableLibraryItem(mutableItem);

// Эта операция будет успешной.
        System.out.println("Общая длительность сериала: " + unmodifiableItem.getTotalDuration());

// Эта операция бросит исключение UnsupportedOperationException.
        try {
            unmodifiableItem.setEpisodeToEpisodes(2, 30);
        } catch (MyUnsupportedOperationException e) {
            System.err.println("Ошибка: " + e.getMessage());  // Вывод сообщения об ошибке в случае возникновения исключения

        }
        System.out.println(mutableItem);
        System.out.println("------------------");
        Series houseMD = (Series) UtilsMediaItem.createInstance(new int[]{25, 37, 41, 55}, "Доктор Хаус", 2);
        UtilsMediaItem.setMediaItemFactory(new SeriesFactory());
        Series doctorWho = (Series) UtilsMediaItem.createInstance(new int[]{12,20,30,45},"Доктор Кто",1);
        System.out.println(houseMD);
        for (Integer item: houseMD){
            System.out.println(item);
        }

        System.out.println(doctorWho);
    }


}
