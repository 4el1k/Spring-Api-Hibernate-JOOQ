package ru.itis.dto.request;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Модель для создания или изменения автора")
public record AuthorRequest(String name, int age) {
}
