package menu;

import imb.MediaDB;
import imb.MediaItem;
import utils.IOMediaItem;

import java.io.*;
import java.util.Scanner;

public class PrintBites {
    public static void print() {
        boolean flag = true;
        Scanner printScanner = new Scanner(System.in);
        while (flag) {

            System.out.print("Желаете ввести имя файла с клавиатуры? (Y - да)/(N - нет): ");
            String answer = printScanner.next();
            switch (answer.toLowerCase()) {
                case "y":
                    System.out.println("Укажите имя файла без расширения");
                    printDefault(userName() + ".bin");
                    flag = false;
                    break;
                case "n":
                    printDefault("MediaDB.bin");
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

    private static void printDefault(String name) {
        MediaDB db = new MediaDB();

        try (OutputStream outputStream = new FileOutputStream(name)) {
            for (MediaItem item : db.getDb()) {
                IOMediaItem.outputMediaItem(item, outputStream);
            }
            System.out.println("------------");
            System.out.println("База выгружена в файл " + name);
            System.out.println("------------");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
