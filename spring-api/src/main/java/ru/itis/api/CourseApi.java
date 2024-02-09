package ru.itis.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.request.CatRequest;
import ru.itis.dto.request.CourseRequest;
import ru.itis.dto.response.CatResponse;
import ru.itis.dto.response.CourseResponse;

import java.util.Set;
import java.util.UUID;

@Api(tags = "Courses || курсы", value = "курс")
@RequestMapping("api/v1/courses")
public interface CourseApi {
    @ApiOperation(value = "Получение курса по id" , nickname = "get-course-by-id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "курс получен"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    CourseResponse getById(@PathVariable("id") UUID id);

    @ApiOperation(value = "Получение всех курсов" , nickname = "get-all-courses")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "курс получен"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    Set<CourseResponse> getAll();

    @ApiOperation(value = "Создание курса" , nickname = "create-course")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "курс создан"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void save(@RequestBody CourseRequest courseRequest);
    @ApiOperation(value = "Обновление курса" , nickname = "update-course")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "курс обновлен"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    void update(@RequestBody CourseRequest courseRequest);

    @ApiOperation(value = "Удаление курса" , nickname = "delete-course")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "курс удален"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable("id") UUID id);
}
