class Game {
    private Map gameField;
    private Player[] players = new Player[2];

    public void launch() {
        // Создаем поле с параметрами 5x5, количество точек для победы 4
        gameField = new Map(5,4);

        /* Создаем игроков компьютера
         * Если воспользоваться конструктором, который принимает на вход
         * только один параметр (Player('X')), то будет создан Игрок Компьютера.
         * Для создания игрока человека необходимо воспользоваться конструктором
         * с двумя параметрами (Player("Имя игрока",'Y'). 
         * Таким образом можно легко менять параметры игры : 
         * человек vs человек, компьютер vs компьютер, человек vs компьютер */
        //players[0] = new Player("Сергей",'X');
        players[0] = new Player("Денис",'X');
        players[1] = new Player("Лююимая Саша",'O');

        playGame();        
    }

    public int playGame() {
        gameField.show();
        while (true)
            for (Player player : players) {
                player.makeTurn(gameField);
                gameField.show();
                if (gameField.checkWin(player.getDot())) {
                    System.out.println("Победил " + player.getName());
                    return 0;
                }
                if (gameField.isFull()) {
                    System.out.println("Ничья");
                    return 0;
                }
            }
    }
}