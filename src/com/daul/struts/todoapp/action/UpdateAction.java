package com.daul.struts.todoapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.daul.struts.todoapp.dao.ToDoItemDAO;

public class UpdateAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 폼에서 전달된 수정된 할 일 내용과 ID를 가져옵니다.
        String todoText = request.getParameter("todoText");
        Long todoId = Long.valueOf(request.getParameter("todoId"));
        
        // 데이터베이스에서 해당 ID의 할 일을 찾아 내용을 업데이트합니다.
        ToDoItemDAO dao = new ToDoItemDAO();
        dao.updateTodoItem(todoId, todoText);

        return new ActionForward("/list.do", true);
    }
}
