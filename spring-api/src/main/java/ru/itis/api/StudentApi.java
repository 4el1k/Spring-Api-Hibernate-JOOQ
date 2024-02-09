package ru.itis.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.request.CourseRequest;
import ru.itis.dto.request.StudentRequest;
import ru.itis.dto.response.CourseResponse;
import ru.itis.dto.response.StudentResponse;

import java.util.Set;
import java.util.UUID;

@Api(tags = "Students || студенты", value = "студент")
@RequestMapping("api/v1/students")
public interface StudentApi {
    @ApiOperation(value = "Получение студента по id" , nickname = "get-student-by-id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "студент получен"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    StudentResponse getById(@PathVariable("id") UUID id);

    @ApiOperation(value = "Получение всех студентов" , nickname = "get-all-students")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "студенты получены"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    Set<StudentResponse> getAll();

    @ApiOperation(value = "Создание студента" , nickname = "create-student")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "студент создан"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void save(@RequestBody StudentRequest studentRequest);
    @ApiOperation(value = "Обновление студента" , nickname = "update-student")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "студент обновлен"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    void update(@RequestBody StudentRequest studentRequest);

    @ApiOperation(value = "Удаление студента" , nickname = "delete-student")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "студент удален"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable("id") UUID id);

    @ApiOperation(value = "Добавление курса к студенту" , nickname = "add-course-to-student")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Курс добавлен"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @PostMapping("/{studentId}/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    void addCourse(@PathVariable("studentId") UUID studentId, @PathVariable("courseId") UUID courseId);

    @ApiOperation(value = "Удаление курса у студента" , nickname = "delete-course-from-student")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Курс удален"),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 401, message = "Не пройдена авторизация"),
            @ApiResponse(code = 403, message = "Отказ в доступе"),
            @ApiResponse(code = 500, message = "Ведутся технические работы")
    })
    @DeleteMapping("/{studentId}/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    void deleteCourse(@PathVariable("studentId") UUID studentId, @PathVariable("courseId") UUID courseId);
}
