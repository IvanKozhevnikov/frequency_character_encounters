package ru.test.frequency_character_encounters.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.test.frequency_character_encounters.model.Input;
import ru.test.frequency_character_encounters.service.SimpleCountService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CounterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private SimpleCountService countService;

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(post("/count/out")
                .param("aaaaabccccyyyyyyyy", "Куплю ладу-гранту. Дорого."))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Input> argument = ArgumentCaptor.forClass(Input.class);
        verify(countService).createAndSortedMap(argument.capture());
        assertThat(argument.getValue().getSymbols()).isEqualTo("Куплю ладу-гранту. Дорого.");
    }

    @Test
    public void givenStudents_whenGetAllStudents_thenListOfStudents() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/count/out")
                .contentType("application/json").content("aaaaabccccyyyyyyyy")

                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Input> argument = ArgumentCaptor.forClass(Input.class);
        verify(countService).createAndSortedMap(argument.capture());
        assertThat(argument.getValue().getSymbols()).isEqualTo("aaaaabccccyyyyyyyy");
    }
    }