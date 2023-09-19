package ru.test.frequency_character_encounters.service;

import ru.test.frequency_character_encounters.model.Input;
import ru.test.frequency_character_encounters.model.Output;

public interface CharCounterService {

    Output countChar(Input symbol);
}
