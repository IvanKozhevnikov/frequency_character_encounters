package ru.test.frequency_character_encounters.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
                .content(asJsonString(new Input("aaaaabccccyyyyyyyy")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").exists());
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
//    @Test
//    public void givenStudents_whenGetAllStudents_thenListOfStudents() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/count/out")
//                .contentType("application/json").content("aaaaabccccyyyyyyyy")
//
//                .andExpect(status().is3xxRedirection());
//        ArgumentCaptor<Input> argument = ArgumentCaptor.forClass(Input.class);
//        verify(countService).createAndSortedMap(argument.capture());
//        assertThat(argument.getValue().getSymbols()).isEqualTo("aaaaabccccyyyyyyyy");
//    }

}