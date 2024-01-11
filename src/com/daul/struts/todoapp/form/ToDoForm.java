package com.daul.struts.todoapp.form;

import org.apache.struts.action.ActionForm;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToDoForm extends ActionForm {
    private String title;
    private String description;

}
