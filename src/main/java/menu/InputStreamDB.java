package menu;

import imb.MediaDB;
import utils.IOMediaItem;

import java.io.StringReader;
import java.util.Scanner;

public class InputStreamDB {
    private static MediaDB db = new MediaDB();
    public static void input() {

        db.clear();

        boolean flag = true;
        Scanner printScanner = new Scanner(System.in);
        while (flag) {
            System.out.println("Сейчас в базе " + db.size() + " сериалов/аниме");
            System.out.print("Желаете добавить сериал/аниме? (Y - да)/(N - нет): ");
            String answer = printScanner.next();
            switch (answer.toLowerCase()) {
                case "y":
                    addItem();
                    break;
                case "n":
                    System.out.println("------------");
                    db.showDB();
                    System.out.println("------------");
                    flag = false;
                    break;
                default:
                    System.out.println("Ответ должен содержать (Y - да)/(N - нет)");
                    break;
            }

        }
    }
    private static void addItem(){
        Scanner printScanner = new Scanner(System.in);
        System.out.println("Введите информацию в следующем формате:" +
                " <тип материала>; <имя материала>; <длительность интро>; <[длительность 1 серии, длительность 2 серии, ...]>");
        db.add(IOMediaItem.readMediaItem(new StringReader(printScanner.nextLine())));
    }
}
