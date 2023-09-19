package ru.test.frequency_character_encounters.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
public class Output {
    private Map<Character, Long> value;
}
