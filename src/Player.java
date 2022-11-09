public class Player {
    private char color;
    private int strategy;

    public Player(char color, int strategy) {
        this.color = color;
        this.strategy = strategy;
    }

    public char getColor() {
        return color;
    }

    public int getStrategy() {
        return strategy;
    }
}
