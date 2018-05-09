abstract class Player implements IPlayer{
    protected String name; // Имя игрока
    protected char dot;    // Символ, которым играет игрок

    @Override
    public String toString() {
        return name;
    }

    public char getDot() {
        return dot;
    }
}