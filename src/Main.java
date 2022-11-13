public class Main {
    public static void main(String[] args) {
        Game g = new Game(1, true);
        g.getPlayers().get(0).getPlanes().get(0).move(60);
        g.getPlayers().get(0).getPlanes().get(1).move(64);
        g.getPlayers().get(0).getPlanes().get(2).move(68);
        g.getPlayers().get(0).getPlanes().get(3).move(72);
        System.out.println(g.run());
    }
}