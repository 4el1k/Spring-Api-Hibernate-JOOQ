package ru.itis.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.request.AuthorRequest;
import ru.itis.dto.request.CatRequest;
import ru.itis.dto.response.AuthorResponse;
import ru.itis.dto.response.CatResponse;

import java.util.Set;
import java.util.UUID;

@Api(tags = "Cats || Коты", value = "кот")
@RequestMapping("api/v1/cats")
public interface CatApi {
    @ApiOperation(value = "Получение кота по id" , nickname = "get-cat-by-id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "кот получен"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    CatResponse getById(@PathVariable("id") UUID id);

    @ApiOperation(value = "Получение всех котов" , nickname = "get-all-cats")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "кот получен"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    Set<CatResponse> getAll();

    @ApiOperation(value = "Создание кота" , nickname = "create-cat")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "кот создан"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void save(@RequestBody CatRequest catRequest);

    @ApiOperation(value = "Обновление кота" , nickname = "update-cat")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "кот обновлен"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    void update(@RequestBody CatRequest catRequest);

    @ApiOperation(value = "Удаление кота" , nickname = "delete-cat")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "кот удален"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable("id") UUID id);
}
