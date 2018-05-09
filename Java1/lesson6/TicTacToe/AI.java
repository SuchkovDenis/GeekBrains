import java.util.Random;

class AI extends Player {
	private Random rand = new Random();

    public AI(char dot) {
        this.name = "Компьютер " + dot;
        this.dot = dot;
    }
    
    @Override
    public void makeTurn(Map field) {
        int x, y;
        System.out.println("Ход игрока " + name);
        do {
            x = rand.nextInt(field.getSize());
            y = rand.nextInt(field.getSize());
        } while (!field.isCellValid(x, y));
        field.changeMap(x, y, dot);
    }
}