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

    public Game(int playerCount, boolean humanPlaying) {
        if (playerCount <= 0 || playerCount > 4) {
            throw new IllegalArgumentException("Illegal number of players");
        }
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
            if (humanPlaying && i == 0) {
                players.add(new Player("YOU" + i, i, 2, planes));
            } else {
                players.add(new Player("P" + i, i, 1, planes));
            }
        }
    }

    public int run() {
        // decide order of players
        Collections.shuffle(players);
        Queue<Player> nextPLayerQueue = new LinkedList<>(players);
        while (true) {
            Player p = nextPLayerQueue.remove();
            nextPLayerQueue.add(p);

            int num = roll();
            while (num == 6) {
                p.move(num, planes);
                if (p.hasWon()) {
                    return p.getColor();
                }
                num = roll();
            }
            p.move(num, planes);
            if (p.hasWon()) {
                return p.getColor();
            }
        }
    }

    private int roll() {
        Random r = new Random();
        return r.nextInt(6) + 1;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
