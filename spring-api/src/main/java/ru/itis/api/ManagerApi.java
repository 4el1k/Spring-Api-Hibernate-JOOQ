package ru.itis.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.request.ManagerRequest;
import ru.itis.dto.request.MusicRequest;
import ru.itis.dto.response.ManagerResponse;
import ru.itis.dto.response.MusicResponse;

import java.util.Set;
import java.util.UUID;

@Api(tags = "Manager || менеджер", value = "менеджер")
@RequestMapping("api/v1/manager")
public interface ManagerApi {

    @ApiOperation(value = "Получение менеджера по id" , nickname = "get-manager-by-id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Менеджер получен"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ManagerResponse getById(@PathVariable("id") UUID id);

    @ApiOperation(value = "Получение всех менеджеров" , nickname = "get-all-managers")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Менеджеры получены"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    Set<ManagerResponse> getAll();

    @ApiOperation(value = "Создание менеджера" , nickname = "create-manager")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Менеджер создан"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void save(@RequestBody ManagerRequest managerRequest);
    @ApiOperation(value = "Обновление менеджера" , nickname = "update-manager")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Менеджер обновлен"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    void update(@RequestBody ManagerRequest managerRequest);

    @ApiOperation(value = "Удаление менеджера" , nickname = "delete-manager")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Менеджер удален"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable("id") UUID id);

    @ApiOperation(value = "Привязка автора к менеджеру" , nickname = "set-author-to-manager")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Автор привязан"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @PostMapping("/{managerId}/{authorId}")
    @ResponseStatus(HttpStatus.OK)
    void setAuthor(@PathVariable("managerId") UUID managerId, @PathVariable("authorId") UUID authorId);

    @ApiOperation(value = "Отвязка автора от менеджеру" , nickname = "delete-author-from-manager")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Автор отвязан"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @DeleteMapping("/{managerId}/{authorId}")
    @ResponseStatus(HttpStatus.OK)
    void deleteAuthor(@PathVariable("managerId") UUID managerId, @PathVariable("authorId") UUID authorId);
}
