package com.daul.struts.todoapp.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.daul.struts.todoapp.dao.ToDoItemDAO;
import com.daul.struts.todoapp.dto.ToDoItem;

public class ListAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
        ToDoItemDAO dao = new ToDoItemDAO();
        List<ToDoItem> toDoItems = dao.getAllToDoItems();
        request.setAttribute("toDoItems", toDoItems);
        return mapping.findForward("success");
    }
}
