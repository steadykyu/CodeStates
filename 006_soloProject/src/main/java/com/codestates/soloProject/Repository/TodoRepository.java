package com.codestates.soloProject.Repository;

import com.codestates.soloProject.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<ToDo, Integer> {
//    Optional<ToDo> findById(int toDoId);
}
