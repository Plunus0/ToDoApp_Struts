package com.daul.struts.todoapp.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToDoForm extends ActionForm {
    private String todo;
    
    //submit 후 textbox내 데이터 리셋
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.todo = "";
    }
    
/*    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();

        if (todo == null || todo.trim().isEmpty()) {
            errors.add("todo", new ActionMessage("error.todo.required"));
        }

        return errors;
    }*/
}
