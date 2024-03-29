<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <title>ToDo List</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    
    <style type="text/css">
	    .completed-todo {
	    text-decoration: line-through;
	}
    </style>
    
	<script>
	var isSubmitting = false;

	function editTodo(spanElement, id) {
	    var textbox = document.getElementById('todoText' + id);
	    var submitBtn = document.getElementById('submit' + id);
	    textbox.style.display = 'inline';
	    submitBtn.style.display = 'inline';
	    textbox.focus();
	    spanElement.style.display = 'none';
	    isSubmitting = false;
	}

	function cancelEdit(textboxElement, id) {
	    setTimeout(function() {
	        if (!document.activeElement.classList.contains('submit-btn')) {
	            var spanElement = document.getElementById('todoSpan' + id);
	            var submitBtn = document.getElementById('submit' + id);
	            textboxElement.style.display = 'none';
	            submitBtn.style.display = 'none';
	            spanElement.style.display = 'inline';
	        }
	    }, 100);
	}

	function onSubmit() {
	    isSubmitting = true;
	}
	
/* 	function toggleCompleted(id, completed) {
	    var xhr = new XMLHttpRequest();
	    xhr.open("POST", "/ToDoApp_Struts/completed.do", true);
	    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	    xhr.onreadystatechange = function() {
	        if (xhr.readyState == 4 && xhr.status == 200) {
	            // 요청이 성공적으로 처리되었을 때의 로직
	            console.log("Update Completed");
	        }
	    };
	    xhr.send("todoId=" + id + "&completed=" + completed);
	} */
	
	function toggleCompleted(id, completed) {
	    var xhr = new XMLHttpRequest();
	    xhr.open("POST", "/ToDoApp_Struts/completed.do", true);
	    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	    xhr.onreadystatechange = function() {
	        if (xhr.readyState == 4 && xhr.status == 200) {
	            var todoTextElement = document.getElementById('todoSpan' + id);

	            if (completed) {
	                todoTextElement.classList.add('completed-todo');
	                todoTextElement.style.textDecoration = "line-through"; // 취소선 추가
	            } else {
	                todoTextElement.classList.remove('completed-todo');
	                todoTextElement.style.textDecoration = "none"; // 취소선 제거
	            }
	        }
	    };
	    xhr.send("todoId=" + id + "&completed=" + completed);
	}
	</script>
</head>

<body>
	<html:form action="/add" method="post">
	    <input type="text" name="todo" />
	    <input type="submit" value="추가" />
	</html:form>


	    <table border="1">
	        <tr>
	            <th>완료여부</th>
	            <th>할 일</th>
	            <th>생성일</th>
	        </tr>
			<c:forEach var="item" items="${toDoItems}" varStatus="status">
			    <tr>
			        <td>
			            <input type="checkbox" name="completed${item.id}"
			                   ${item.isCompleted == 1 ? 'checked' : ''}
			                   onchange="toggleCompleted(${item.id}, this.checked)" />
			        </td>
			        <td class="${item.isCompleted == 1 ? 'completed-todo' : ''}">
                        <!-- 수정 가능한 텍스트 박스와 기존 텍스트 뷰 -->
			            <span id="todoSpan${item.id}" onclick="editTodo(this, ${item.id})">${item.todo}</span>
                            <html:form action="/update" method="post" onsubmit="onSubmit();">
						        <input type="text" id="todoText${item.id}" name="todoText" style="display:none;" value="${item.todo}" onblur="cancelEdit(this, ${item.id})"  />
						        <input type="hidden" name="todoId" value="${item.id}" />
						        <input type="submit" id="submit${item.id}" class="submit-btn" style="display:none;" value="제출" />
						    </html:form>
			        </td>
			        <td><fmt:formatDate value="${item.regDate}" pattern="yyyy-MM-dd HH:mm"/></td>
			        <td>
			            <html:form action="/delete" method="post">
			                <input type="hidden" name="todoId" value="${item.id}" />
			                <input type="submit" value="삭제" />
			            </html:form>
			        </td>
			    </tr>
			</c:forEach>
	    </table>

    
    <html:errors/>
</body>
</html>