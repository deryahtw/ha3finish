package htw.berlin.wi.prog2.service.parsing;

import java.util.Map;

public interface ExtendableInputParser {
    public Map<Long, Integer> idsAndCountFromInput(String inputLine, Map<String, Long> keywordsToIds);
}
