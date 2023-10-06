package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Double>> data = IOStreamService.getDataFromFile("data.txt");
        double a, b, eps;
        for (List<Double> list : data) {
            a = list.get(0);
            b = list.get(1);
            eps = list.get(2);
            System.out.println(Dichotomy.max(a, b, eps));
        }
    }
}
