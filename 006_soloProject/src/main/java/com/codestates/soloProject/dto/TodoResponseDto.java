package com.codestates.soloProject.dto;

import com.codestates.soloProject.ToDo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class TodoResponseDto {
    private int id;
    private String title;
    private int order;
    private boolean completed;
    private String url;
}
