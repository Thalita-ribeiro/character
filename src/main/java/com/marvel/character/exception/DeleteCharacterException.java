package com.marvel.character.exception;

import com.marvel.character.entity.Character;

public class DeleteCharacterException extends Character {

    private static final String MESSAGE = "Character successfully deleted";

    private Long id;

    public DeleteCharacterException(Long id) {
        super();
        this.id = id;
    }

    public String getMessage() { return MESSAGE; }

    public Long getId() { return id; }
}
