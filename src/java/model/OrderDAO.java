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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class OrderDAO {
    private final static String ADD_ORDER = "insert into Orders(AccountID, OrderDate, Status, ShipAddress) values (?,?,?,?)";
    private final static String GET_MAX_ID = "select max(OrderID) as gg from Orders";
    private final static String STATUS = "update Orders set status=? where OrderID=?";
    private final static String HISTORY = "select od.ProductID, od.Quantity, od.UnitPrice , o.OrderDate, o.Status, o.ShipAddress from OrderDetails od, Orders o where o.OrderID = od.OrderID and o.AccountID=? order by o.OrderDate desc"; 
    private final static String REPORT = "select OrderID, AccountID, OrderDate, Status, ShipAddress from Orders where OrderDate > ? and OrderDate < ? order by OrderID desc";
   
    
    public boolean add(String accID, String d, String status, String address) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(ADD_ORDER);
                ps.setString(1, accID);
                ps.setString(2, d);
                ps.setString(3, status);
                ps.setString(4, address);
                
                check = ps.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(ps!=null) ps.close();
            if(conn!=null) conn.close();
        }
        
        return check;
    }
    
    public int maxID () throws SQLException {
        int max = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(GET_MAX_ID);
                rs = ps.executeQuery();
                if(rs.next()) {
                    max = rs.getInt("gg");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(rs!=null) rs.close();
            if(ps!=null) ps.close();
            if(conn!=null) conn.close();
        }
        return max;
    }
    
    public boolean update_status(String status, int orderID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(STATUS);
                ps.setString(1, status);
                ps.setInt(2, orderID);
                check = ps.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(ps!=null) ps.close();
            if(conn!=null) conn.close();
        }
        return check;
    }
    
    public List<History> getHistory(String accountID) throws SQLException {
        List<History> his = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(HISTORY);
                ps.setString(1, accountID);
                rs = ps.executeQuery();
                while(rs.next()) {
                    String productID = rs.getString("ProductID");
                    int quantity = rs.getInt("Quantity");
                    double price = rs.getDouble("UnitPrice");
                    String orderDate = rs.getString("OrderDate");
                    String status = rs.getString("Status");
                    String address = rs.getString("ShipAddress");
                    History h = new History(productID, quantity, price, orderDate, status, address);
                    his.add(h);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(rs!=null) rs.close();
            if(ps!=null) ps.close();
            if(conn!=null) conn.close();
        }
        return his;
    }
    
    public List<Order> getReport(String start, String end) throws SQLException {
        List<Order> lists = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(REPORT);
                ps.setString(1, start);
                ps.setString(2, end);
                rs = ps.executeQuery();
                while(rs.next()) {  
                    int OrderID = rs.getInt("OrderID");
                    String AccountID = rs.getString("AccountID");
                    String orderDate = rs.getString("OrderDate");
                    String status = rs.getString("Status");
                    String address = rs.getString("ShipAddress");
                    Order o = new Order(AccountID, orderDate, status, address);
                    o.setId(OrderID);
                    lists.add(o);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(rs!=null) rs.close();
            if(ps!=null) ps.close();
            if(conn!=null) conn.close();
        }
        return lists;
    }
    
}
