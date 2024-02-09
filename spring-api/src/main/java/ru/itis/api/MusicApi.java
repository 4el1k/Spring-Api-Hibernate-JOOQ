package ru.itis.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.request.ListenerRequest;
import ru.itis.dto.request.MusicRequest;
import ru.itis.dto.response.ListenerResponse;
import ru.itis.dto.response.MusicResponse;

import java.util.Set;
import java.util.UUID;

@Api(tags = "Musics || музыка", value = "музыка")
@RequestMapping("api/v1/musics")
public interface MusicApi {

    @ApiOperation(value = "Получение трека по id" , nickname = "get-music-by-id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Трек получен"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    MusicResponse getById(@PathVariable("id") UUID id);

    @ApiOperation(value = "Получение всех треков" , nickname = "get-all-musics")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Треки получены"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    Set<MusicResponse> getAll();

    @ApiOperation(value = "Создание трека" , nickname = "create-music")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "трек создан"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void save(@RequestBody MusicRequest musicRequest);
    @ApiOperation(value = "Обновление слушателя" , nickname = "update-track")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Трек обновлен"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    void update(@RequestBody MusicRequest musicRequest);

    @ApiOperation(value = "Удаление трека" , nickname = "delete-music")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Трек удален"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable("id") UUID id);
}
