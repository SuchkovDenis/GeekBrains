/**
* Geekbrains Java1 Homework 5 - TicTacToe with OOP
* @author Suchkov Denis
* @version dated Feb 12, 2018
* @link https://github.com/suchkovdenis
*/

class TicTacToe {
    public static Game game;
    
    public static void main(String[] args) {
        // Создаем игру
        game = new Game();

        // Запускаем игру
        game.launch();
    }   
}