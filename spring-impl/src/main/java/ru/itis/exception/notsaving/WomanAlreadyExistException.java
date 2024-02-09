package ru.itis.exception.notsaving;

public class WomanAlreadyExistException extends NotSavingException{
    public WomanAlreadyExistException(String name) {
        super("Is entity with name = %s - already exist".formatted(name));
    }
}
