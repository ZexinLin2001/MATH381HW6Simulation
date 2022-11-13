import java.util.ArrayList;
import java.util.List;

public class PlaneScoreTest {
    public static void main(String[] args) throws RuntimeException {
        List<Boolean> res = testBaseScore();
        res.addAll(testLaunchPointScore());
        res.addAll(testGeneralCaseScore());
        res.addAll(testTurnIntoLandingArrowScore());
        res.addAll(testHitAndReturnLandingArrowScore());
        res.addAll(testJumpScore());
        res.addAll(testFlyScore());
        res.addAll(testLaunchPointJumpScore());
        boolean pass = true;
        for (boolean b : res) {
            pass = pass && b;
        }
        System.out.println("ALL TEST CASES STATUS: " + pass);
    }
    public static List<Boolean> testBaseScore() throws RuntimeException {
        List<Boolean> res = new ArrayList<>();
        List<Plane> planes = new ArrayList<>();
        Plane p0 = new Plane(0, 0, 0);
        Plane p1 = new Plane(0, 1, 1);
        Plane p2 = new Plane(0, 2, 2);
        Plane p3 = new Plane(0, 3, 3);

        res.add(0 == p0.canMoveTo(1, planes)[1]);
        res.add(0 == p0.canMoveTo(2, planes)[1]);
        res.add(0 == p0.canMoveTo(3, planes)[1]);
        res.add(0 == p0.canMoveTo(4, planes)[1]);
        res.add(0 == p0.canMoveTo(5, planes)[1]);
        res.add(6 == p0.canMoveTo(6, planes)[1]);

        res.add(0 == p1.canMoveTo(1, planes)[1]);
        res.add(0 == p1.canMoveTo(2, planes)[1]);
        res.add(0 == p1.canMoveTo(3, planes)[1]);
        res.add(0 == p1.canMoveTo(4, planes)[1]);
        res.add(0 == p1.canMoveTo(5, planes)[1]);
        res.add(6 == p1.canMoveTo(6, planes)[1]);

        res.add(0 == p2.canMoveTo(1, planes)[1]);
        res.add(0 == p2.canMoveTo(2, planes)[1]);
        res.add(0 == p2.canMoveTo(3, planes)[1]);
        res.add(0 == p2.canMoveTo(4, planes)[1]);
        res.add(0 == p2.canMoveTo(5, planes)[1]);
        res.add(6 == p2.canMoveTo(6, planes)[1]);

        res.add(0 == p3.canMoveTo(1, planes)[1]);
        res.add(0 == p3.canMoveTo(2, planes)[1]);
        res.add(0 == p3.canMoveTo(3, planes)[1]);
        res.add(0 == p3.canMoveTo(4, planes)[1]);
        res.add(0 == p3.canMoveTo(5, planes)[1]);
        res.add(6 == p3.canMoveTo(6, planes)[1]);
        System.out.println(res);
        return res;
    }
    public static List<Boolean> testLaunchPointScore() throws RuntimeException {
        List<Boolean> res = new ArrayList<>();
        List<Plane> planes = new ArrayList<>();
        Plane p0 = new Plane(0, 4, 0);
        Plane p1 = new Plane(0, 5, 1);

        res.add(1 == p0.canMoveTo(1, planes)[1]);
        res.add(3 == p0.canMoveTo(3, planes)[1]);
        res.add(1 == p1.canMoveTo(1, planes)[1]);
        res.add(3 == p1.canMoveTo(3, planes)[1]);

        System.out.println(res);
        return res;
    }
    public static List<Boolean> testGeneralCaseScore() throws RuntimeException {
        List<Boolean> res = new ArrayList<>();
        List<Plane> planes = new ArrayList<>();
        Plane p0 = new Plane(0, 13, 0);
        Plane p1 = new Plane(0, 45, 1);
        Plane p2 = new Plane(0, 56, 2);

        res.add(4 == p0.canMoveTo(4, planes)[1]);
        res.add(5 == p1.canMoveTo(5, planes)[1]);
        res.add(5 == p2.canMoveTo(5, planes)[1]);
        System.out.println(res);
        return res;
    }
    public static List<Boolean> testTurnIntoLandingArrowScore() throws RuntimeException {
        List<Boolean> res = new ArrayList<>();
        List<Plane> planes = new ArrayList<>();
        Plane p0 = new Plane(0, 55, 0);
        Plane p1 = new Plane(0, 14, 1);
        Plane p2 = new Plane(0, 30, 2);
        Plane p3 = new Plane(0, 39, 3);

        res.add(2 == p0.canMoveTo(2, planes)[1]);
        res.add(4 == p1.canMoveTo(6, planes)[1]);
        res.add(1 == p2.canMoveTo(6, planes)[1]);
        res.add(5 == p3.canMoveTo(5, planes)[1]);
        System.out.println(res);
        return res;
    }
    public static List<Boolean> testHitAndReturnLandingArrowScore() throws RuntimeException {
        List<Boolean> res = new ArrayList<>();
        List<Plane> planes = new ArrayList<>();
        Plane p0 = new Plane(0, 72, 0);
        Plane p1 = new Plane(0, 73, 1);
        Plane p2 = new Plane(0, 78, 2);
        Plane p3 = new Plane(0, 63, 3);
        //test case for score = 6
        Plane p4 = new Plane(0, 72, 0);
        //test cse for score = 0 可能被攻击
        Plane p5 = new Plane(0, 65, 1);

        res.add(1 == p0.canMoveTo(3, planes)[1]);
        res.add(1 == p1.canMoveTo(6, planes)[1]);
        res.add(1 == p2.canMoveTo(2, planes)[1]);
        res.add(1 == p3.canMoveTo(3, planes)[1]);
        res.add(6 == p4.canMoveTo(2, planes)[1]);
        res.add(0 == p5.canMoveTo(1, planes)[1]);
        System.out.println(p5.canMoveTo(1, planes)[1]);
        System.out.println(res);
        return res;
    }
    public static List<Boolean> testJumpScore() throws RuntimeException {
        List<Boolean> res = new ArrayList<>();
        List<Plane> planes = new ArrayList<>();
        Plane p0 = new Plane(0, 59, 0);
        Plane p1 = new Plane(0, 48, 1);
        Plane p2 = new Plane(0, 57, 2);
        Plane p3 = new Plane(0, 14, 3);

        res.add(5 == p0.canMoveTo(1, planes)[1]);
        res.add(5 == p1.canMoveTo(1, planes)[1]);
        res.add(5 == p2.canMoveTo(1, planes)[1]);
        res.add(5 == p3.canMoveTo(1, planes)[1]);
        System.out.println(res);
        return res;
    }
    public static List<Boolean> testFlyScore() throws RuntimeException {
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

        res.add(17 == p0.canMoveTo(1, planes)[1]);
        res.add(21 == p0.canMoveTo(5, planes)[1]);
        res.add(18 == p1.canMoveTo(2, planes)[1]);
        res.add(22 == p1.canMoveTo(6, planes)[1]);

        res.add(17 == p2.canMoveTo(1, planes)[1]);
        res.add(21 == p2.canMoveTo(5, planes)[1]);
        res.add(17 == p3.canMoveTo(1, planes)[1]);
        res.add(21 == p3.canMoveTo(5, planes)[1]);

        res.add(1 == p4.canMoveTo(1, planes)[1]);
        res.add(1 == p5.canMoveTo(1, planes)[1]);
        res.add(1 == p6.canMoveTo(1, planes)[1]);
        res.add(1 == p7.canMoveTo(1, planes)[1]);
        System.out.println(res);
        return res;
    }
    public static List<Boolean> testLaunchPointJumpScore() throws RuntimeException {
        List<Boolean> res = new ArrayList<>();
        List<Plane> planes = new ArrayList<>();
        Plane p0 = new Plane(0, 4, 0);
        Plane p1 = new Plane(0, 5, 1);

        res.add(6 == p0.canMoveTo(2, planes)[1]);
        res.add(3 == p0.canMoveTo(3, planes)[1]);

        res.add(6 == p1.canMoveTo(2, planes)[1]);
        res.add(3 == p1.canMoveTo(3, planes)[1]);
        System.out.println(res);
        return res;
    }
}
