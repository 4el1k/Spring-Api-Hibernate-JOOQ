package ru.itis.dto.request;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Модель для создания или изменения менеджера")
public record ManagerRequest(String selfName, String authorName, int age) {
}
