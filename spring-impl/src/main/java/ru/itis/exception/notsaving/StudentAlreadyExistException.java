package ru.itis.exception.notsaving;

public class StudentAlreadyExistException extends NotSavingException{
    public StudentAlreadyExistException(String name) {
        super("Is entity with name = %s - already exist".formatted(name));
    }
}
