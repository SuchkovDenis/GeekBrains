import java.util.Scanner;
import java.util.Random;

class Player {
    private String name; // Имя игрока
    private char dot;    // Символ, которым играет игрок
    private boolean ai;  // Является ли компьютер игроком

    private Scanner sc = new Scanner(System.in);
    private Random rand = new Random();

    // При вызове конструктора с одним параметром создается игрок-компьютер
    Player(char dot) {
        setName("Компьютер " + dot);
        setDot(dot);
        ai = true;
    }

    // При вызове конструктора с двумя параметрами создается игрок-человек
    Player(String name, char dot) {
        setName(name);
        setDot(dot);
        ai = false;
    }

    public void makeTurn(Map field) {
        int x, y;
        System.out.println("Ход игрока " + name);
        if (!ai) {
            do {
                System.out.print("Введите координаты в формате X Y -> ");
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
            } while (!field.isCellValid(x, y));
            field.map[y][x] = dot;
        } else {
            do {
                x = rand.nextInt(field.getSize());
                y = rand.nextInt(field.getSize());
            } while (!field.isCellValid(x, y));
            field.map[y][x] = dot;
        }
    }

    public String getName() {
        return name;
    }

    public char getDot() {
        return dot;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDot(char dot) {
        this.dot  = dot;
    }
}