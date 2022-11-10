import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GameInterface {

    private int[][] board = {
            {-2, -2, -2, -2, -1, -1, -1, -1, -1, -1, -1, -1, 6, -2, -2, -2, -2},
            {-2, 1, 1, -2, -1, 27, 28, 29, 30, 31, 32, 33, -1, -2, 2, 2, -2},
            {-2, 1, 1, -2, -1, 26, -1, -1, 62, -1, -1, 34, -1, -2, 2, 2, -2},
            {-2, -2, -2, -2, -1, 25, -1, -1, 66, -1, -1, 35, -1, -2, -2, -2, -2},
            {5, -1, -1, -1, -1, 24, -1, -1, 70, -1, -1, 36, -1, -1, -1, -1, -1},
            {-1, 20, 21, 22, 23, -1, -1, -1, 74, -1, -1, -1, 37, 38, 39, 40, -1},
            {-1, 19, -1, -1, -1, -1, -1, -1, 78, -1, -1, -1, -1, -1, -1, 41, -1},
            {-1, 18, -1, -1, -1, -1, -1, -1, 82, -1, -1, -1, -1, -1, -1, 42, -1},
            {-1, 17, 61, 65, 69, 73, 77, 81, -1, 83, 79, 75, 71, 67, 63, 43, -1},
            {-1, 16, -1, -1, -1, -1, -1, -1, 80, -1, -1, -1, -1, -1, -1, 44, -1},
            {-1, 15, -1, -1, -1, -1, -1, -1, 76, -1, -1, -1, -1, -1, -1, 45, -1},
            {-1, 14, 13, 12, 11, -1, -1, -1, 72, -1, -1, -1, 49, 48, 47, 46, -1},
            {-1, -1, -1, -1, -1, 10, -1, -1, 68, -1, -1, 50, -1, -1, -1, -1, 7},
            {-2, -2, -2, -2, -1, 9, -1, -1, 64, -1, -1, 51, -1, -2, -2, -2, -2},
            {-2, 0, 0, -2, -1, 8, -1, -1, 60, -1, -1, 52, -1, -2, 3, 3, -2},
            {-2, 0, 0, -2, -1, 59, 58, 57, 56, 55, 54, 53, -1, -2, 3, 3, -2},
            {-2, -2, -2, -2, 4, -1, -1, -1, -1, -1, -1, -1, -1, -2, -2, -2, -2},
    };

    public GameInterface() {
        Game g = new Game(4);
        List<Player> players = g.getPlayers();
        List<Plane> planes = new ArrayList<>();

        for (Player p : players) {
            planes.addAll(p.getPlanes());
        }

        planes.get(0).setPosition(30);

        System.out.println(printBoard(planes));
    }

    public String printBoard(List<Plane> planes) {

        HashSet<Integer> positions = new HashSet<>();

        int[] colorInBase = {0, 0, 0, 0};
        for (Plane p : planes) {
            positions.add(p.getPosition());
            if (p.getPosition() < 4) {
                colorInBase[p.getColor()]++;
            }
        }


        String[] colorArray = {"B  ", "Y  ", "G  ", "R  "};

        String res = "";
        // iterate over every index
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 17; j++) {
                // if this should be a plane
                if (positions.contains(board[i][j])) {
                    // in the base
                    if (board[i][j] < 4) {
                        res += colorArray[board[i][j] % 4];;
                        colorInBase[board[i][j] % 4]--;
                        if (colorInBase[board[i][j] % 4] == 0) {
                            positions.remove(board[i][j]);
                        }
                    } else {
                        // find which plane is on this spot
                        for (Plane p : planes) {
                            if (p.getPosition() == board[i][j]) {
                                res += colorArray[p.getColor()];
                            }
                        }
                    }
                }
                // this is for generic board
                else {
                    if (board[i][j] == -2) {
                        res += "*  ";
                    } else if (board[i][j] == -1) {
                        res += "   ";
                    } else if (board[i][j] == -3) {
                        res += "   ";
                    } else if (board[i][j] < 4) {
                        res += "   ";
                    } else if (3 < board[i][j] && board[i][j] < 8) {
                        res += "L  ";
                    } else {
                        res += "□  ";
                    }
                }
            }
            res += "\n";
        }
        return res;
    }

    public static void main(String[] args) {
        GameInterface g = new GameInterface();
    }
}
