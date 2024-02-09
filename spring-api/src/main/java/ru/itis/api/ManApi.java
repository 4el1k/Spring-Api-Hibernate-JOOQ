package ru.itis.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.request.ManRequest;
import ru.itis.dto.request.WomanRequest;
import ru.itis.dto.response.ManResponse;
import ru.itis.dto.response.WomanResponse;

import java.util.Set;
import java.util.UUID;

@Api(tags = "Mans || женщины", value = "женщина")
@RequestMapping("api/v1/mans")
public interface ManApi {
    @ApiOperation(value = "Получение женщины по id" , nickname = "get-man-by-id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "мужчина получен"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ManResponse getById(@PathVariable("id") UUID id);

    @ApiOperation(value = "Получение всех студентов" , nickname = "get-all-mans")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "мужчины получены"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    Set<ManResponse> getAll();

    @ApiOperation(value = "Создание студента" , nickname = "create-man")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "мужчина создан"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void save(@RequestBody ManRequest manRequest);
    @ApiOperation(value = "Обновление студента" , nickname = "update-man")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "мужчина обновлен"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    void update(@RequestBody ManRequest manRequest);

    @ApiOperation(value = "Удаление мужчины" , nickname = "delete-man")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "мужчина удален"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable("id") UUID id);





    @ApiOperation(value = "Женидьба" , nickname = "add-woman-to-man")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Мужчина женился на женщине"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @PostMapping("/{manId}/{womanId}")
    @ResponseStatus(HttpStatus.OK)
    void addWoman(@PathVariable("manId") UUID womanId, @PathVariable("womanId") UUID manId);

    @ApiOperation(value = "Развод мужа с женой" , nickname = "delete-woman-from-man")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "мужчина развелся"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @DeleteMapping("/{manId}/{womanId}")
    @ResponseStatus(HttpStatus.OK)
    void deleteWoman(@PathVariable("manId") UUID womanId, @PathVariable("womanId") UUID manId);
}
