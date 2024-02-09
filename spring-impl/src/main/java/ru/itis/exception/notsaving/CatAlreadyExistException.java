package ru.itis.exception.notsaving;

public class CatAlreadyExistException extends NotSavingException{
    public CatAlreadyExistException(String name) {
        super("Is entity with name = %s - already exist".formatted(name));
    }
}
