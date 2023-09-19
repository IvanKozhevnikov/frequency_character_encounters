package ru.test.frequency_character_encounters.repository;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.test.frequency_character_encounters.model.Output;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
@NoArgsConstructor
public class MemorySymbolCounterCache implements SymbolCounterCache {

    private final Map<String, Output> cache = new HashMap<>();

    @Override
    public void addToCache(String symbols, Output output) {
        ;
        cache.put(symbols, output);
    }

    @Override
    public Output getFromCache(String symbols) {
        return cache.get(symbols);
    }

    @Override
    public Boolean checkCache(String symbols) {
        return cache.containsKey(symbols);
    }
}
