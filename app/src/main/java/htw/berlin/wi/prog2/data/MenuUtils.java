package htw.berlin.wi.prog2.data;

import htw.berlin.wi.prog2.domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuUtils {

    public String ingredient;

    public void focusOnNameAndInvert() {

    }

    public static List<String> focusOnNames(Map<Long, Ingredient> articles) {
        List<String> names = new ArrayList<>();
        for (Ingredient art : articles.values())
            names.add(art.getName());
        return names;
    }

    public static Map<String, Long> focusOnNameAndInvert(Map<Long, Ingredient> articles) {

        Map<String, Long> map = new HashMap<String, Long>();

        for (Long name : articles.keySet()) {
            String key = name.toString();
            String value = articles.get(name).toString();
            map.put(value, Long.parseLong(key));
        }

        return map;
    }

    public static List<Ingredient> ingredientsFromIdAndCount(Map<Long, Integer> idsAndCount, Map<Long, Ingredient> articles) {
        ArrayList<Ingredient> list = new ArrayList<Ingredient>();

        for (Long name : idsAndCount.keySet()) {
            Long key = Long.parseLong(name.toString());
            String value = idsAndCount.get(name).toString();

            for (Long n : articles.keySet()) {

                Long k = Long.parseLong(name.toString());
                Ingredient v = articles.get(name);

                if (key == k) {
                    for (int i = 0; i < Integer.parseInt(value); i++) {
                        list.add(v);
                    }
                    break;
                }
            }
        }

        return list;
    }

}