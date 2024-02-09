package ru.itis.dto.response;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Модель для выдачи Author")
public record AuthorResponse(String name, int age) {
}
