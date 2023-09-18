package ru.test.frequency_character_encounters.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.test.frequency_character_encounters.cache.CacheResult;
import ru.test.frequency_character_encounters.model.Input;
import ru.test.frequency_character_encounters.repository.MemorySymbolRepository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SimpleCountService {
    private final MemorySymbolRepository memorySymbolRepository;
    private CacheResult cacheResult;

    public String createAndSortedMap(Input input) {
        if(cacheResult.get(input.getSymbols()) != null)
            return convertToPattern(cacheResult.get(input.getSymbols()).getValue());
        Map<Character, Long> frequency =
                input.getSymbols().chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors
                                .groupingBy(c -> c, Collectors.counting()))
                        .entrySet().stream()
                        .sorted(Map.Entry.<Character, Long>comparingByValue()
                                .reversed().thenComparing(Map.Entry.comparingByKey()))
                        .collect(Collectors.toMap(Map.Entry::getKey,
                                Map.Entry::getValue, (a, b) -> a,
                                LinkedHashMap::new));
        memorySymbolRepository.saveToStorage(frequency);
        return convertToPattern(memorySymbolRepository.takeFromStorage().getValue());
    }

    public String getTheResponse() {
        return convertToPattern(memorySymbolRepository.takeFromStorage().getValue());
    }

    public String convertToPattern(Map<Character, Long> map) {
        return map.keySet().stream()
                .map(key -> "\"" + key + "\"" + ": " + map.get(key))
                .collect(Collectors.joining(", ", "", ""));
    }
}