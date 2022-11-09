import java.util.List;

public class Game {
    private List<Player> players;
    private List<Pos> positions;
    private List<Plane> planes;

    public Game(List<Player> players, List<Pos> positions, List<Plane> planes) {
        this.players = players;
        this.positions = positions;
        this.planes = planes;
    }

}
