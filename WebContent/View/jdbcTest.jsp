<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="JDBC.DBConnector" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JDBC연동 테스트 예제 연결1</title>
</head>
<body>
<%
	boolean connect = false;
	try {
	    Connection conn = DBConnector.getConnection();
	    if(conn != null) {
	        connect = true;
	        conn.close();
	    }
	} catch(SQLException e) {
	    e.printStackTrace();
	}
%>
<%if(connect) {%>
	JDBC 연결 성공
<%}else{ %>
	JDBC 연결 실패
<%} %>
</body>
</html>