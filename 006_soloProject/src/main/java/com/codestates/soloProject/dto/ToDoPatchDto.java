package com.codestates.soloProject.dto;

import lombok.Getter;

@Getter
public class ToDoPatchDto {
    private int id;
    private String title;
    private int order;
    private boolean completed;
}
