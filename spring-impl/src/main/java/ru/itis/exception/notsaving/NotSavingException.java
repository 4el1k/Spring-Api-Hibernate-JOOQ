package ru.itis.exception.notsaving;

import org.springframework.http.HttpStatus;
import ru.itis.exception.ServiceException;

public class NotSavingException extends ServiceException {
    public NotSavingException(String message) {
            super(message, HttpStatus.BAD_REQUEST);
    }
}
