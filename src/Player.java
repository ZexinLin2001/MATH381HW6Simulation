import java.util.*;

public class Player {
    private String name;
    private int color;
    private int strategy;
    private List<Plane> planes;
    private boolean won;

    public Player(String name, int color, int strategy, List<Plane> planes) {
        this.name = name;
        this.color = color;
        this.strategy = strategy;
        this.planes = planes;
        this.won = false;
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

    public boolean hasWon() {
        return won;
    }

    public int move(int num, List<Plane> planes) {
        switch (strategy) {
            case 0:
                s0Move(num, planes);
                break;
            case 1:
                s1Move(num, planes);
                break;
            case 2:
                s2Move(num, planes);
                break;
            case 3:
                s3Move(num, planes);
                break;
        }

        boolean won = true;
        for (Plane p : this.planes) {
            won = won && p.isEnd();
        }
        this.won = won;
        return -1;
    }

    private int s0Move(int num, List<Plane> planes) {
        Scanner console = new Scanner(System.in);

        Map<Integer, Integer> possible_moves = new HashMap<>();
        Map<Integer, Integer> canMoveToLoc = new HashMap<>();
        for (int i = 0; i < this.planes.size(); i++) {
            if (!this.planes.get(i).isEnd()){
                int loc = this.planes.get(i).canMoveTo(num, planes)[0];
                if (loc >= 0 && !canMoveToLoc.containsKey(loc)) {
                    possible_moves.put(i, loc);
                    canMoveToLoc.put(loc, i);
                }
            }
        }

        if (possible_moves.size() == 0) {
            System.out.println("You rolled a " + num);
            System.out.println("You are unable to move");
        } else {
            int input = -1;
            while (input < 0) {
                System.out.println(printBoard(planes, canMoveToLoc));
                System.out.println("You rolled a " + num);
                System.out.print("Please choose which move you want to make (0, 1, 2, 3): ");
                String temp = console.nextLine();
                try{
                    int tempInt = Integer.parseInt(temp);
                    if (possible_moves.containsKey(tempInt)) {
                        input = tempInt;
                    } else {
                        System.out.println("Please only enter number that are shown in the board");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter only numbers");
                }
            }

            planes.get(input).move(num, planes);
        }
        return -1;
    }

    private int s1Move(int num, List<Plane> planes) {
//        System.out.println(name + " rolled a " + num);
        Map<Integer, Integer> possible_moves = new HashMap<>();
        Map<Integer, Integer> indexToPlane = new HashMap<>();
        Random r = new Random();
        int j = 0;
        for (int i = 0; i < this.planes.size(); i++) {
            if (!this.planes.get(i).isEnd()){
                int loc = this.planes.get(i).canMoveTo(num, planes)[0];
                if (loc >= 0) {
                    possible_moves.put(j, loc);
                    indexToPlane.put(j, i);
                    j++;
                }
            }
        }

        if (possible_moves.size() > 0) {
            int input = r.nextInt(possible_moves.size());
            this.planes.get(indexToPlane.get(input));
            this.planes.get(indexToPlane.get(input)).move(num, planes);
        }
        return -1;
    }

    private int s2Move(int num, List<Plane> planes) {
//        System.out.println(name + " rolled a " + num);
        Map<Integer, Integer> possible_moves = new HashMap<>();
        Map<Integer, Integer> indexToPlane = new HashMap<>();
        Random r = new Random();
        int j = 0;
        for (int i = 0; i < this.planes.size(); i++) {
            if (!this.planes.get(i).isEnd()){
                int loc = this.planes.get(i).canMoveTo(num, planes)[0];
                if (loc >= 0) {
                    possible_moves.put(j, loc);
                    indexToPlane.put(j, i);
                    j++;
                }
            }
        }

        if (possible_moves.size() > 0) {
            Set<Integer> temp = new HashSet<>();
            temp.add(4); temp.add(5); temp.add(6); temp.add(7);
            for (int key : possible_moves.keySet()) {
                if (temp.contains(possible_moves.get(key))) {
                    this.planes.get(indexToPlane.get(key)).move(num, planes);
                    return -1;
                }
            }
            int input = r.nextInt(possible_moves.size());
            this.planes.get(indexToPlane.get(input)).move(num, planes);
        }
        return -1;
    }

    private int s3Move(int num, List<Plane> planes) {
//        System.out.println(name + " rolled a " + num);
        Map<Integer, Integer> possible_moves = new HashMap<>();
        Map<Integer, Integer> indexToPlane = new HashMap<>();
        Map<Integer, Integer> move_scores = new HashMap<>();
        Random r = new Random();
        int j = 0;
        for (int i = 0; i < this.planes.size(); i++) {
            if (!this.planes.get(i).isEnd()){
                int[] res = this.planes.get(i).canMoveTo(num, planes);
                if (res[0] >= 0) {
                    possible_moves.put(j, res[0]);
                    indexToPlane.put(j, i);
                    move_scores.put(j, res[1]);
                    j++;
                }
            }
        }

        if (possible_moves.size() > 0) {
            int max_score = -2;
            for (int s : move_scores.values()) {
                if (s > max_score) {
                    max_score = s;
                }
            }
            for (int key : possible_moves.keySet()) {
                if (move_scores.get(key) == max_score) {
                    this.planes.get(indexToPlane.get(key)).move(num, planes);
                    return -1;
                }
            }
        }
        return -1;
    }

    private static String printBoard(List<Plane> planes, Map<Integer, Integer> canMoveToLoc) {

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

        Set<Integer> positions = new HashSet<>();

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
                if (canMoveToLoc.containsKey(BOARD[i][j])) {
                    res = res + canMoveToLoc.get((BOARD[i][j])) + "  ";
                }
                // if this should be a plane
                else if (positions.contains(BOARD[i][j])) {
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
                                break;
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
