package com.marvel.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {
    @Autowired
    CharacterRepository characterRepository;

    public List<Character> findAll() {
        return characterRepository.findAll();
    }

    public Character findUserById(Long id) {
        Optional<Character> character = characterRepository.findById(id);
        if (character.isPresent()) {
            return character.get();
        } else {
            throw new CharacterNotFoundException();
        }
    }

    public Character findCharacterByName(String name) {
        Optional<Character> character = characterRepository.findByName(name);
        if (character.isPresent()) {
            return character.get();
        } else {
            throw new CharacterNotFoundException();
        }
    }


    public Character addCharacter(Character character) {
     return characterRepository.save(character);
    }
}