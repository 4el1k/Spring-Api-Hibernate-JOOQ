package ru.itis.exception.notsaving;

public class GrandmotherAlreadyExistException extends NotSavingException{
    public GrandmotherAlreadyExistException(String name) {
        super("Is entity with name = %s - already exist".formatted(name));
    }
}
