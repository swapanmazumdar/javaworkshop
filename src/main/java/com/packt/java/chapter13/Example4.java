package com.packt.java.chapter13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.List.copyOf;

public class Example4 {
    public static void main(String[] args) {
        List<Tire> tires = List.of(
                new Tire(17),
                new Tire(11),
                new Tire(18),
                new Tire(14),
                new Tire(15),
                new Tire(16)
        );

        //Comparator<Tire> sortDesc = (t1, t2) -> t2.size - t1.size;
        //Comparator<Tire> sortAsc = (t1, t2) -> t1.size - t2.size;

        List<Tire> sorted = getSortedList(tires);
        //sorted.sort(sortDesc);
        System.out.println(sorted);
        //sorted.sort(sortAsc);
    }

    static List<Tire> getSortedList(List<Tire> tires) {
        List<Tire> newList = new ArrayList<>(tires);
        newList.sort((t1, t2) -> t2.size - t1.size);
        return List.copyOf(newList);
    }

    public static final class Tire {
        private final int size;

        public Tire(int size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return String.valueOf(this.size);
        }
    }
}
