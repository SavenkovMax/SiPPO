package org.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.testng.Assert.*;

public class IOStreamServiceTest {

    @DataProvider
    public Object[][] dataFile() {
        ArrayList<Double> arr = new ArrayList<>(List.of(3.0, 0.0, 0.0005));
        ArrayList<Double> arr2 = new ArrayList<>(List.of(5.0, 4.0, 0.0003));
        ArrayList<Double> arr3 = new ArrayList<>(List.of(0.4, 0.999, 0.001));
        ArrayList<Double> arr4 = new ArrayList<>(List.of(1.1, 4.3, 0.005));
        LinkedList<ArrayList<Double>> list1 = new LinkedList<>(List.of(arr, arr2, arr3));
        LinkedList<ArrayList<Double>> list2 = new LinkedList<>(List.of(arr4));
        LinkedList<ArrayList<Double>> list3 = new LinkedList<>();

        return new Object[][] {
                {"data.txt", list1},
                {"data1.txt", list2},
                {"empty.txt", list3}
        };
    }

    @Test(dataProvider = "dataFile")
    public void testGetDataFromFile(String path, List<List<Double>> answer) {
        List<List<Double>> list = IOStreamService.getDataFromFile(path);
        assertEquals(list, answer);
    }
}