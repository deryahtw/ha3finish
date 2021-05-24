package htw.berlin.wi.prog2.service.parsing;

import java.util.HashMap;
import java.util.Map;

public class CountingInputParser implements ExtendableInputParser {

    @Override
    public Map<Long, Integer> idsAndCountFromInput(String inputLine, Map<String, Long> keywordsToIds) {
        inputLine = inputLine.replaceAll(",", "");
        inputLine = inputLine.replaceAll("\\.", "");
        Map<Long, Integer> ret = new HashMap<Long, Integer>();

        String[] spl = inputLine.split(" ");
        for (String s : spl) {

            for (String name : keywordsToIds.keySet()) {
                String key = name.toString();
                Long value = Long.parseLong(keywordsToIds.get(name).toString());

                if (key.equals(s)) {
                    if (ret.containsKey(value)) {
                        ret.put(value, ret.get(value) + 1);
                    } else {
                        ret.put(value, 1);
                    }
                    break;
                }

            }
        }
        return ret; // TODO hier implementieren und die korrekte Map zurückgeben
    }
}