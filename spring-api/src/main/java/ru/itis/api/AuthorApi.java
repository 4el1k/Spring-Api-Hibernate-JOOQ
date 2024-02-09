package ru.itis.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.request.AuthorRequest;
import ru.itis.dto.response.AuthorResponse;

import java.util.Set;
import java.util.UUID;

@Api(tags = "Authors || Авторы", value = "автор")
@RequestMapping("api/v1/authors")
public interface AuthorApi {

    @ApiOperation(value = "Получение автора по id" , nickname = "get-author-by-id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Автора получен"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    AuthorResponse getById(@PathVariable("id") UUID id);

    @ApiOperation(value = "Получение всех авторов" , nickname = "get-all-authors")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Авторы получены"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    Set<AuthorResponse> getAll();

    @ApiOperation(value = "Создание автора" , nickname = "create-author")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Автор создан"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void save(@RequestBody AuthorRequest authorRequest);
    @ApiOperation(value = "Обновление автора" , nickname = "update-author")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Автор обновлен"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    void update(@RequestBody AuthorRequest authorRequest);

    @ApiOperation(value = "Удаление автора" , nickname = "delete-author")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Автора удален"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable("id") UUID id);
}
