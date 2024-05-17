/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Util.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class UserDAO {
    private final static String LOGIN = "select userName, fullName, type from Account where AccountID=? and password=?";
    public Account checkLogin(String id, String password) throws SQLException {
        Account acc = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(LOGIN);
                ps.setString(1, id);
                ps.setString(2, password);
                rs = ps.executeQuery();
                while(rs.next()) {
                     String userName = rs.getString("UserName");
                     String fullName = rs.getString("FullName");
                     int type = rs.getInt("type");
                     acc = new Account(id, userName, password, fullName, type);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(rs!=null) rs.close();
            if(ps!=null) ps.close();
            if(conn!=null) conn.close();
        }
        return acc;
    }
}
