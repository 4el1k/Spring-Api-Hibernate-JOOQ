package ru.itis.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.request.CatRequest;
import ru.itis.dto.request.GrandmotherRequest;
import ru.itis.dto.response.CatResponse;
import ru.itis.dto.response.GrandmotherResponse;

import java.util.Set;
import java.util.UUID;

@Api(tags = "Grandmothers || Бабушки", value = "бабуля")
@RequestMapping("api/v1/grandmothers")
public interface GrandmotherApi {
    @ApiOperation(value = "Получение бабули по id" , nickname = "get-cat-by-id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "бабуля получена"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    GrandmotherResponse getById(@PathVariable("id") UUID id);

    @ApiOperation(value = "Получение всех бабуль" , nickname = "get-all-cats")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "бабуля получена"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    Set<GrandmotherResponse> getAll();

    @ApiOperation(value = "Создание бабули" , nickname = "create-cat")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "бабуля создана"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void save(@RequestBody GrandmotherRequest grandmotherRequest);
    @ApiOperation(value = "Обновление бабули" , nickname = "update-cat")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "бабуля обновлена"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    void update(@RequestBody GrandmotherRequest grandmotherRequest);

    @ApiOperation(value = "Удаление бабули" , nickname = "delete-cat")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "бабуля удалена"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable("id") UUID id);

    @ApiOperation(value = "Добавление кота к бабушки" , nickname = "add-cat-to-grandmother")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Кот добавлен"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @PostMapping("/{grandmotherId}/{catId}")
    @ResponseStatus(HttpStatus.OK)
    void addCat(@PathVariable("grandmotherId") UUID grandmotherId, @PathVariable("catId") UUID catId);

    @ApiOperation(value = "Удаление кота от бабушки" , nickname = "delete-cat-from-grandmother")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Кот удален"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @DeleteMapping("/{grandmotherId}/{catId}")
    @ResponseStatus(HttpStatus.OK)
    void deleteCat(@PathVariable("grandmotherId") UUID grandmotherId, @PathVariable("catId") UUID catId);
}
