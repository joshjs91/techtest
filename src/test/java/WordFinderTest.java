import static org.assertj.core.api.Assertions.assertThat;

import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class WordFinderTest {

    @Test
    void shouldReturnLongestWordAndLengthForBasicSentence() {
        WordFinder splitter = new WordFinder();
        Pair<Set<String>, Integer> longestWords = splitter.findLongestWordInText("The cow jumped over the the moon.");
        assertThat(longestWords.getValue0()).containsOnly("jumped");
        assertThat(longestWords.getValue1()).isEqualTo(6);
    }

    @Test
    void shouldReturnMultipleLongestWordsAndLengthForBasicSentence() {
        WordFinder splitter = new WordFinder();
        Pair<Set<String>, Integer> longestWords = splitter.findLongestWordInText("The cow jumped over the the moon. planet");
        assertThat(longestWords.getValue0()).containsOnly("jumped", "planet");
        assertThat(longestWords.getValue1()).isEqualTo(6);
    }

    @Test
    void shouldReturnLongestWordAndLengthForSentenceWithPunctuation() {
        WordFinder splitter = new WordFinder();
        Pair<Set<String>, Integer> longestWords = splitter.findLongestWordInText("The, cows;jumpedover ! the moon.");
        assertThat(longestWords.getValue0()).containsOnly("jumpedover");
        assertThat(longestWords.getValue1()).isEqualTo(10);
    }

    @Test
    void shouldReturnLongestWordIncludingApostrophe() {
        WordFinder splitter = new WordFinder();
        Pair<Set<String>, Integer> longestWords = splitter.findLongestWordInText("we're here");
        assertThat(longestWords.getValue0()).containsOnly("we're");
        assertThat(longestWords.getValue1()).isEqualTo(5);
    }

    @Test
    void shouldReturnEmptySetAndZeroLengthWhenNoWordExists() {
        WordFinder splitter = new WordFinder();
        Pair<Set<String>, Integer> longestWords = splitter.findLongestWordInText("?, 12 ;/ \\ \n ! .   +_)(*&^%$£@!");
        assertThat(longestWords.getValue0()).isEmpty();
        assertThat(longestWords.getValue1()).isEqualTo(0);
    }

    @Test
    void shouldReturnEmptySetAndZeroLengthWhenEmptySentence() {
        WordFinder splitter = new WordFinder();
        Pair<Set<String>, Integer> longestWords = splitter.findLongestWordInText("");
        assertThat(longestWords.getValue0()).isEmpty();
        assertThat(longestWords.getValue1()).isEqualTo(0);
    }

    @Test
    void shouldReturnEmptySetAndZeroLengthWhenNullSentence() {
        WordFinder splitter = new WordFinder();
        Pair<Set<String>, Integer> longestWords = splitter.findLongestWordInText(null);
        assertThat(longestWords.getValue0()).isEmpty();
        assertThat(longestWords.getValue1()).isEqualTo(0);
    }

    @Test
    void shouldReturnShortestWordAndLengthForBasicSentence() {
        WordFinder splitter = new WordFinder();
        Pair<Set<String>, Integer> longestWords = splitter.findShortestWordInText("The cows jumped over moon.");
        assertThat(longestWords.getValue0()).containsOnly("The");
        assertThat(longestWords.getValue1()).isEqualTo(3);
    }

    @Test
    void shouldReturnMultipleShortestWordsAndLengthForBasicSentence() {
        WordFinder splitter = new WordFinder();
        Pair<Set<String>, Integer> longestWords = splitter.findShortestWordInText("The cow jumped over the moon.");
        assertThat(longestWords.getValue0()).containsOnly("The", "the", "cow");
        assertThat(longestWords.getValue1()).isEqualTo(3);
    }

    @Test
    void shouldReturnShortestWordAndLengthForSentenceWithPunctuation() {
        WordFinder splitter = new WordFinder();
        Pair<Set<String>, Integer> longestWords = splitter.findShortestWordInText("The, cow;jumpedover ' gf ! the moon.");
        assertThat(longestWords.getValue0()).containsOnly("gf");
        assertThat(longestWords.getValue1()).isEqualTo(2);
    }

    @Test
    void shouldReturnShortestWordIncludingApostrophe() {
        WordFinder splitter = new WordFinder();
        Pair<Set<String>, Integer> longestWords = splitter.findShortestWordInText("we're h're");
        assertThat(longestWords.getValue0()).containsOnly("h're");
        assertThat(longestWords.getValue1()).isEqualTo(4);
    }

    @Test
    void shouldReturnEmptyStringAndZeroLengthWhenNoWordExists() {
        WordFinder splitter = new WordFinder();
        Pair<Set<String>, Integer> shortestWords = splitter.findShortestWordInText("?, 12 ; ! '   +_)(*&^%$£@!");
        assertThat(shortestWords.getValue0()).isEmpty();
        assertThat(shortestWords.getValue1()).isEqualTo(0);
    }

    @Test
    void shouldReturnEmptySetAndZeroLengthWhenEmptySentenceForShortestWord() {
        WordFinder splitter = new WordFinder();
        Pair<Set<String>, Integer> shortestWords = splitter.findShortestWordInText("");
        assertThat(shortestWords.getValue0()).isEmpty();
        assertThat(shortestWords.getValue1()).isEqualTo(0);
    }

    @Test
    void shouldReturnEmptySetAndZeroLengthWhenNullSentenceForShortestWord() {
        WordFinder splitter = new WordFinder();
        Pair<Set<String>, Integer> shortestWords = splitter.findShortestWordInText(null);
        assertThat(shortestWords.getValue0()).isEmpty();
        assertThat(shortestWords.getValue1()).isEqualTo(0);
    }
}
