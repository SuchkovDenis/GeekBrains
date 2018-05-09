/**
* Geekbrains Java1 Homework 4
* @author Suchkov Denis
* @version dated Feb 06, 2018
*/

import java.util.Scanner;
import java.util.Random;

class JavaHomeWork4 {
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static final int SIZE = 6;
    public static final int DOTS_TO_WIN = 4;

    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    
    public static void main(String[] args) {

        /*
        * Для тестирования правильности проверки раскомментируйте строку test(20).  
        * В результате чего будет проведено 20 игр в крестики-нолики AI против AI.
        * Выводиться в консоль будет только финальная (победная) раскладка с подписью кто победил.
        * Таким образом можно проверить правильность проверки на победу.
        */

        test(20);

        // Игра Человек против AI
        initMap();
        printMap();

        while (true) {
            humanTurn();
            if (checkWin(DOT_X)) {
                printMap();
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                printMap();
                System.out.println("Ничья");
                break;
            }

            aiTurn(DOT_O);
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");

    }   

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE ; i++)
            for (int j = 0; j < SIZE ; j++)
                map[i][j] = DOT_EMPTY;
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE ; i++) 
            System.out.print(i + " ");
        System.out.println();

        for (int i = 0; i < SIZE ; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j<SIZE ; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.print("Введите координаты в формате X Y -> ");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static void aiTurn(char symb) {
        int x, y;
        
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = symb;
    }

    public static boolean checkWin(char symb) {
        int line1, line2, diagonal1, diagonal2;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j <= SIZE - DOTS_TO_WIN ; j++) {
                line1 = line2 = diagonal1 = diagonal2 = 0;
                
                for (int k = 0; k < DOTS_TO_WIN ; k++) {
                    if (map[i][j+k]==symb)
                        line1 += 1;
                    if (map[j+k][i]==symb)
                        line2 += 1; 

                    if (i <= SIZE - DOTS_TO_WIN) {
                        if (map[i+k][j+k]==symb)
                            diagonal1 += 1;
                        if (map[i+k][j+DOTS_TO_WIN-k-1] == symb)
                            diagonal2 += 1; 
                    }
                }
                if (line1==DOTS_TO_WIN || line2==DOTS_TO_WIN || diagonal1==DOTS_TO_WIN || diagonal2==DOTS_TO_WIN)
                    return true;
            }
        }
        return false;
    }

    public static boolean isCellValid(int x, int y) {
        if ((x >= 0) && (x < SIZE) && (y >= 0) && (y < SIZE) && (map[y][x] == DOT_EMPTY))
            return true;
        else
            return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY)
                    return false;
            }
        }
        return true;
    }

    public static void test(int N) {
        for (int game = 0; game < N ; game++) {
            initMap();
             while (true) {
                aiTurn(DOT_X);
                if (checkWin(DOT_X)) {
                    printMap();
                    System.out.println("Победили " + DOT_X + "\n");
                    break;
                }
                if (isMapFull()) {
                    printMap();
                    System.out.println("Ничья");
                    break;
                }

                aiTurn(DOT_O);
                if (checkWin(DOT_O)) {
                    printMap();
                    System.out.println("Победили " + DOT_O + "\n");
                    break;
                }
                if (isMapFull()) {
                    break;
                }
        }   
        }
    }
}