package ru.test.frequency_character_encounters.repository;

import ru.test.frequency_character_encounters.model.Output;

import java.util.Map;

public interface SymbolRepository {

    void saveToStorage(Map<Character, Long> map);

    Output takeFromStorage();
}
