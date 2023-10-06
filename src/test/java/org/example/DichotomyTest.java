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
    public Object[][] dataMax() {
        return new Object[][] {
                {1.0, 1.0, 0.005, new Point2D(1.0, 0.0)},
                {1.0, 2.771, 0.00005, new Point2D(1.0, 0.0)},
                {0.5, 1.0, 0.00003, new Point2D(0.5, 4.148)},
                {1.5, 2.5, 0.00005, new Point2D(2.5, -1.312)},
                {2.771, 3.0, 0.0005, new Point2D(3.0, 2.0)},
                {-1.0, 3.0, 0.00005, new Point2D(-1.0, 70.0)}
        };
    }

    @Test(dataProvider = "dataMax")
    public void testMin(double a, double b, double eps, Point2D answer) throws IllegalArgumentException {
        Point2D point = Dichotomy.max(a, b, eps);
        points.add(point);
        assertTrue(Math.abs(Dichotomy.max(a, b, eps).getX() - answer.getX()) < eps + 0.1 &&
                Math.abs(Dichotomy.max(a, b, eps).getY() - answer.getY()) < eps + 0.1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testMinException() throws IllegalArgumentException {
        Dichotomy.max(5.0, 6.0, -1);
    }

    @AfterTest
    public void printPoints() {
        for (Point2D point: points) {
            System.out.println(point);
        }
    }
}