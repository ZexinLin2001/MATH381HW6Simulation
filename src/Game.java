import java.util.*;

public class Game {
    private List<Player> players;
    private List<Pos> positions;
    private List<Plane> planes;
    private static final Random r = new Random();

    public Game(int playerCount) {
        if (playerCount <= 0 || playerCount > 4) {
            throw new IllegalArgumentException("Illegal number of players");
        }
        char[] colors = new char[]{'B', 'Y', 'G', 'R'};

        // init players
        // P0 will always be the one we study
        players = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            players.add(new Player("P" + i, colors[i], 1));
        }

        // init planes
        planes = new ArrayList<>();
        for (Player p : players) {
            for (int i = 0; i < 4; i++) {
                planes.add(new Plane(p.getColor(), i));
            }
        }

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
        // 84 - 87 => landing bse, end of this plane
        //
        // index are counted clock-wise starting with blue, yellow, green, red
        // 8 represents the first blue position on the board after the blue plane has taken off
        positions = new ArrayList<>();
        for (int i = 0; i < 84; i++) {
            // base
            if (i < 4) {
                if (i < playerCount) {
                    Queue<Plane> temp = new LinkedList<>();
                    for (int j = 0; j < 4; j++) {
                        temp.add(planes.get(i * 4 + j));
                    }
                    positions.add(new Pos(colors[i % 4], temp, i + 4));
                } else {
                    positions.add(new Pos(colors[i % 4], new LinkedList<>(), i + 4));
                }
            }
            // launch point
            else if (i < 8) {
                positions.add(new Pos(colors[i % 4], new LinkedList<>(), -1)); // cannot jump to anywhere
            }
            // normal board
            else if (i < 60) {
                positions.add(new Pos(colors[i % 4], new LinkedList<>(), i + 4));
            }
            // landing arrow
            else if (i < 84) {
                positions.add(new Pos(colors[i % 4], new LinkedList<>(), -1));
            }
            // landing base
            else if (i < 87) {
                positions.add(new Pos(colors[i % 4], new LinkedList<>(), -1));
            } else {
                System.out.println("why");
            }
        }

        // decide order of players
        Collections.shuffle(players);
        Queue nextPLayerQueue = new LinkedList<>(players);
        int count = 0;
        // the actual game
        while (positions.get(84).getPlanes().size() != 4 &&
                positions.get(85).getPlanes().size() != 4 &&
                positions.get(86).getPlanes().size() != 4 &&
                positions.get(87).getPlanes().size() != 4) {
            int num = roll();

            count++;
            if (count > 10000) {
                throw new RuntimeException("Took too long");
            }
        }
    }

    private int roll() {
        return r.nextInt(6) + 1;
    }

}
