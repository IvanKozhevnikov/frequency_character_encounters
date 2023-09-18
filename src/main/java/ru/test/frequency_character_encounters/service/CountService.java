package ru.test.frequency_character_encounters.service;

import ru.test.frequency_character_encounters.model.Input;

public interface CountService {

    void createAndSortedMap(Input symbol);

    String getTheResponse();
}
