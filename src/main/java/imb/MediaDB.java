package imb;

import java.util.ArrayList;
import java.util.List;

public class MediaDB {
    List<MediaItem> db = new ArrayList<>();

    public MediaDB() {
        db.add(new Series(new int[]{20, 40, 48, 60}, "Доктор Кто", 3));
        db.add(new Series(new int[]{60, 48, 40, 20}, "Шерлок", 5));
        db.add(new Series(new int[]{20, 24, 40, 45}, "Как я встретил вашу маму", 2));
        db.add(new Series(new int[]{20, 22, 25, 30}, "Кухня", 1));
        db.add(new Anime(new int[]{18, 20, 24, 32}, "Восхождение героя Щита", 4));
        db.add(new Anime(new int[]{17, 22, 26, 33}, "Мастера меча онлайн", 6));
        db.add(new Anime(new int[]{26, 32, 35, 45}, "Реинкарнация безработного", 5));
        db.add(new Anime(new int[]{35, 45, 26, 32}, "Волчица и пряности", 3));
    }
    //4
        public void clear(){
        db.clear();
    }
    //4
    public void showDB(){
        if(db.size() > 0) {
            for (MediaItem item : db) {
                System.out.println(item);
            }
        }else System.out.println("База пуста");
    }
    //4
    public int size(){
        return db.size();
    }
    //4
    public void add(MediaItem item){
        db.add(item);
    }

    public List<MediaItem> getDb() {
        return db;
    }

    public void setDb(List<MediaItem> db) {
        this.db = db;
    }
}
