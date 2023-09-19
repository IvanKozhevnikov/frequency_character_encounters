package ru.test.frequency_character_encounters.repository;

import ru.test.frequency_character_encounters.model.Output;

import java.util.Map;
import java.util.Optional;

public interface SymbolCounterCache {

    void addToCache(String symbols, Output output);

    Output getFromCache(String symbols);

    Boolean checkCache(String symbols);
}
