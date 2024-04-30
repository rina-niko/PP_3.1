package imb;

import menu.*;
import utils.IOMediaItem;
import utils.UtilsMediaItem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Для работы с приложением выберите команду: ");
            System.out.println("[0] выход");
            System.out.println("[1] запись в байтовый поток");
            System.out.println("[2] чтение из байтового потока");
            System.out.println("[3] запись в символьном потоке");
            System.out.println("[4] чтение из символьного потока");
            System.out.println("[5] сериализовать объект");
            System.out.println("[6] десериализовать объект");
            System.out.println("[7] заполнить базу вручную");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Выберите команду: ");
            int selectionUser = scanner.nextInt();
            switch (selectionUser) {
                case 0:
                    System.out.println("------------");
                    System.out.println("До новых встреч!");
                    System.out.println("------------");
                    System.exit(0);
                    break;
                case 1:
                    PrintBites.print();
                    break;
                case 2:
                    InputStreamBites.input();
                    break;
                case 3:
                    PrintDB.print();
                    break;
                case 4:
                    InputStreamDB.input();
                    break;
                case 5:
                    Series serializeObj = new Series(new int[]{100, 150, 200}, "Loki", 10);
                    try {
                        UtilsMediaItem.serializeMediaItem(serializeObj, new FileOutputStream("serial.ser"));
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("------------");
                    System.out.println("Объект сериализован");
                    System.out.println("------------");
                    break;
                case 6:
                    try {
                        MediaItem deserializeObj = UtilsMediaItem.deserializeMediaItem(new FileInputStream("serial.ser"));
                        System.out.println("------------");
                        System.out.println("Объект десериализован");
                        System.out.println(deserializeObj);
                        System.out.println("------------");
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 7:
                    InputDB.input();
                    break;

                default:
                    System.out.println("недоступное значение кода");
                    break;
            }
        }
    }


}
