/**
* Geekbrains Java1 Homework 3
* @author Suchkov Denis
* @version dated Feb 03, 2018
*/

import java.util.Scanner;
import java.util.Random;

class JavaHomeWork3 {
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static int number, guess, again, minLength;
    public static boolean win;
    public static String word, masc;
    public static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
    "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea","peanut", "pear",
    "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {
        playGame2();
        playGame1();
    }

    public static void playGame1() {
        System.out.println("Игра : Угадай число от 0 до 9 за три попытки");
        do {
            win = false;
            number = rand.nextInt(10);    
            for (int i=0; i<3 ; i++) {    
                guess = getNumberFromScanner("Введите число от 0 до 9",sc,0,9);
                if (guess == number) {
                    win = true;
                    break;
                } 
                else if (guess > number)
                    System.out.println("Загаданное число меньше");
                else
                    System.out.println("Загаданное число больше");
            }
            if (win) 
                System.out.println("Вы угадали число!");
            else
                System.out.println("Вы проиграли :(\nЗагаданное число : " + number);
            again = getNumberFromScanner("Повторить игру еще раз? 1 – да / 0 – нет",sc,0,1);
        }
        while (again == 1);
    }
    public static  void playGame2() {
        System.out.println("Игра : Угадай фрукт из списка");
        for (String w : words)
            System.out.print(w + " ");
        System.out.println();

        number = rand.nextInt(words.length);
        do {
            masc = "";
            System.out.print(">>>");
            word = sc.next();
            if (word.equals(words[number])) {
                System.out.println("Вы угадали!");
                break;
            }
            else {
                minLength = (word.length() < words[number].length()) ? word.length() : words[number].length();
                for (int i = 0; i<minLength ; i++) {
                    if (word.charAt(i) == words[number].charAt(i))
                        masc += word.charAt(i);
                    else
                        masc += "#";
                }
                for (int i = minLength ; i<15 ; i++ )
                    masc += "#";
                System.out.println(masc);
            }
        } 
        while (word != words[number]);
    }
    public static int getNumberFromScanner(String s, Scanner sc, int min, int max) {
        int i;
        do {
            System.out.print(s+"\n>>>");
            i = sc.nextInt();
        } while (i<min || i>max);
        return i;
    }
}