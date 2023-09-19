package ru.test.frequency_character_encounters.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Input {
    @NotBlank(message = "The string must not be empty")
    private String symbols;
}
