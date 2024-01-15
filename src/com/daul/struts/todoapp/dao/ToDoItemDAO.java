package com.daul.struts.todoapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.daul.struts.todoapp.dto.ToDoItem;
import com.daul.struts.todoapp.jdbc.DBConnector;


public class ToDoItemDAO {
    
	//내용 입력
	public void insertToDoItem(String todo) throws SQLException {
	    String sql = "INSERT INTO TODOITEM (id, todo, reg_date, is_completed) "
	    		+ "VALUES (todoitem_seq.NEXTVAL, ?, SYSDATE, 0)";
	    try (Connection conn = DBConnector.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, todo);
	        pstmt.executeUpdate();
	    }
	}
	
	//목록 조회
	public List<ToDoItem> getAllToDoItems() throws SQLException {
	    List<ToDoItem> toDoItems = new ArrayList<>();
	    String sql = "SELECT * FROM TODOITEM ORDER BY reg_date DESC";
	    try (Connection conn = DBConnector.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         ResultSet rs = pstmt.executeQuery()) {
	        while (rs.next()) {
	            ToDoItem item = new ToDoItem();
	            item.setId(rs.getLong("id"));
	            item.setTodo(rs.getString("todo"));
	            item.setRegDate(rs.getDate("reg_date"));
	            item.setIsCompleted(rs.getInt("is_completed"));
	            toDoItems.add(item);
	        }
	    }
	    return toDoItems;
	}
	//완료상태 업데이트
	public void updateIsCompleted(Long id, boolean isCompleted) throws SQLException {
	    String sql = "UPDATE TODOITEM SET is_completed = ? WHERE id = ?";
	    try (Connection conn = DBConnector.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setInt(1, isCompleted ? 1 : 0);
	        pstmt.setLong(2, id);
	        pstmt.executeUpdate();
	    }
	}
	
	//내용 업데이트
	public void updateTodoItem(Long id, String todo) throws SQLException {
	    String sql = "UPDATE TODOITEM SET todo = ? WHERE id = ?";
	    try (Connection conn = DBConnector.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, todo);
	        pstmt.setLong(2, id);
	        pstmt.executeUpdate();
	    }
	}
	
	//내용 삭제
	public void deleteTodoItem(Long id) throws SQLException {
	    String sql = "DELETE FROM TODOITEM WHERE id = ?";
	    try (Connection conn = DBConnector.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setLong(1, id);
	        pstmt.executeUpdate();
	    }
	}
	
}
