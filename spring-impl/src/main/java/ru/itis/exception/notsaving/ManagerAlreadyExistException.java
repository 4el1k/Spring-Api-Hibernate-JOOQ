package ru.itis.exception.notsaving;

public class ManagerAlreadyExistException extends NotSavingException{
    public ManagerAlreadyExistException(String name) {
        super("Manager with name = %s - already exist".formatted(name));
    }
}
