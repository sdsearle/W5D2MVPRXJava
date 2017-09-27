package com.example.admin.w5d2mvprxjava.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 9/26/2017.
 */

public class DataSource {
    public static List<Integer> getIntList(int length) {

        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            integers.add(i + 1);
        }
        return integers;

    }

}
