package ru.itis.dto.response;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Модель для выдачи менеджера")
public record ManagerResponse(String selfName, String authorName, int age) {
}
