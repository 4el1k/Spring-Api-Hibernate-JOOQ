package ru.itis.exception.notsaving;

public class MusicAlreadyExistException extends NotSavingException{
    public MusicAlreadyExistException(String name) {
        super("Music with name = %s - already exist".formatted(name));
    }
}
