package ru.test.frequency_character_encounters.repository;

import org.springframework.stereotype.Repository;
import ru.test.frequency_character_encounters.model.Output;

import java.util.Map;

@Repository
public class MemorySymbolRepository implements SymbolRepository {

    private final Output output = new Output();

    @Override
    public void saveToStorage(Map<Character, Long> map) { ;
        output.setValue(map);
    }

    @Override
    public Output takeFromStorage() {
        return output;
    }
}
