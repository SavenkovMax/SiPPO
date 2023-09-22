package org.example;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.ArrayList;

public class DichotomyTest {
    private ArrayList<Point2D> points;

    @BeforeTest
    public void pointsInit() {
        points = new ArrayList<Point2D>(0);
    }

    @DataProvider
    public Object[][] dataMin() {
        return new Object[][] {
                {1.0, 1.0, 0.005, new Point2D(1.0, 0.0)},
                {-5.0, -10.0, 0.0001, new Point2D(-5.0, 2154.0)},
                {0.5, 0.8, 0.000003, new Point2D(0.8, 1.2256)},
                {1.2, 1.3, 0.0005, new Point2D(1.3, -1.12)},
                {0.0, 10000.0, 0.005, new Point2D(2.0, -2.0)},
                {0.001, 0.0001, 0.00005, new Point2D(0.0009, 14.0)}
        };
    }

    @Test(dataProvider = "dataMin")
    public void testMin(double a, double b, double eps, Point2D answer) throws IllegalArgumentException {
        Point2D point = Dichotomy.min(a, b, eps);
        points.add(point);
        assertTrue(Math.abs(Dichotomy.min(a, b, eps).getX() - answer.getX()) < eps + 0.1 &&
                Math.abs(Dichotomy.min(a, b, eps).getY() - answer.getY()) < eps + 0.1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testMinException() throws IllegalArgumentException {
        Dichotomy.min(5.0, 6.0, -1);
    }

    @AfterTest
    public void printPoints() {
        for (Point2D point: points) {
            System.out.println(point);
        }
    }
}