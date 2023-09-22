package org.example;

import java.util.*;
import java.io.*;

public final class IOStreamService {
    private IOStreamService() {}

    public static List<List<Double>> getDataFromFile(String path) {
        LinkedList<List<Double>> list = new LinkedList<>();
        Scanner scan;
        File file = new File(path);
        try {
            scan = new Scanner(file);
            while(scan.hasNextDouble())
            {
                ArrayList<Double> arr = new ArrayList<>(0);
                for(int i = 0; i < 3; ++i) {
                    arr.add(scan.nextDouble());
                }
                list.add(arr);
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        return list;
    }
}
