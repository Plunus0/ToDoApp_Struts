package com.daul.struts.todoapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.daul.struts.todoapp.dao.ToDoItemDAO;
import com.daul.struts.todoapp.form.ToDoForm;

public class AddAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 할 일 추가 로직
    	ToDoItemDAO dao = new ToDoItemDAO();
    	ToDoForm toDoForm = (ToDoForm) form;
    	
    	/*받아온 데이터의 데이터타입을 확인
    	String originalStr = toDoForm.getTodo();
    	byte[] bytes = originalStr.getBytes("utf-8");
    	originalStr = new String(bytes);
    	
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

        // 데이터타입 변경하여 생성하기
        //dao.insertToDoItem(new String(originalStr.getBytes("iso-8859-1"), "utf-8"));
        /* 캐릭터셋 변함없이 생성하기 */
        dao.insertToDoItem(toDoForm.getTodo());
        toDoForm.reset(mapping, request);
        
        
        return new ActionForward("/list.do", true); // 리다이렉트
    }
}
