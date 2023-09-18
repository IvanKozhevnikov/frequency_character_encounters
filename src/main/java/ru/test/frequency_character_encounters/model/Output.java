package ru.test.frequency_character_encounters.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class Output {
    private Map<Character, Long> value;
}
