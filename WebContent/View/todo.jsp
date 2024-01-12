<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>ToDo List</title>
</head>
<body>
    <html:form action="/toDo">
        <html:text property="title"/>
        <html:submit/>
    </html:form>


    <hr/>

    <ul>
        <c:forEach var="item" items="${toDoItems}">
            <li>ID: ${item.id}, Title: ${item.title}</li>
        </c:forEach>
    </ul>
        <html:errors/>
</body>
</html>