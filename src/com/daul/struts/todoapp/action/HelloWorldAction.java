package com.daul.struts.todoapp.action;


import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.daul.struts.todoapp.form.HelloWorldForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {

        HelloWorldForm helloWorldForm = (HelloWorldForm) form;
        String message = helloWorldForm.getMessage();
        
        request.setAttribute("receivedMessage", message);

        return mapping.findForward("success");
    }
}

