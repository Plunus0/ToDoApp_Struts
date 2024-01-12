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
    private String title;
    
    //submit 후 textbox내 데이터 리셋
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.title = "";
    }
    
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();

        if (title == null || title.trim().isEmpty()) {
            errors.add("title", new ActionMessage("내용을 입력하세요."));
        }

        return errors;
    }
}
