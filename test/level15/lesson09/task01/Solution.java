package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static{
    labels.put(3.14, "pi");
    labels.put(50.01, "Gcq");
    labels.put(52.01, "Gcw");
    labels.put(56.01, "Gce");
    labels.put(57.01, "Gcr");
    }


    public static void main(String[] args) {
        System.out.println(labels);
    }
}
