package com.codestates.soloProject.mapper;

import com.codestates.soloProject.ToDo;
import com.codestates.soloProject.dto.ToDoPatchDto;
import com.codestates.soloProject.dto.ToDoPostDto;
import com.codestates.soloProject.dto.TodoResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ToDoMapper {
    ToDo todoPostDtoToTodo(ToDoPostDto toDoPostDto);
    ToDo todoPatchDtoToTodo(ToDoPatchDto toDoPatchDto);
    TodoResponseDto todoToTodoResponseDto(ToDo todo);
    List<TodoResponseDto> todosToTodoResponseDtos(List<ToDo> todos);
}
