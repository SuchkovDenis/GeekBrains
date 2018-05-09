import java.util.Scanner;

class Human extends Player {
	private Scanner sc = new Scanner(System.in);

    public Human(String name, char dot) {
        this.name = name;
        this.dot = dot;
    }
    
    @Override
    public void makeTurn(Map field) {
        int x, y;
        System.out.println("Ход игрока " + name);
        do {
            System.out.print("Введите координаты в формате X Y -> ");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!field.isCellValid(x, y));
        field.changeMap(x, y, dot);
    }
}