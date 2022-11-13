import java.util.ArrayList;
import java.util.List;

public class PlaneNextPositionTest {
    public static void main(String[] args) throws RuntimeException {
        List<Boolean> res = testBase();
        res.addAll(testLaunchPoint());
        res.addAll(testGeneralCase());
        res.addAll(testTurnIntoLandingArrow());
        res.addAll(testHitAndReturnLandingArrow());
        res.addAll(testJump());
        res.addAll(testFly());
        res.addAll(testLaunchPointJump());
        res.addAll(testLandingArrowJump());
        boolean pass = true;
        for (boolean b : res) {
            pass = pass && b;
        }
        System.out.println("ALL TEST CASES STATUS: " + pass);
    }


    public static List<Boolean> testBase() throws RuntimeException {
        List<Boolean> res = new ArrayList<>();
        List<Plane> planes = new ArrayList<>();
        Plane p0 = new Plane(0, 0, 0);
        Plane p1 = new Plane(0, 1, 1);
        Plane p2 = new Plane(0, 2, 2);
        Plane p3 = new Plane(0, 3, 3);

        res.add(-1 == p0.canMoveTo(1, planes)[0]);
        res.add(-1 == p0.canMoveTo(2, planes)[0]);
        res.add(-1 == p0.canMoveTo(3, planes)[0]);
        res.add(-1 == p0.canMoveTo(4, planes)[0]);
        res.add(-1 == p0.canMoveTo(5, planes)[0]);
        res.add(4 == p0.canMoveTo(6, planes)[0]);

        res.add(-1 == p1.canMoveTo(1, planes)[0]);
        res.add(-1 == p1.canMoveTo(2, planes)[0]);
        res.add(-1 == p1.canMoveTo(3, planes)[0]);
        res.add(-1 == p1.canMoveTo(4, planes)[0]);
        res.add(-1 == p1.canMoveTo(5, planes)[0]);
        res.add(5 == p1.canMoveTo(6, planes)[0]);

        res.add(-1 == p2.canMoveTo(1, planes)[0]);
        res.add(-1 == p2.canMoveTo(2, planes)[0]);
        res.add(-1 == p2.canMoveTo(3, planes)[0]);
        res.add(-1 == p2.canMoveTo(4, planes)[0]);
        res.add(-1 == p2.canMoveTo(5, planes)[0]);
        res.add(6 == p2.canMoveTo(6, planes)[0]);

        res.add(-1 == p3.canMoveTo(1, planes)[0]);
        res.add(-1 == p3.canMoveTo(2, planes)[0]);
        res.add(-1 == p3.canMoveTo(3, planes)[0]);
        res.add(-1 == p3.canMoveTo(4, planes)[0]);
        res.add(-1 == p3.canMoveTo(5, planes)[0]);
        res.add(7 == p3.canMoveTo(6, planes)[0]);

        System.out.println(res);
        return res;
    }


    public static List<Boolean> testLaunchPoint() throws RuntimeException {
        List<Boolean> res = new ArrayList<>();
        List<Plane> planes = new ArrayList<>();
        Plane p0 = new Plane(0, 4, 0);
        Plane p1 = new Plane(0, 5, 1);

        res.add(59 == p0.canMoveTo(1, planes)[0]);
        res.add(9 == p0.canMoveTo(3, planes)[0]);

        res.add(20 == p1.canMoveTo(1, planes)[0]);
        res.add(22 == p1.canMoveTo(3, planes)[0]);

        System.out.println(res);
        return res;
    }


    public static List<Boolean> testGeneralCase() throws RuntimeException {
        List<Boolean> res = new ArrayList<>();
        List<Plane> planes = new ArrayList<>();
        Plane p0 = new Plane(0, 13, 0);
        Plane p1 = new Plane(0, 45, 1);
        Plane p2 = new Plane(0, 56, 2);

        res.add(17 == p0.canMoveTo(4, planes)[0]);
        res.add(50 == p1.canMoveTo(5, planes)[0]);
        res.add(9 == p2.canMoveTo(5, planes)[0]);

        System.out.println(res);
        return res;
    }


    public static List<Boolean> testTurnIntoLandingArrow() throws RuntimeException {
        List<Boolean> res = new ArrayList<>();
        List<Plane> planes = new ArrayList<>();
        Plane p0 = new Plane(0, 55, 0);
        Plane p1 = new Plane(0, 14, 1);
        Plane p2 = new Plane(0, 30, 2);
        Plane p3 = new Plane(0, 39, 3);

        res.add(60 == p0.canMoveTo(2, planes)[0]);
        res.add(69 == p1.canMoveTo(6, planes)[0]);
        res.add(82 == p2.canMoveTo(6, planes)[0]);
        res.add(63 == p3.canMoveTo(5, planes)[0]);
        System.out.println(p2.canMoveTo(6, planes)[0]);
        System.out.println(res);
        return res;
    }


