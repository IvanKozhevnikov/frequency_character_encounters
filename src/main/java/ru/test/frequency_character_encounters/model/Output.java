package ru.test.frequency_character_encounters.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
public class Output {
    private Map<Character, Long> value;
}
