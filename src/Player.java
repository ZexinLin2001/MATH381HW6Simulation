import java.util.HashSet;
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
            case 0:
                return s0Move(planes);
            case 1:
                return s1Move(planes);
        }
        return -1;
    }

    private int s0Move(List<Plane> planes) {
        System.out.println(printBoard(planes));

        return -1;
    }

    private int s1Move(List<Plane> planes) {
        return -1;
    }






    private static String printBoard(List<Plane> planes) {

        final int[][] BOARD = {
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
                if (positions.contains(BOARD[i][j])) {
                    // in the base
                    if (BOARD[i][j] < 4) {
                        res += colorArray[BOARD[i][j] % 4];;
                        colorInBase[BOARD[i][j] % 4]--;
                        if (colorInBase[BOARD[i][j] % 4] == 0) {
                            positions.remove(BOARD[i][j]);
                        }
                    } else {
                        // find which plane is on this spot
                        for (Plane p : planes) {
                            if (p.getPosition() == BOARD[i][j]) {
                                res += colorArray[p.getColor()];
                            }
                        }
                    }
                }
                // this is for generic board
                else {
                    if (BOARD[i][j] == -2) {
                        res += "*  ";
                    } else if (BOARD[i][j] < 4) {
                        res += "   ";
                    } else if (3 < BOARD[i][j] && BOARD[i][j] < 8) {
                        res += "L  ";
                    } else {
//                        res += "□  ";
                        res += "+  ";
                    }
                }
            }
            res += "\n";
        }
        return res;
    }
}
