package stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class ComparatorExample {
    public static void main(String[] args) {
        Stream<String[]> stringArraysStream = Stream.of(
                new String[]{"hello", "world", "java"},
                new String[]{"code", "states"});

        stringArraysStream.flatMap(Arrays::stream).forEach(System.out::println);
    }
}
