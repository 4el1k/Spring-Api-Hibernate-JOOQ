package ru.itis.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.request.CourseRequest;
import ru.itis.dto.request.WomanRequest;
import ru.itis.dto.response.CourseResponse;
import ru.itis.dto.response.WomanResponse;

import java.util.Set;
import java.util.UUID;

@Api(tags = "Womans || женщины", value = "женщина")
@RequestMapping("api/v1/womans")
public interface WomanApi {
    @ApiOperation(value = "Получение женщины по id" , nickname = "get-woman-by-id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "женщина получена"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    WomanResponse getById(@PathVariable("id") UUID id);

    @ApiOperation(value = "Получение всех женщин" , nickname = "get-all-womans")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "женщина получена"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    Set<WomanResponse> getAll();

    @ApiOperation(value = "Создание женщины" , nickname = "create-woman")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "женщина создана"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void save(@RequestBody WomanRequest womanRequest);
    @ApiOperation(value = "Обновление женщины" , nickname = "update-woman")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "женщина обновлена"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    void update(@RequestBody WomanRequest womanRequest);

    @ApiOperation(value = "Удаление женщины" , nickname = "delete-woman")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "женщина удалена"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable("id") UUID id);

    @ApiOperation(value = "Свадьба жены с мужем" , nickname = "add-man-to-woman")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "женщина вышла замуж"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @PostMapping("/{womanId}/{manId}")
    @ResponseStatus(HttpStatus.OK)
    void addMan(@PathVariable("womanId") UUID womanId, @PathVariable("manId") UUID manId);

    @ApiOperation(value = "Развод жены с мужом" , nickname = "delete-man-from-woman")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "женщина развелась"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @DeleteMapping("/{womanId}/{manId}")
    @ResponseStatus(HttpStatus.OK)
    void deleteMan(@PathVariable("womanId") UUID womanId, @PathVariable("manId") UUID manId);
}
