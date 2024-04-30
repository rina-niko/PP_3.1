package imb;

import excep.MyException;

import java.util.ArrayList;
import java.util.List;

public class Lab3 {
    public static void main(String[] args) {

        MediaDB db = new MediaDB(); //Создать базу данных
        db.showDB(); //Вывести полную информацию обо всех элементах БД
        System.out.println("----------------");

        MediaDB theSameDB = new MediaDB();
        theSameDB.setDb(searchTheSameSerial(db.getDb())); //поиск одинаково длинных к просмотру сериалов
        theSameDB.showDB();
        System.out.println("----------------");
        MediaDB serial = new MediaDB();
        serial.setDb(getListByClass(db.getDb(), Series.class.toString())); //фильтрация по типу класса = imb.Series
        serial.showDB();
        System.out.println("----------------");
        MediaDB anime = new MediaDB();
        anime.setDb(getListByClass(db.getDb(), Anime.class.toString())); //фильтрация по типу класса = imb.Anime
        anime.showDB();
        System.out.println("----------------");
        MediaItem myRuntimeException = new Series(new int[]{-20, 40, 48, 60}, "Доктор Кто", 3);
        System.out.println("----------------");

        try {
            int k = divideByZero(myRuntimeException.getTotalDuration());
        } catch (MyException e) {
            throw new RuntimeException(e);
        }

    }

    private static int divideByZero(int value) throws MyException {
        if (value == 0)
            throw new MyException("value равно нулю!");
        else {
            int i = 5 / value;
            return i;
        }
    }

    private static List<MediaItem> getListByClass(List<MediaItem> db, String tClass) {
        // Создаем пустой список для хранения объектов, соответствующих заданному классу или интерфейсу
        List<MediaItem> list = new ArrayList<>();

        // Итерируемся по списку db для каждого элемента i
        for (MediaItem i : db) {
            // Получаем класс объекта i и преобразуем его в строку для сравнения с tClass
            if (i.getClass().toString().equals(tClass))
                // Если класс объекта совпадает с tClass, добавляем объект в список
                list.add(i);
        }
        // Возвращаем список объектов, соответствующих заданному классу или интерфейсу
        return list;
    }

    private static List<MediaItem> searchTheSameSerial(List<MediaItem> db) {
        // Создаем пустой список для хранения сериалов с одинаковой общей длительностью эпизодов
        List<MediaItem> theSameSerial = new ArrayList<>();

        // Итерируемся по списку db для каждого элемента i
        for (MediaItem i : db) {
            // Вложенный цикл для сравнения каждого элемента с каждым другим элементом
            for (MediaItem j : db) {
                // Проверяем, что i и j не являются одним и тем же объектом
                if (!i.equals(j)) {
                    // Проверяем, что общая длительность всех эпизодов у i и j равна
                    if (i.totalMinutesOfAllEpisodes() == j.totalMinutesOfAllEpisodes()) {
                        // Если i еще не добавлен в список, добавляем его
                        if (!theSameSerial.contains(i)) {
                            theSameSerial.add(i);
                        }
                        // Если j еще не добавлен в список, добавляем его
                        if (!theSameSerial.contains(j)) {
                            theSameSerial.add(j);
                        }
                    }
                }
            }
        }
        // Возвращаем список сериалов с одинаковой общей длительностью эпизодов
        return theSameSerial;
    }
}

