import java.util.List;

public class Pos {
    private char color;
    private List<Plane> planes;
    private Pos canJumpTo;

    public Pos(char color, List<Plane> planes, Pos canJumpTo) {
        this.color = color;
        this.planes = planes;
        this.canJumpTo = canJumpTo;
    }

    public char getColor() {
        return color;
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public Pos getCanJumpTo() {
        return canJumpTo;
    }

    public void setPlanes(List<Plane> planes) {
        this.planes = planes;
    }
}
