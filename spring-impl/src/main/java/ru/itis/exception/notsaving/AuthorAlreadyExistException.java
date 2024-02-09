package ru.itis.exception.notsaving;

public class AuthorAlreadyExistException extends NotSavingException{
    public AuthorAlreadyExistException(String name) {
        super("Author with name = %s - already exist".formatted(name));
    }
}
