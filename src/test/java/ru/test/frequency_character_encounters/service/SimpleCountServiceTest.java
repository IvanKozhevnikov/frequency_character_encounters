package ru.test.frequency_character_encounters.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.test.frequency_character_encounters.model.Input;
import ru.test.frequency_character_encounters.repository.MemorySymbolRepository;

import java.util.Map;

class SimpleCountServiceImplTest {

    @Test
    public void testCreateAndSortedMap() {
        SimpleCountService service = new SimpleCountService(new MemorySymbolRepository());
        Input input = new Input();
        input.setSymbols("aaaaabccccyyyyyyyy");
        String expected = "\"y\": 8, \"a\": 5, \"c\": 4, \"b\": 1";
        String actualResult = service.createAndSortedMap(input);
        Assertions.assertEquals(actualResult, expected);
    }

    @Test
    public void testConvertToPattern() {
        SimpleCountService service = new SimpleCountService(new MemorySymbolRepository());
        Map<Character, Long> map = Map.of('y', 8L,
                'a', 5L);
        String expected = "\"y\": 8, \"a\": 5";
        String actualResult = service.convertToPattern(map);
        Assertions.assertEquals(actualResult, expected);
    }
}