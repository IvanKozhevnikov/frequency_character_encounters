package ru.test.frequency_character_encounters.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.test.frequency_character_encounters.model.Input;
import ru.test.frequency_character_encounters.model.Output;
import ru.test.frequency_character_encounters.repository.MemorySymbolCounterCache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SimpleCharCounterService implements CharCounterService {
    private final MemorySymbolCounterCache memorySymbolCounterCache;

    @Override
    public Output countChar(Input input) {

        if (memorySymbolCounterCache.checkCache(input.getSymbols())) {
            return memorySymbolCounterCache.getFromCache(input.getSymbols());
        }

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

        final Output output = Output.builder().value(frequency).build();
        memorySymbolCounterCache.addToCache(input.getSymbols(), output);
        return output;
    }
}