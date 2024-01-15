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
        String todoIdStr = request.getParameter("todoId");
        String completedStr = request.getParameter("completed");
        Long todoId = Long.parseLong(todoIdStr);
        boolean completed = Boolean.parseBoolean(completedStr);

        // 데이터베이스에서 해당 ID의 할 일을 찾아 완료 상태를 업데이트합니다.
        ToDoItemDAO dao = new ToDoItemDAO();
        dao.updateIsCompleted(todoId, completed);

        // AJAX 요청에 대한 응답
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Updated");
        return null; // AJAX 요청에는 페이지 이동이 필요 없으므로 null을 반환
    }
}