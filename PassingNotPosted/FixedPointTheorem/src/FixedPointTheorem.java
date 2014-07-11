public class FixedPointTheorem {

    public static void main(String[] args) {

        FixedPointTheorem t = new FixedPointTheorem();
        System.out.println(t.cycleRange(3.55));
    }

    private static double fnct(double R, double X) {

        return R * X * (1 - X);
    }

    public double cycleRange(double R) {

        double X = 0.25;

        for (int i = 0; i < 199999; i++) {
            X = fnct(R, X);
        }

        X = fnct(R, X);

        double h = X;
        double l = X;

        for (int i = 0; i < 1000; i++) {
            X = fnct(R, X);
            if (X > h) { h = X; }
            if (X < l) { l = X; }
        }

        return h - l;
    }
}
