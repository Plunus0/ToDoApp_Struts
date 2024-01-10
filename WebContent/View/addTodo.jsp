<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>Add ToDo</title>
</head>
<body>
    <h2>Add New ToDo Item</h2>
    <form action="addTodo.do" method="post">
        <div>
            <label>Title:</label>
            <input type="text" name="title" />
        </div>
        <div>
            <label>Description:</label>
            <textarea name="description"></textarea>
        </div>
        <div>
            <input type="submit" value="Add"/>
        </div>
    </form>
</body>
</html>
</html>