public class Player {
    private String name;
    private char color;
    private int strategy;

    public Player(String name, char color, int strategy) {
        this.name = name;
        this.color = color;
        this.strategy = strategy;
    }

    public char getColor() {
        return color;
    }

    public int getStrategy() {
        return strategy;
    }

    public int move() {
        switch (strategy) {
            case 1:
                return s1Move();
        }
        return -1;
    }

    private int s1Move() {
        return -1;
    }
}
