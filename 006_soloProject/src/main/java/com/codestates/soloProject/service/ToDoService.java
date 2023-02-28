package com.codestates.soloProject.service;

import com.codestates.soloProject.Repository.TodoRepository;
import com.codestates.soloProject.ToDo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    private final TodoRepository todoRepository;

    public ToDoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public ToDo createTodo(ToDo todo){
        // 유효성 검증 메서드

        // db에 저장
        ToDo savedToDo = todoRepository.save(todo);

        return savedToDo;
    }

    public ToDo findTodo(int toDoId) {
        Optional<ToDo> optionalToDo = todoRepository.findById(toDoId);
        ToDo findToDo = optionalToDo.get();
        return findToDo;
    }

    public List<ToDo> findAllTodo(){
        List<ToDo> toDos = todoRepository.findAll();
        return toDos;
    }

    public ToDo updateTodo(ToDo toDo){
        Optional<ToDo> optionalToDo = todoRepository.findById(toDo.getId());
        ToDo findTodo = optionalToDo.orElseThrow();

        Optional.ofNullable(toDo.getTitle())
                .ifPresent(title -> findTodo.setTitle(title));
        Optional.ofNullable(toDo.getOrder())
                .ifPresent(order -> findTodo.setOrder(order));
        Optional.ofNullable(toDo.isCompleted())
                .ifPresent(completed -> findTodo.setCompleted(completed));

        return todoRepository.save(findTodo);
    }

    public void deleteAll(){
        todoRepository.deleteAll();
    }

    public void deleteTodo(int toDoId){
        todoRepository.deleteById(toDoId);
    }
}
