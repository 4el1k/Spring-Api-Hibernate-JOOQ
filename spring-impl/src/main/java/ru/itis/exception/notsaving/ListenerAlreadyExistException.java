package ru.itis.exception.notsaving;

public class ListenerAlreadyExistException extends NotSavingException{
    public ListenerAlreadyExistException(String name) {
        super("Listener with name = %s - already exist".formatted(name));
    }
}
