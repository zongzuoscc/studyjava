package com.cumt.stream1;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Test2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张三，23", "李四，24", "王五，25");

        Map<String, Integer> collect = list.stream().
                filter(s -> parseInt(s.split("，")[1]) >= 24).
                collect(Collectors.
                        toMap(s -> s.split("，")[0],
                                s -> parseInt(s.split("，")[1])));
        System.out.println(collect);
    }
}
