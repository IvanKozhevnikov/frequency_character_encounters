package ru.test.frequency_character_encounters.service;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.test.frequency_character_encounters.model.Input;
import ru.test.frequency_character_encounters.model.Output;
import ru.test.frequency_character_encounters.repository.MemorySymbolCounterCache;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
class SimpleCharCounterServiceImplTest {

    @Test
    public void testCreateAndSortedMap() {
        SimpleCharCounterService service = new SimpleCharCounterService(new MemorySymbolCounterCache());
        Input input = new Input();
        input.setSymbols("aaaaabccccyyyyyyyy");
        Map<Character, Long> serviceResult = new HashMap<>();
        serviceResult.put('y', 8L);
        serviceResult.put('a', 5L);
        serviceResult.put('c', 4L);
        serviceResult.put('b', 1L);

        Output expectedResult = Output.builder().value(serviceResult).build();
        final Output output = service.countChar(input);
        Assertions.assertEquals(expectedResult, output);
    }
}