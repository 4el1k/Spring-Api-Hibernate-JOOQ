package ru.itis.dto.request;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Модель для создания или изменения трека")
public record MusicRequest(String authorName, String name, String storageName) {
}
