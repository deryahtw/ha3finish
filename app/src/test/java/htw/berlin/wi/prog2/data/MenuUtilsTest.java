package htw.berlin.wi.prog2.data;

import htw.berlin.wi.prog2.domain.Ingredient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import htw.berlin.wi.prog2.domain.Ingredient;


import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import static org.junit.jupiter.api.Assertions.*;

public class MenuUtilsTest {

    private final Ingredient kaese = new Ingredient("Käse", new BigDecimal("0.01"), 1000);
    private final Ingredient brot = new Ingredient("Brot", new BigDecimal("0.02"), 2000);
    private final Ingredient fleisch = new Ingredient("Fleisch", new BigDecimal("0.03"), 3000);

    private final Map<Long, Ingredient> testMenu = Map.of(42L, kaese, 66L, brot, 17L, fleisch);
    private final Map<Long, Ingredient> testMenuEmpty = Map.of();

    @Test
    public void focusOnNames() {
        List<String> expected = List.of("Käse", "Brot", "Fleisch");
        List<String> actual = MenuUtils.focusOnNames(testMenu);

        List<String> expectedSorted = expected.stream().sorted().collect(Collectors.toList());
        List<String> actualSorted = actual.stream().sorted().collect(Collectors.toList());

        assertEquals(expectedSorted, actualSorted);
    }

    @Test
    public void focusOnNamesEmptyCheck() {
        List<String> expected = List.of();
        List<String> actual = MenuUtils.focusOnNames(testMenuEmpty);

        List<String> expectedSorted = expected.stream().sorted().collect(Collectors.toList());
        List<String> actualSorted = actual.stream().sorted().collect(Collectors.toList());

        assertEquals(expectedSorted, actualSorted);
    }

    @Test
    public void focusOnNameAndInvert() {
        Map<String, Long> actual = MenuUtils.focusOnNameAndInvert(testMenu);
        Map<String, Long> expected = Map.of("Käse", 42L, "Brot", 66L, "Fleisch", 17L);
        assertEquals(expected, actual);
    }

    @Test
    public void focusOnNameAndInvertEmpty() {
        Map<String, Long> actual = MenuUtils.focusOnNameAndInvert(testMenuEmpty);
        Map<String, Long> expected = Map.of();
        assertEquals(expected, actual);
    }

    @Test
    public void ingredientsFromIdAndCount() {
        Map<Long, Integer> counts = Map.of(66L, 1, 17L, 2);

        List<Ingredient> expected = List.of(brot, fleisch, fleisch);
        List<Ingredient> actual = MenuUtils.ingredientsFromIdAndCount(counts, testMenu);

        Comparator<Ingredient> byName = Comparator.comparing(Ingredient::getName);
        List<Ingredient> expectedSorted = expected.stream().sorted(byName).collect(Collectors.toList());
        List<Ingredient> actualSorted = actual.stream().sorted(byName).collect(Collectors.toList());

        assertEquals(expectedSorted, actualSorted);
    }

    @Test
    public void ingredientsFromIdAndCountEmpty() {
        Map<Long, Integer> counts = Map.of();

        List<Ingredient> expected = List.of();
        List<Ingredient> actual = MenuUtils.ingredientsFromIdAndCount(counts, testMenuEmpty);

        Comparator<Ingredient> byName = Comparator.comparing(Ingredient::getName);
        List<Ingredient> expectedSorted = expected.stream().sorted(byName).collect(Collectors.toList());
        List<Ingredient> actualSorted = actual.stream().sorted(byName).collect(Collectors.toList());

        assertEquals(expectedSorted, actualSorted);
    }
}