package ru.test.frequency_character_encounters.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.test.frequency_character_encounters.model.Input;
import ru.test.frequency_character_encounters.service.SimpleCountService;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/count")
public class CounterController {
    private final SimpleCountService simpleCountService;

    @PostMapping(value = "/out")
    public ResponseEntity<String> countChars(@Valid @RequestBody Input input) {
//        if (input.getSymbols().isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
        String response = simpleCountService.createAndSortedMap(input);
        return ResponseEntity.ok().body(response);
    }
}
