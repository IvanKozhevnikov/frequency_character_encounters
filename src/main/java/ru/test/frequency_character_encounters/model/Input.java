package ru.test.frequency_character_encounters.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

//import javax.validation.constraints.NotNull;

@Data
public class Input {
    @NotNull(message = "Symbols must be non null")
    @NotBlank
    private String symbols;
}
