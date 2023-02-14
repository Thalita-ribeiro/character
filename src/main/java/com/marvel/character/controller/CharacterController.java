package com.marvel.character.controller;

import com.marvel.character.exception.CharacterNotFoundException;
import com.marvel.character.service.CharacterService;
import com.marvel.character.entity.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    @GetMapping
    public List<Character> getAllCharacters() {
        List<Character> character = characterService.findAll();
        return character;
    }

    @GetMapping("/{id}")
    public Character getAllCharactersId(@PathVariable("id") Long id) {
        Character character = characterService.findUserById(id);
        if (character == null) {
            throw new CharacterNotFoundException();
        }
        return character;
    }

    @GetMapping("/api/characters/{name}")
    public Character getCharacterByName(@PathVariable("name") String name) {
        Character character = characterService.findCharacterByName(name);
        if (character == null) {
            throw new CharacterNotFoundException();
        }
        return character;
    }

    @PostMapping
    public ResponseEntity<Character> addCharacter(@Valid @RequestBody Character character, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Character newCharacter = characterService.addCharacter(character);
        return new ResponseEntity<>(newCharacter, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Character> deleteCharacter(@PathVariable Long id) {
        try {
            Character deletedCharacter = characterService.deleteCharacter(id);
            return ResponseEntity.noContent().build();
        } catch (CharacterNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}

