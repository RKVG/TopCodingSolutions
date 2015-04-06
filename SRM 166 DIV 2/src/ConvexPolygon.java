public class ConvexPolygon {

    public double findArea(int[] x, int[] y)  {

        double area = 0.0;

        /*
        * Sum the areas of the triangles {0,1,2}, {0,2,3}, ... {0,n-1,n}
        */
        for (int v = 2; v < x.length; v++)  {
            area += areaOfTriangle(x[0], y[0], x[v-1], y[v-1], x[v], y[v]);
        }

        return area;
    }

    /*
    * Given the coordinates of the three vertices, the area of a triangle is
    * given by:
    *
    * area = abs((X1(Y2-Y3) + X2(Y3 - Y1) + X3(Y1-Y2)) / 2)
    *
    */
    private double areaOfTriangle(int x1, int y1,
                                  int x2, int y2,
                                  int x3, int y3) {

        double term1 = x1 * (y2 - y3);
        double term2 = x2 * (y3 - y1);
        double term3 = x3 * (y1 - y2);

        double result = (term1 + term2 + term3) / 2.0;

        return Math.abs(result);

    }

}
