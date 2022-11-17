import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        sim();
    }

    private static void sim() {

        int[] strategies = {1, 2, 3, 4, 5, 6};
        int[] priorityMoveFromBases = {0, 7, 11, 11, 23, 23};
        int[] priorityAttacks = {0, 0, 0, 12, 12, 24};

        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                try {
                    FileWriter myWriter = new FileWriter("data/double-s" + i + "s" + j + ".csv");
                    long startTime = System.nanoTime();
                    for (int k = 0; k < 100; k++) {
                        Game g = new Game(2, true, strategies[i - 1], strategies[j - 1],
                                priorityMoveFromBases[i - 1], priorityMoveFromBases[j - 1], priorityAttacks[i - 1], priorityAttacks[j - 1]);
                        myWriter.write(g.run() + "\n");
                    }
                    long endTime = System.nanoTime();

                    long duration = (endTime - startTime);

                    System.out.println("======");
                    System.out.println(duration / 1000000  + " ms");
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
        }
    }

}