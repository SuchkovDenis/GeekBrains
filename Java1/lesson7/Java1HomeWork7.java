/**
* GeekBrains Java1 Homework 7
* @author Suchkov Denis
* @version dated Feb 17, 2018
* @link https://github.com/suchkovdenis
*/
class Java1HomeWork7 {

	public static void main(String[] args) {
        Cat[] cats = {new Cat("Мурка",4), new Cat("Барсик", 6), new Cat("Снежок", 8)};
        Plate plate = new Plate(14);
        for (Cat cat : cats) {
            System.out.println("Еды на тарелке : " + plate.getFood());
            System.out.println(cat);
            System.out.println("Он сыт? " + cat.isSatiety());
            System.out.println(cat + " пытается покушать");
            cat.eat(plate);
            System.out.println("Он сыт? " + cat.isSatiety());
            System.out.println("---------------------");
        }
        System.out.println("Еды на тарелке : " + plate.getFood());
    }
}

class Cat {
    private String name;
    private int appetite;
    private boolean satiety;
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }
    public void eat(Plate plate) {
        if (!satiety) {
            int foodBefore = plate.getFood();
            plate.reduceFood(appetite);
            if (plate.getFood()<foodBefore)
                satiety = true;
        }
    }
    public boolean isSatiety() {
        return satiety;
    }
    @Override 
    public String toString() {
        return this.getClass().getName() + " " + this.name + " с аппетитом " + this.appetite;
    }
}

class Plate {
    private int food;
    public Plate(int food) {
        if (food>=0)
            this.food = food;
        else
            this.food = 0;
    }
    public void reduceFood(int food) {
        if (food<=this.food) 
            this.food -= food;
    }
    public void putFood(int food) {
        if (food>=0)
            this.food += food;
    }
    public int getFood() {
        return food;
    }
}