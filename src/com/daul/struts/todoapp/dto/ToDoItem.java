package com.daul.struts.todoapp.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToDoItem {
    private Long id;
    private String todo;
    private Date regDate;
    private Integer isCompleted;
}
