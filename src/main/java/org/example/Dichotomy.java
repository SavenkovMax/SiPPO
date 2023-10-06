package org.example;

public final class Dichotomy {
    private Dichotomy() {}

    private static double function(double x) {
        return Math.pow((x-2), 4) + Math.pow((x-1), 3) - Math.pow(x, 2) + x - 1;
    }

    public static Point2D max(double a, double b, double eps) throws IllegalArgumentException {
        if (eps <= 0) {
            throw new IllegalArgumentException("The accuracy of the calculation is lower or equal to zero.");
        }
        double delta = eps / 4;
        double left = (a + b - Math.abs(a - b)) / 2;
        double right = (a + b + Math.abs(a - b)) / 2;
        double midpoint = left;
        while (Math.abs(left - right) > eps) {
            midpoint = (left + right) / 2;
            if (Double.compare(function(midpoint - delta), function(midpoint + delta)) == -1) {
                left = midpoint - delta;
            } else {
                right = midpoint + delta;
            }
        }
        return new Point2D(midpoint, function(midpoint));
    }
}
