package com.marvel.character;

public class CharacterNotFoundException extends RuntimeException {

    public CharacterNotFoundException() {
        super("Character not found");
    }

    public CharacterNotFoundException(String message) {
        super(message);
    }
}
