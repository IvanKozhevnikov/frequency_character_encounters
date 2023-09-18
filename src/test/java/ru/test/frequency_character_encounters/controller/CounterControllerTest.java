package ru.test.frequency_character_encounters.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.test.frequency_character_encounters.Main;
import ru.test.frequency_character_encounters.model.Input;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
class CounterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private Input input;

    @Test
    public void createEmployeeAPI() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/count/out")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"symbols\":\"aaaaabccccyyyyyyyy\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
//                .andExpect(MockMvcResultMatchers.jsonPath("\"y\": 8, \"a\": 5, \"c\": 4, \"b\": 1").value(8))
//                .andExpect(MockMvcResultMatchers.jsonPath("a").value(5));
    }
////    @Test
////    public void givenStudents_whenGetAllStudents_thenListOfStudents() throws Exception {
////        this.mockMvc.perform(MockMvcRequestBuilders.post("/count/out")
////                .contentType("application/json").content("aaaaabccccyyyyyyyy")
////
////                .andExpect(status().is3xxRedirection());
////        ArgumentCaptor<Input> argument = ArgumentCaptor.forClass(Input.class);
////        verify(countService).createAndSortedMap(argument.capture());
////        assertThat(argument.getValue().getSymbols()).isEqualTo("aaaaabccccyyyyyyyy");
////    }

}