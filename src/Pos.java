import java.util.List;
import java.util.Queue;

public class Pos {
    private char color;
    private Queue<Plane> planes;
    private int canJumpTo;

    public Pos(char color, Queue<Plane> planes, int canJumpTo) {
        this.color = color;
        this.planes = planes;
        this.canJumpTo = canJumpTo;
    }

    public char getColor() {
        return color;
    }

    public Queue<Plane> getPlanes() {
        return planes;
    }

    public int getCanJumpTo() {
        return canJumpTo;
    }

    public void setPlanes(Queue<Plane> planes) {
        this.planes = planes;
    }
}
