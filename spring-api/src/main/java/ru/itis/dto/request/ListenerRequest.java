package ru.itis.dto.request;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Модель для создания или изменения слушателя")
public record ListenerRequest(String name, int age) {
}
