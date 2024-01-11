<!-- helloWorld.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html>
<head>
    <title>Hello World</title>
</head>
<body>
    <html:form action="/helloWorld">
        <html:text property="message"/>
        <html:submit/>
    </html:form>
</body>
</html>
