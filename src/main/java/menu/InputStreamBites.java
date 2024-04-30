package menu;

import imb.MediaDB;
import utils.IOMediaItem;

import java.io.*;
import java.util.Scanner;

public class InputStreamBites {
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


    public static void addItem() {
        boolean flag = true;
        Scanner printScanner = new Scanner(System.in);
        while (flag) {

            System.out.print("Желаете указать имя файла с клавиатуры? (Y - да)/(N - нет): ");
            String answer = printScanner.next();
            switch (answer.toLowerCase()) {
                case "y":
                    System.out.println("Укажите имя файла без расширения");
                    targetFile(userName() + ".bin");
                    flag = false;
                    break;
                case "n":
                    targetFile("InputMediaDB.bin");
                    flag = false;
                    break;
                default:
                    System.out.println("Ответ должен содержать (Y - да)/(N - нет)");
                    break;
            }
        }
    }
    private static String userName(){
        System.out.print("Введите имя файла: ");
        Scanner printScanner = new Scanner(System.in);

        return printScanner.next();
    }

    private static void targetFile(String name) {


        try (InputStream in= new FileInputStream(name)) {
                db.setDb(IOMediaItem.inputMediaItem(in, db));

            System.out.println("------------");
            System.out.println("База заполнена из файла " + name);
            System.out.println("------------");
        } catch (IOException e) {
            System.out.println("Указанный файл не существует");
        }
    }
}
