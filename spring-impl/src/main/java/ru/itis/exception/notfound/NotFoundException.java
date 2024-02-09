package ru.itis.exception.notfound;

import org.springframework.http.HttpStatus;
import ru.itis.exception.ServiceException;

public class NotFoundException extends ServiceException {
    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
