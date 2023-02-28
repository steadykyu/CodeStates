package com.codestates.soloProject.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class ToDoPostDto {
    private int id;
    private String title;
    private int order;
    private boolean completed;
}
