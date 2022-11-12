import java.util.ArrayList;
import java.util.List;

public class PlaneTest {
    public static void main(String[] args) throws IllegalAccessException {
        List<Boolean> res = testBase();
        res.addAll(testLaunchPoint());
        res.addAll(testGeneralCase());
        res.addAll(testTurnIntoLandingArrow());
        res.addAll(testHitAndReturnLandingArrow());

        boolean pass = true;
        for (boolean b : res) {
            pass = pass && b;
        }
        System.out.println(pass);
    }

    public static List<Boolean> testBase() throws IllegalAccessException {
        List<Boolean> res = new ArrayList<>();
        Plane p0 = new Plane(0, 0, 0);
        Plane p1 = new Plane(0, 1, 1);
        Plane p2 = new Plane(0, 2, 2);
        Plane p3 = new Plane(0, 3, 3);

        res.add(-1 == p0.canMoveTo(1));
        res.add(-1 == p0.canMoveTo(2));
        res.add(-1 == p0.canMoveTo(3));
        res.add(-1 == p0.canMoveTo(4));
        res.add(-1 == p0.canMoveTo(5));
        res.add(4 == p0.canMoveTo(6));

        res.add(-1 == p1.canMoveTo(1));
        res.add(-1 == p1.canMoveTo(2));
        res.add(-1 == p1.canMoveTo(3));
        res.add(-1 == p1.canMoveTo(4));
        res.add(-1 == p1.canMoveTo(5));
        res.add(5 == p1.canMoveTo(6));

        res.add(-1 == p2.canMoveTo(1));
        res.add(-1 == p2.canMoveTo(2));
        res.add(-1 == p2.canMoveTo(3));
        res.add(-1 == p2.canMoveTo(4));
        res.add(-1 == p2.canMoveTo(5));
        res.add(6 == p2.canMoveTo(6));

        res.add(-1 == p3.canMoveTo(1));
        res.add(-1 == p3.canMoveTo(2));
        res.add(-1 == p3.canMoveTo(3));
        res.add(-1 == p3.canMoveTo(4));
        res.add(-1 == p3.canMoveTo(5));
        res.add(7 == p3.canMoveTo(6));

        System.out.println(res);
        return res;
    }


    public static List<Boolean> testLaunchPoint() throws IllegalAccessException {
        List<Boolean> res = new ArrayList<>();
        Plane p0 = new Plane(0, 4, 0);
        Plane p1 = new Plane(0, 5, 1);

        res.add(59 == p0.canMoveTo(1));
        res.add(9 == p0.canMoveTo(3));

        res.add(20 == p1.canMoveTo(1));
        res.add(22 == p1.canMoveTo(3));

        System.out.println(res);
        return res;
    }


    public static List<Boolean> testGeneralCase() throws IllegalAccessException {
        List<Boolean> res = new ArrayList<>();
        Plane p0 = new Plane(0, 13, 0);
        Plane p1 = new Plane(0, 45, 1);
        Plane p2 = new Plane(0, 56, 2);

        res.add(17 == p0.canMoveTo(4));
        res.add(50 == p1.canMoveTo(5));
        res.add(9 == p2.canMoveTo(5));

        System.out.println(res);
        return res;
    }


    public static List<Boolean> testTurnIntoLandingArrow() throws IllegalAccessException {
        List<Boolean> res = new ArrayList<>();
        Plane p0 = new Plane(0, 55, 0);
        Plane p1 = new Plane(0, 14, 1);
        Plane p2 = new Plane(0, 30, 2);
        Plane p3 = new Plane(0, 39, 3);

        res.add(60 == p0.canMoveTo(2));
        res.add(69 == p1.canMoveTo(6));
        res.add(82 == p2.canMoveTo(6));
        res.add(63 == p3.canMoveTo(5));

        System.out.println(res);
        return res;
    }


    public static List<Boolean> testHitAndReturnLandingArrow() throws IllegalAccessException {
        List<Boolean> res = new ArrayList<>();
        Plane p0 = new Plane(0, 72, 0);
        Plane p1 = new Plane(0, 73, 1);
        Plane p2 = new Plane(0, 78, 2);
        Plane p3 = new Plane(0, 63, 3);

        res.add(76 == p0.canMoveTo(3));
        res.add(65 == p1.canMoveTo(6));
        res.add(78 == p2.canMoveTo(2));
        res.add(75 == p3.canMoveTo(3));

        System.out.println(res);
        return res;
    }

}
