import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        single_1M_sim();
        play();
    }

    private static void play() {
        Game g = new Game(2, true);
        g.run();
    }

    private static void single_1M_sim() {
        try {
            FileWriter myWriter = new FileWriter("data/single-s3.csv");
            long startTime = System.nanoTime();
            for (int i = 0; i < 1000000; i++) {
                Game g = new Game(1, false);
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

//        Runtime rt = Runtime.getRuntime();
//        Process pr = rt.exec("python ./dataProcessing/histogram.py");
    }

}