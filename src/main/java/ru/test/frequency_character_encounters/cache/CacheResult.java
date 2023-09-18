package ru.test.frequency_character_encounters.cache;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.test.frequency_character_encounters.model.Output;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class CacheResult {

    private final Map<String, Output> cache = new HashMap<>();

    public void add(String symbols, Output result){
        cache.put(symbols, result);
    }

    public Output get(String symbols){
        return cache.containsKey(symbols) ? cache.get(symbols) : null;
    }
}
