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
    
    public void insertToDoItem(String title) throws SQLException {
        String sql = "INSERT INTO TODOITEM (id, title) VALUES (todoitem_seq.NEXTVAL, ?)";
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.executeUpdate();
        }
    }

    public List<ToDoItem> getAllToDoItems() throws SQLException {
        List<ToDoItem> toDoItems = new ArrayList<>();
        String sql = "SELECT * FROM TODOITEM";
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                ToDoItem item = new ToDoItem();
                item.setId(rs.getLong("id"));
                item.setTitle(rs.getString("title"));
                toDoItems.add(item);
            }
        }
        return toDoItems;
    }
}
