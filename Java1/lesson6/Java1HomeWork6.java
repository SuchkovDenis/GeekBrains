/**
* Geekbrains Java1 Homework 6
* @author Suchkov Denis
* @version dated Feb 16, 2018
* @link https://github.com/suchkovdenis
*/
class Java1HomeWork6 {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Dog("Zeus");
        animals[1] = new Cat("Murka");
        for (Animal animal: animals) {
            System.out.println(animal);
            System.out.println(animal.run(105));
            System.out.println(animal.swim(4));
            System.out.println(animal.jump(1.5));
        }
    }
}
// Каждое животное (будь то кошка или собака) должно уметь бегать, плавать и прыгать,
// то есть должно реализовать некоторый интерфейс
interface IAnimal {
    // В задании сказано, что 
    public String run(double run);
    public String swim(double swim);
    public String jump(double jump);
}

// Абстрактный класс, реализующий интерфейс
abstract class Animal implements IAnimal {
    // Можно было бы обойтись и без поля name, но не будем обижать животных :)
    private String name; 
    // Ограничения у животных 
    private double run, jump, swim;

    // Делаем конструктор protected, так как класc абстрактный
    protected Animal(String name, double run, double jump, double swim) {
        this.name = name;
        this.run = run;
        this.jump = jump;
        this.swim = swim;
    }

    // Все животные бегают, прыгают и плавают одинаково,  
    // поэтому реализуем эти методы здесь
    @Override
    public String run(double run){
        return "run: " + (run<=this.run);
    }
    @Override
    public String swim(double swim){
        return "swim: " + (swim<=this.swim);
    }
    @Override
    public String jump(double jump){
        return "jump: " + (jump<=this.jump);
    }

    @Override 
    public String toString() {
        return this.getClass().getName() + " " +this.name;
    }
}

class Cat extends Animal {
    public Cat(String name) {
        // Конструктор Cat вызвает конструктор Animal с ограничениями кошки
        super(name,200,2,0);
    }
}

class Dog extends Animal {   
    public Dog(String name) {
        // Конструктор Dog вызвает конструктор Animal с ограничениями собаки
        super(name,500,0.5,10);
    }
}