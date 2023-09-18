package ru.test.frequency_character_encounters.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Input {
    @NotNull(message = "Symbols must be non null")
    private String symbols;
}
