package com.daul.struts.todoapp.action;
import com.daul.struts.todoapp.dao.ToDoItemDAO;
import com.daul.struts.todoapp.dto.ToDoItem;
import com.daul.struts.todoapp.form.ToDoForm;
import com.sun.xml.internal.fastinfoset.algorithm.BuiltInEncodingAlgorithm.WordListener;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToDoAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ToDoItemDAO dao = new ToDoItemDAO();
    	ToDoForm toDoForm = (ToDoForm) form;
    	
    	String originalStr = toDoForm.getTodo();
    	byte[] bytes = originalStr.getBytes("utf-8");
    	originalStr = new String(bytes);
/*		받아온 데이터의 데이터셋을 확인
    	String[] charSet = {"utf-8", "euc-kr", "ksc5601", "iso-8859-1", "x-windows-949"};
    	for(int i = 0; i<charSet.length; i++){
    		for(int j = 0; j<charSet.length; j++){
    			try{ 
    				System.out.println("[" + charSet[i] + "," + charSet[j] + "]" + new String(originalStr.getBytes(charSet[i]), charSet[j]));
    			} catch (UnsupportedEncodingException e){
    				e.printStackTrace();
    			}
    		}
    	}*/
    	
        // 할 일 생성 또는 업데이트에 따라 분기
        String submitType = request.getParameter("submitType");
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            if ("create".equals(submitType)) {
                // 할 일 생성 로직
            } else if ("update".equals(submitType)) {
                // 체크박스 상태 업데이트 로직
                updateToDoItemsStatus(request, dao);
            }
        }
    	
        // 할 일 생성
        if ("POST".equalsIgnoreCase(request.getMethod()) && request.getParameter("submitType").equals("create")) {
            dao.insertToDoItem(new String(originalStr.getBytes("iso-8859-1"), "utf-8"));
            toDoForm.reset(mapping, request);
        }
        
        // 할 일 상태 업데이트
        if ("POST".equalsIgnoreCase(request.getMethod()) && request.getParameter("submitType").equals("update")) {
            // 체크박스와 관련된 처리
            // 예: dao.updateIsCompleted(id, isCompleted);
            // 체크박스 상태에 따른 데이터 업데이트 로직
        }
        
        // 할 일 목록 조회
        List<ToDoItem> toDoItems = dao.getAllToDoItems();
        request.setAttribute("toDoItems", toDoItems);
        return mapping.findForward("success");
    }
    
    private void updateToDoItemsStatus(HttpServletRequest request, ToDoItemDAO dao) throws SQLException {
        // 할 일의 상태 업데이트 로직
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            if (paramName.startsWith("completed")) {
                Long id = Long.parseLong(paramName.substring("completed".length()));
                boolean isCompleted = "on".equals(request.getParameter(paramName));
                dao.updateIsCompleted(id, isCompleted);
            }
        }
    }
}