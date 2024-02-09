package ru.itis.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.request.ListenerRequest;
import ru.itis.dto.response.ListenerResponse;

import java.util.Set;
import java.util.UUID;

@Api(tags = "Listeners || Слушатели", value = "слушатель")
@RequestMapping("api/v1/listeners")
public interface ListenerApi {

    @ApiOperation(value = "Получение слушателя по id" , nickname = "get-listeners-by-id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Слушатель получен"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ListenerResponse getById(@PathVariable("id") UUID id);

    @ApiOperation(value = "Получение всех слушателей" , nickname = "get-all-listeners")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Слушатели получены"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    Set<ListenerResponse> getAll();

    @ApiOperation(value = "Создание слушателя" , nickname = "create-listeners")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Слушатель создан"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void save(@RequestBody ListenerRequest listenerRequest);
    @ApiOperation(value = "Обновление слушателя" , nickname = "update-listener")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Слушатель обновлен"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    void update(@RequestBody ListenerRequest listenerRequest);

    @ApiOperation(value = "Удаление слушателя" , nickname = "delete-listener")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Слушатель удален"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable("id") UUID id);

    @ApiOperation(value = "Обновление плейлиста" , nickname = "add-music-in-listener-playlist")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Плейлист обновлен"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @PostMapping("/{listener_id}/{music_id}")
    @ResponseStatus(HttpStatus.OK)
    void updatePlaylist(@PathVariable("listener_id") UUID listenerId, @PathVariable("music_id") UUID musicId);
}
