package ru.test.frequency_character_encounters.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.test.frequency_character_encounters.Main;
import ru.test.frequency_character_encounters.model.Output;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
class CounterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void whenStatusOkAndOnlyLettersAndResultSortedDescendingOrder() throws Exception {
        Map<Character, Long> serviceResult = new HashMap<>();
        serviceResult.put('y', 8L);
        serviceResult.put('a', 5L);
        serviceResult.put('c', 4L);
        serviceResult.put('b', 1L);
        Output expectedResult = Output.builder().value(serviceResult).build();
        mockMvc.perform(MockMvcRequestBuilders
                .post("/count/out")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"symbols\":\"aaaaabccccyyyyyyyy\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedResult)));
    }

    @Test
    public void whenStatusBadRequestAndTurnsOutAnswerEmpty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/count/out")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content()
                        .string("[{\"symbols\":\"The"
                                + " string must not be empty. Actual value: null\"}]"));
    }

    @Test
    public void whenNoRequestBodyStatusBadRequestAndTurnsOutAnswerEmpty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/count/out")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"symbols\":\"\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content()
                        .string("[{\"symbols\":\"The"
                                + " string must not be empty. Actual value: \"}]"));
    }

    @Test
    public void whenStatusOkAndOneCharacter() throws Exception {
        Map<Character, Long> serviceResult = new HashMap<>();
        serviceResult.put('a', 1L);
        Output expectedResult = Output.builder().value(serviceResult).build();
        mockMvc.perform(MockMvcRequestBuilders
                .post("/count/out")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"symbols\":\"a\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedResult)));
    }

    @Test
    public void whenStatusOkAndOnlyNumbersAndResultSortedDescendingOrder() throws Exception {
        Map<Character, Long> serviceResult = new HashMap<>();
        serviceResult.put('7', 7L);
        serviceResult.put('5', 5L);
        serviceResult.put('3', 3L);
        Output expectedResult = Output.builder().value(serviceResult).build();
        mockMvc.perform(MockMvcRequestBuilders
                .post("/count/out")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"symbols\":\"555557777777333\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedResult)));
    }

    @Test
    public void whenStatusOkAndOnlySymbolsAndResultSortedDescendingOrder() throws Exception {
        Map<Character, Long> serviceResult = new HashMap<>();
        serviceResult.put('*', 12L);
        serviceResult.put('$', 8L);
        serviceResult.put('#', 5L);
        serviceResult.put('%', 4L);
        serviceResult.put('?', 3L);
        serviceResult.put(':', 2L);
        Output expectedResult = Output.builder().value(serviceResult).build();
        mockMvc.perform(MockMvcRequestBuilders
                .post("/count/out")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"symbols\":\"???%%%%::#####$$$$$$$$************\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedResult)));
    }
}