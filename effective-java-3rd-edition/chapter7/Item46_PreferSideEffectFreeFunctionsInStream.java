package chapter7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * <b>Item 46 : Prefer side-effect-free functions in streams</b>
 * <p>Why ?</p>
 * <ul>
 *     <li>This is the essence of programming stream pipelines</li>
 * </ul>
 * <p>Why Not ?</p>
 * <ul>
 *     <li></li>
 * </ul>
 * <p>Things to remember</p>
 * <ul>
 *     <li>A <b>pure function</b> : the result depends only on the input not on any state, it also doesn't update a state</li>
 *     <li>The <code>forEach</code> operation should be used only to report the result, not to compute it</li>
 * </ul>
 */
public class Item46_PreferSideEffectFreeFunctionsInStream {

    public static void main(String[] args) {
        badSmellUseOfStreams();
        rewriteWithProperUseOfStreams();
    }

    private static void badSmellUseOfStreams() {
        Map<Character, Set<String>> groupedByFirstCharacter = new HashMap<>();
        try (Stream<String> words = new Scanner("ab\nac\nba\n").tokens()) {
            //modify the state of the map -> not a pure function this is bad smell, it should exists a better way to write
            //this with streams
            words.forEach(word -> groupedByFirstCharacter
                    .computeIfAbsent(word.charAt(0), (unused) -> new HashSet<>()).add(word));
        }
        System.out.println(groupedByFirstCharacter);
    }

    private static void rewriteWithProperUseOfStreams() {
        Map<Character, Set<String>> groupedByFirstCharacter;
        try (Stream<String> words = new Scanner("ab\nac\nba\n").tokens()) {
            //modify the state of the map -> not a pure function this is bad smell, it should exists a better way to write
            //this with streams
            groupedByFirstCharacter = words
                    .collect(groupingBy(word -> word.charAt(0), toSet()));
        }
        System.out.println(groupedByFirstCharacter);
    }

}
