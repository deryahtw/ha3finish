package htw.berlin.wi.prog2.service.parsing;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;


public class TypoTolerantInputParserTest {

    private final TypoTolerantInputParser sut = new TypoTolerantInputParser();

    @Test
    public void idsAndCountFromInput() {

        // Input-Daten:
        String inputLine = "Ich hätte gerne ein Bort mit salad, Fleich und nochmal Fleisch";
        Map<String, Long> keywordsToIds = Map.of(
                "Brot", 19L,
                "brot", 19L,
                "Bort", 19L,
                "Salat", 87L,
                "salad", 87L,
                "Salt", 87L,
                "Slat", 87L,
                "Fleisch", 77L,
                "Fleish", 77L,
                "Fleich", 77L);

        Map<Long, Integer> expected = Map.of(
                19L, 1,
                87L, 1,
                77L, 2);
        Map<Long, Integer> actual = sut.idsAndCountFromInput(inputLine, keywordsToIds);

        assertEquals(expected, actual);
    }
}