    public static List<Boolean> testHitAndReturnLandingArrow() throws RuntimeException {
        List<Boolean> res = new ArrayList<>();
        List<Plane> planes = new ArrayList<>();
        Plane p0 = new Plane(0, 72, 0);
        Plane p1 = new Plane(0, 73, 1);
        Plane p2 = new Plane(0, 78, 2);
        Plane p3 = new Plane(0, 63, 3);

        res.add(76 == p0.canMoveTo(3, planes)[0]);
        res.add(65 == p1.canMoveTo(6, planes)[0]);
        res.add(78 == p2.canMoveTo(2, planes)[0]);
        res.add(75 == p3.canMoveTo(3, planes)[0]);
        System.out.println(res);
        return res;
    }


    public static List<Boolean> testJump() throws RuntimeException {
        List<Boolean> res = new ArrayList<>();
        List<Plane> planes = new ArrayList<>();
        Plane p0 = new Plane(0, 59, 0);
        Plane p1 = new Plane(0, 48, 1);
        Plane p2 = new Plane(0, 57, 2);
        Plane p3 = new Plane(0, 14, 3);

        res.add(12 == p0.canMoveTo(1, planes)[0]);
        res.add(53 == p1.canMoveTo(1, planes)[0]);
        res.add(10 == p2.canMoveTo(1, planes)[0]);
        res.add(19 == p3.canMoveTo(1, planes)[0]);


        System.out.println(res);
        return res;
    }

    public static List<Boolean> testFly() throws RuntimeException {
        List<Boolean> res = new ArrayList<>();
        List<Plane> planes = new ArrayList<>();
        Plane p0 = new Plane(0, 19, 0);
        Plane p1 = new Plane(0, 31, 1);
        Plane p2 = new Plane(0, 45, 2);

        Plane p3 = new Plane(0, 58, 3);

        Plane p4 = new Plane(0, 36, 0);
        Plane p5 = new Plane(0, 49, 1);
        Plane p6 = new Plane(0, 10, 2);
        Plane p7 = new Plane(0, 23, 3);

        res.add(36 == p0.canMoveTo(1, planes)[0]);
        res.add(40 == p0.canMoveTo(5, planes)[0]);
        res.add(49 == p1.canMoveTo(2, planes)[0]);
        res.add(53 == p1.canMoveTo(6, planes)[0]);

        res.add(10 == p2.canMoveTo(1, planes)[0]);
        res.add(14 == p2.canMoveTo(5, planes)[0]);
        res.add(23 == p3.canMoveTo(1, planes)[0]);
        res.add(27 == p3.canMoveTo(5, planes)[0]);

        res.add(37 == p4.canMoveTo(1, planes)[0]);
        res.add(50 == p5.canMoveTo(1, planes)[0]);
        res.add(11 == p6.canMoveTo(1, planes)[0]);
        res.add(24 == p7.canMoveTo(1, planes)[0]);

        System.out.println(res);
        return res;
    }

    public static List<Boolean> testLaunchPointJump() throws RuntimeException {
        List<Boolean> res = new ArrayList<>();
        List<Plane> planes = new ArrayList<>();
        Plane p0 = new Plane(0, 4, 0);
        Plane p1 = new Plane(0, 5, 1);

        res.add(12 == p0.canMoveTo(2, planes)[0]);
        res.add(9 == p0.canMoveTo(3, planes)[0]);

        res.add(25 == p1.canMoveTo(2, planes)[0]);
        res.add(22 == p1.canMoveTo(3, planes)[0]);
        System.out.println(res);
        return res;
    }


    public static List<Boolean> testLandingArrowJump() throws RuntimeException {
        List<Boolean> res = new ArrayList<>();
        List<Plane> planes = new ArrayList<>();
        Plane p0 = new Plane(0, 55, 0);
        Plane p1 = new Plane(0, 14, 1);
        Plane p2 = new Plane(0, 28, 2);
        Plane p3 = new Plane(0, 42, 3);

        res.add(56 == p0.canMoveTo(1, planes)[0]);
        res.add(17 == p1.canMoveTo(3, planes)[0]);
        res.add(30 == p2.canMoveTo(2, planes)[0]);
        res.add(43 == p3.canMoveTo(1, planes)[0]);

        System.out.println(p0.canMoveTo(1, planes)[0]);
        System.out.println(p1.canMoveTo(3, planes)[0]);
        System.out.println(p2.canMoveTo(2, planes)[0]);
        System.out.println(p3.canMoveTo(1, planes)[0]);


        System.out.println(res);
        return res;
    }

}
