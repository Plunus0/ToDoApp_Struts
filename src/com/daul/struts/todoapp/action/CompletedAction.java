package com.daul.struts.todoapp.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.daul.struts.todoapp.dao.ToDoItemDAO;

public class CompletedAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
        ToDoItemDAO dao = new ToDoItemDAO();
        
        // 폼으로부터 전달받은 id와 완료 상태를 업데이트
        
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            if (paramName.startsWith("completed")) {
                Long id = Long.parseLong(paramName.substring("completed".length()));
                boolean isCompleted = "on".equals(request.getParameter(paramName));
                dao.updateIsCompleted(id, isCompleted);
            }
        }
        
        return new ActionForward("/list.do", true);
    }
}