package ru.test.frequency_character_encounters.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.test.frequency_character_encounters.model.Input;
import ru.test.frequency_character_encounters.model.Output;
import ru.test.frequency_character_encounters.repository.MemorySymbolCounterCache;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
class SimpleCharCounterServiceImplTest {

    @Autowired
    private final ObjectMapper objectMapper;

    @Test
    public void testCreateAndSortedMap() {
        SimpleCharCounterService service = new SimpleCharCounterService(new MemorySymbolCounterCache());
        Input input = new Input();
        input.setSymbols("aaaaabccccyyyyyyyy");
        Map<Character, Long> exceptedResult = new HashMap<>();
        exceptedResult.put('y', 8L);
        exceptedResult.put('a', 5L);
        exceptedResult.put('c', 4L);
        exceptedResult.put('b', 1L);

        String expected = "\"y\": 8, \"a\": 5, \"c\": 4, \"b\": 1";
        final Output output = service.countChar(input);
        Assertions.assertEquals(exceptedResult, output);
        //        String actualResult = service.countChar(input);
//        Assertions.assertEquals(actualResult, expected);
    }

    @Test
    public void testConvertToPattern() {
        SimpleCharCounterService service = new SimpleCharCounterService(new MemorySymbolCounterCache());
        Map<Character, Long> map = Map.of('y', 8L,
                'a', 5L);
        String expected = "\"a\": 5, \"y\": 8";
        String actualResult = service.convertToPattern(map);
        Assertions.assertEquals(actualResult, expected);
    }
}