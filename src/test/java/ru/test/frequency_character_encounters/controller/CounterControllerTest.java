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
        mockMvc.perform(MockMvcRequestBuilders
                .post("/count/out")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"symbols\":\"aaaaabccccyyyyyyyy\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("\"y\": 8, \"a\": 5, \"c\": 4, \"b\": 1"));
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
        mockMvc.perform(MockMvcRequestBuilders
                .post("/count/out")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"symbols\":\"a\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("\"a\": 1"));
    }

    @Test
    public void whenStatusOkAndOnlyNumbersAndResultSortedDescendingOrder() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/count/out")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"symbols\":\"555557777777333\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("\"7\": 7, \"5\": 5, \"3\": 3"));
    }

    @Test
    public void whenStatusOkAndOnlySymbolsAndResultSortedDescendingOrder() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/count/out")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"symbols\":\"???%%%%::#####$$$$$$$$************\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("\"*\": 12, \"$\": 8, \"#\": 5, \"%\": 4, \"?\": 3, \":\": 2"));
    }
    @Test
    public void whenStatusOkAndOnlySymbolsAndResultSortedDescendingOrde() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/count/out")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"symbols\":\"???%%%%::#####$$$$$$$$************\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("\"*\": 12, \"$\": 8, \"#\": 5, \"%\": 4, \"?\": 3, \":\": 2"));
    }

}