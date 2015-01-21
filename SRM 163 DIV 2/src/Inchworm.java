public class Inchworm {

    public int lunchtime(int branch, int rest, int leaf) {

        int meals = 0;

        for (int p = 0; p <= branch; p += rest) {
            if ((p % leaf) == 0) meals++;
        }

        return meals;
    }
}
