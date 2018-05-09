/**
* Geekbrains Java1 Homework 6 - TicTacToe with OOP
* @author Suchkov Denis
* @version dated Feb 16, 2018
* @link https://github.com/suchkovdenis
*/
import java.util.Scanner;

class TicTacToe {
    private Map gameField;
    private Player[] players = new Player[2];

    public void init() {
        int size, dotsToWin, choise;
        Scanner sc = new Scanner(System.in);

        System.out.println("Выберите режим:");
        System.out.println("1. Человек VS Человек");
        System.out.println("2. Человек VS Компьютер");
        System.out.println("3. Компьютер VS Компьютер");
        System.out.print("> ");

        choise = sc.nextInt();
        switch (choise) {
            case 1:
                players[0] = new Human("Игрок1",'X');
                players[1] = new Human("Игрок2",'O');
                break;
            case 2:
                players[0] = new Human("Игрок1",'X');
                players[1] = new AI('O'); 
                break;
            default:
                players[0] = new AI('X');
                players[1] = new AI('O'); 
                break;
        }

        System.out.println("Размер игрового поля: ");
        do {
            System.out.print("> ");
            size = sc.nextInt();
        } while (size < 3);

        System.out.println("Количество точек для победы: ");
        do {
            System.out.print("> ");
            dotsToWin = sc.nextInt();
        } while ((dotsToWin > size) || (dotsToWin < 3));

        gameField = new Map(size,dotsToWin);
    }

    public int playGame() {
        gameField.show();
        while (true)
            for (Player player : players) {
                player.makeTurn(gameField);
                gameField.show();
                if (gameField.checkWin(player.getDot())) {
                    System.out.println("Победил " + player);
                    return 0;
                }
                if (gameField.isFull()) {
                    System.out.println("Ничья");
                    return 0;
                }
            }
    }
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.init();
        game.playGame();
    }   
}