package ru.itis.exception.notsaving;

public class CourseAlreadyExistException extends NotSavingException{
    public CourseAlreadyExistException(String name) {
        super("Is entity with name = %s - already exist".formatted(name));
    }
}
