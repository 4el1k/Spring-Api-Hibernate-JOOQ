package ru.itis.dto.response;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Модель для выдачи слушателя")
public record ListenerResponse(String name, int age) {
}
