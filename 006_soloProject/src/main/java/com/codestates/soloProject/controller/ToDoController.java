package com.codestates.soloProject.controller;

import com.codestates.soloProject.ToDo;
import com.codestates.soloProject.dto.ToDoPatchDto;
import com.codestates.soloProject.dto.ToDoPostDto;
import com.codestates.soloProject.mapper.ToDoMapper;
import com.codestates.soloProject.service.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin
public class ToDoController {
/** Boolean test code
    @PostMapping("/boolean")
    public String postBooleanBody(@RequestBody BooleanDto booleanDto){
        System.out.println(booleanDto.isCompleted());

//        return new ResponseEntity<>(todosPostDto, HttpStatus.CREATED);
        return "OK";
    }
*/

    private final ToDoService toDoService;
    private final ToDoMapper toDoMapper;
//    private int todoOrder = 1;

    public ToDoController(ToDoService toDoService, ToDoMapper toDoMapper) {
        this.toDoService = toDoService;
        this.toDoMapper = toDoMapper;
    }

    @PostMapping
    public ResponseEntity postTodo(@Valid @RequestBody ToDoPostDto todosPostDto){
        ToDo toDo = toDoMapper.todoPostDtoToTodo(todosPostDto);
        //todo_Order 넣기
//        toDo.setTodo_order(todoOrder++);
        ToDo findTodo = toDoService.createTodo(toDo);

        return new ResponseEntity<>(toDoMapper.todoToTodoResponseDto(findTodo)
                ,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getTodos(){
        List<ToDo> allTodo = toDoService.findAllTodo();

        return new ResponseEntity<>(toDoMapper.todosToTodoResponseDtos(allTodo), HttpStatus.OK);
    }

    @GetMapping("/{todo-id}")
    public ResponseEntity getTodo(@PathVariable("todo-id") int todoId){
        ToDo findToDo = toDoService.findTodo(todoId);
        return new ResponseEntity<>(toDoMapper.todoToTodoResponseDto(findToDo), HttpStatus.OK);
    }

    @PatchMapping("/{todo-id}")
    public ResponseEntity patchTodo(@PathVariable("todo-id") int toDoId
                                    ,@RequestBody ToDoPatchDto toDoPatchDto){
        ToDo toDo = toDoMapper.todoPatchDtoToTodo(toDoPatchDto);
        toDo.setId(toDoId);

        ToDo findToDo = toDoService.updateTodo(toDo);
        return new ResponseEntity<>(toDoMapper.todoToTodoResponseDto(findToDo), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteTodos(){
        toDoService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{todo-id}")
    public ResponseEntity deleteTodo(@PathVariable("todo-id") int todoId){
        toDoService.deleteTodo(todoId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/main")
    public String helloSpring(){
        return "Hello Spring World!";
    }
}
