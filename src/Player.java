import java.util.List;

public class Player {
    private String name;
    private int color;
    private int strategy;
    private List<Plane> planes;

    public Player(String name, int color, int strategy, List<Plane> planes) {
        this.name = name;
        this.color = color;
        this.strategy = strategy;
        this.planes = planes;
    }

    public int getColor() {
        return color;
    }

    public int getStrategy() {
        return strategy;
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public int move(int num, List<Plane> planes) {
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
