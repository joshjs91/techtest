import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class WordFinder {

    public static final String WORD_REGEX = "[^a-zA-Z]+'?[^a-zA-Z]|[[^a-zA-Z']*]+";

    public static final int DEFAULT_WORD_LENGTH = 0;

    public Pair<Set<String>, Integer> findLongestWordInText(String text) {
        List<String> words = splitTextIntoWords(text);
        Map<Integer, Set<String>> lengthAndWords = groupWordsByLengths(words);
        Integer longestWordLength = getLongestWordLength(lengthAndWords);
        Set<String> longestWords = lengthAndWords.getOrDefault(longestWordLength, new HashSet<>());
        return new Pair<>(longestWords, longestWordLength);
    }

    public Pair<Set<String>, Integer> findShortestWordInText(String text) {
        List<String> words = splitTextIntoWords(text);
        Map<Integer, Set<String>> lengthAndWords = groupWordsByLengths(words);
        Integer shortestWordLength = getShortestWordLength(lengthAndWords);
        Set<String> shortestWords = lengthAndWords.getOrDefault(shortestWordLength, new HashSet<>());
        return new Pair<>(shortestWords, shortestWordLength);
    }

    private Integer getLongestWordLength(Map<Integer, Set<String>> lengthAndWords) {
        return lengthAndWords.keySet().stream().max(Comparator.comparingInt(Integer::intValue)).orElse(DEFAULT_WORD_LENGTH);
    }

    private Integer getShortestWordLength(Map<Integer, Set<String>> lengthAndWords) {
        return lengthAndWords.keySet().stream().min(Comparator.comparingInt(Integer::intValue)).orElse(DEFAULT_WORD_LENGTH);
    }

    private Map<Integer, Set<String>> groupWordsByLengths(List<String> words) {
        return words.stream().collect(Collectors.groupingBy(String::length, Collectors.toSet()));
    }

    private List<String> splitTextIntoWords(String text) {
        if (text == null || text.isEmpty()) {
            return new ArrayList();
        }
        List<String> words = new ArrayList<>(Arrays.asList(text.split(WORD_REGEX)));
        words.remove("");
        return words;
    }

}
