public class Archimedes {

    public double approximatePi(int numSides) {

        double innerAngle = 360 / (double) numSides;
        double outerAngle = (180 - innerAngle) / 2;
        double lengthOfSide = Math.cos(Math.toRadians(outerAngle));  // Don't forget to convert to Radians
        return numSides * lengthOfSide;

    }
}
