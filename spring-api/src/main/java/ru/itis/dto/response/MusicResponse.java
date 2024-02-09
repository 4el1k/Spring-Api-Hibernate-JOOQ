package ru.itis.dto.response;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Модель для выдачи музыки")
public record MusicResponse(String authorName, String name){
}
