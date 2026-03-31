package gcr_codebase.collectors;

import java.util.*;
import java.util.stream.Collectors;

public class WordFrequency {
    public static void main(String[] args) {

        String text = "java is fun and java is powerful";

        Arrays.stream(text.split(" "))
              .collect(Collectors.toMap(
                  word -> word,
                  word -> 1,
                  Integer::sum
              ))
              .forEach((word, count) ->
                  System.out.println(word + " : " + count)
              );
    }
}

