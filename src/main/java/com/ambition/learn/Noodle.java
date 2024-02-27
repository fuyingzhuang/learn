package com.ambition.learn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Noodle {
    List<String> words =
            Arrays.asList("straw man", "Straw hat", "last straw", "drinking straw", "Straw", "strah brah");

    public String lambdaFilter(String filterString) {
        return words.stream()
                .filter(s -> s.length() >= filterString.length() && s.substring(0, filterString.length()).equalsIgnoreCase(filterString))
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        Noodle noodle = new Noodle();
        String allStraws = noodle.lambdaFilter("Straw");
        System.out.println(allStraws);
    }
}
