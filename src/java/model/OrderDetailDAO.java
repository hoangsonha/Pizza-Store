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
public class OrderDetailDAO {
    private final static String ADD = "insert into OrderDetails values(?,?,?,?)";
    private final static String GET_QUANTITY_TODAY = "select sum(od.Quantity) as gg from OrderDetails od, Orders o where o.OrderID = od.OrderID and o.OrderDate=?";
    private final static String GET_TOTAL_PRICE = "select sum(od.UnitPrice) as gg from OrderDetails od";
    
    public boolean add(int orderID, String productID, double unitPrice, int quantity) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(ADD);
                ps.setInt(1, orderID);
                ps.setString(2, productID);
                ps.setDouble(3, unitPrice);
                ps.setInt(4, quantity);
                check = ps.executeUpdate() > 0 ? true : false;
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(ps!=null) ps.close();
            if(conn!=null)conn.close();
        }
        
        return check;
    }
    
    public int getSaleQuantity(String today) throws SQLException {
        int check = 0;  
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(GET_QUANTITY_TODAY);
                ps.setString(1, today);
                rs = ps.executeQuery();
                if(rs.next()) {
                    check = rs.getInt("gg");
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(rs!=null) rs.close();
            if(ps!=null) ps.close();
            if(conn!=null)conn.close();
        }
        
        
        return check;
    }
    
     public int getTotalPrice() throws SQLException {
        int check = 0;  
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(GET_TOTAL_PRICE);
                rs = ps.executeQuery();
                if(rs.next()) {
                    check = rs.getInt("gg");
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(rs!=null) rs.close();
            if(ps!=null) ps.close();
            if(conn!=null)conn.close();
        } 
        return check;
    }
}
