import java.util.*;

// init positions
//
// index % 4 =
//     - 0 => Blue
//     - 1 => Yellow
//     - 2 => Green
//     - 3 => Red
//
// 0 - 3   => base
// 4 - 7   => launch point
// 8 - 59  => normal board
// 60 - 83 => landing arrow
// 84 - 87 => landing base, end of this plane
//
// index are counted clock-wise starting with blue, yellow, green, red
// 8 represents the first blue position on the board after the blue plane has taken off
public class Game {
    private List<Player> players;
    private List<Plane> planes;
    private static final Random r = new Random();

    public Game(int playerCount) {
        if (playerCount <= 0 || playerCount > 4) {
            throw new IllegalArgumentException("Illegal number of players");
        }
        char[] colors = new char[]{'B', 'Y', 'G', 'R'};

        // init players
        // P0 will always be the one we study
        this.players = new ArrayList<>();
        this.planes = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            List<Plane> planes = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                planes.add(new Plane(j, i, i));
            }
            this.planes.addAll(planes);
            players.add(new Player("P" + i, colors[i], 1, planes));
        }

        // decide order of players
        Collections.shuffle(players);
        Queue nextPLayerQueue = new LinkedList<>(players);
        int count = 0;
        // the actual game
    }

    private int roll() {
        return r.nextInt(6) + 1;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
