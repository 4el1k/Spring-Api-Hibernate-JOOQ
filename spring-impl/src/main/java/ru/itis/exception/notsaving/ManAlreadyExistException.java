package ru.itis.exception.notsaving;

public class ManAlreadyExistException extends NotSavingException{
    public ManAlreadyExistException(String name) {
        super("Is entity with name = %s - already exist".formatted(name));
    }
}
