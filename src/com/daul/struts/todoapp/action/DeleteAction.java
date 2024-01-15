package com.daul.struts.todoapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.daul.struts.todoapp.dao.ToDoItemDAO;

public class DeleteAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 할 일 ID를 가져옵니다.
        Long todoId = Long.valueOf(request.getParameter("todoId"));
        
        // 데이터베이스에서 해당 ID의 할 일을 삭제합니다.
        ToDoItemDAO dao = new ToDoItemDAO();
        dao.deleteTodoItem(todoId);

        return new ActionForward("/list.do", true);
    }
}