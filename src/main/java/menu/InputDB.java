package menu;

import imb.Anime;
import imb.MediaDB;
import imb.MediaItem;
import imb.Series;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputDB {
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
        boolean flag = true;
        while (flag) {
            System.out.print("Вы хотите добавить: [1] сериал / [2] аниме? ");
            int answer = printScanner.nextInt();
            switch (answer) {
                case 1:
                    db.add(addMediaItem("Series"));
                    flag = false;
                    break;
                case 2:
                    db.add(addMediaItem("Anime"));
                    flag = false;
                    break;
                default:
                    System.out.println("Ответ должен содержать (1 - сериал)/(2 - аниме)");
                    break;
            }
        }
    }
    private static MediaItem addMediaItem(String type){
        if (type.equals("Series"))
        //db.add(new Series(new int[]{20, 40, 48, 60}, "Доктор Кто", 3));
        return new Series(getUserDurationEpisode(), getUserName(),getUserDurationIntro());
        else if (type.equals("Anime"))
            return new Anime(getUserDurationEpisode(), getUserName(),getUserDurationIntro());
        else return null;
    }
    private static String getUserName(){
        System.out.print("Введите имя сериала/аниме: ");
        Scanner printScanner = new Scanner(System.in);

        return printScanner.next();
    }
    private static int getUserDurationIntro(){
        System.out.print("Введите длительность интро/опенинга: ");
        Scanner printScanner = new Scanner(System.in);

        return printScanner.nextInt();
    }
    private static int[] getUserDurationEpisode(){
        System.out.print("Сколько серий в сериале/аниме: ");
        Scanner printScanner = new Scanner(System.in);
        int count = printScanner.nextInt();
        List<Integer> episode = new ArrayList<>();
        while (episode.size() < count){
            System.out.println("Введите длительность серии " + (episode.size() + 1));
            episode.add(printScanner.nextInt());
        }
        int[] mass = new int[episode.size()];
        for (int i = 0; i < episode.size(); i++){
            mass[i] = episode.get(i);
        }
        return mass;
    }
}
