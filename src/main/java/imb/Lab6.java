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
//        Sellable auto = SellableReader.createInstance("Hyundai", "Solaris", 2018, new String[]{"Хетчбек", "Механика", "124 лс", "13531 км"});
//        SellableReader.setSellableFactory(new Boat.Factory());
        //Sellable boat = SellableReader.createInstance("Four Winns", "Horizon 180", 2016, new String[]{"Стеклопластик", "Стационарный мотор", "длина 5,3м", "ширина 2,4м", "осадка 0,2м", "6 пассажиров"});
        Series houseMD = (Series) UtilsMediaItem.createInstance(new int[]{20, 40, 48, 60}, "Доктор Хаус", 2);
        UtilsMediaItem.setMediaItemFactory(new SeriesFactory());
        MediaItemFactory doctorWho =  UtilsMediaItem.createInstance(new int[]{12,20,30,45},"Доктор Кто",1);
        System.out.println(houseMD);
        System.out.println(doctorWho);
    }


}
