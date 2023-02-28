package com.codestates.soloProject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToDo {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = true)
    private String title;
    @Column(name="todo_order", nullable = false)
    private int order;
    @Column(nullable = false)
    private boolean completed;

    @Transient
    private String url;

    public String getUrl(){
        return "http://localhost:8080/" + this.id;
    }
}
