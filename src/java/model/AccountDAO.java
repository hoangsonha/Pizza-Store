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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class AccountDAO {
    private final static String GET_ALL_ACCOUNT = "select AccountID, UserName, Password, fullName, type from account";
    private final static String INSERT_ACCOUNT = "insert into account values(?,?,?,?,?)";
    private final static String GET_ACCOUNT_BY_ID = "select UserName, Password, fullName, type from account where AccountID=?";
    private final static String UPDATE_ACCOUNT = "update account set UserName=?, Password=?, fullName=?, type=? where AccountID=?";
    private final static String DELETE_ACCOUNT = "delete account where AccountID=?";
    private final static String CHECK_EXIST = "select accountID from account where AccountID=?";
    
    public List<Account> getAllAccount() throws SQLException {
        List<Account> lists = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(GET_ALL_ACCOUNT);
                rs = ps.executeQuery();
                while(rs.next()) {
                     String accountID = rs.getString("accountID");
                     String UserName = rs.getString("UserName");
                     String password = rs.getString("Password");
                     String fullName = rs.getString("fullName");
                     int type = rs.getInt("type");
                     Account account = new Account(accountID, UserName, password, fullName, type);
                     lists.add(account);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(rs!=null) rs.close();
            if(ps!=null) ps.close();
            if(conn!=null) conn.close();
        }
        return lists;
    }

    public boolean insert(String accountID, String userName, String password, String fullName, int type) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(INSERT_ACCOUNT);
                ps.setString(1, accountID);
                ps.setString(2, userName);
                ps.setString(3, password);
                ps.setString(4, fullName);
                ps.setInt(5, type);
                check = ps.executeUpdate() > 0 ? true : false;
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(ps!=null) ps.close();
            if(conn!=null) conn.close();
        }
        return check;
    }

    public Account getAccountByAccountID(String accountID) throws SQLException {
        Account acc = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(GET_ACCOUNT_BY_ID);
                ps.setString(1, accountID);
                rs = ps.executeQuery();
                while(rs.next()) {
                     String UserName = rs.getString("UserName");
                     String password = rs.getString("Password");
                     String fullName = rs.getString("fullName");
                     int type = rs.getInt("type");
                     acc = new Account(accountID, UserName, password, fullName, type);
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

    public boolean update(String accountID, String userName, String password, String fullName, int type) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(UPDATE_ACCOUNT);               
                ps.setString(1, userName);
                ps.setString(2, password);
                ps.setString(3, fullName);
                ps.setInt(4, type);
                ps.setString(5, accountID);
                check = ps.executeUpdate() > 0 ? true : false;
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(ps!=null) ps.close();
            if(conn!=null) conn.close();
        }
        return check;
    }

    public boolean delete(String accountID) throws SQLException {
         boolean check = false;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(DELETE_ACCOUNT);               
                ps.setString(1, accountID);
                check = ps.executeUpdate() > 0 ? true : false;
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(ps!=null) ps.close();
            if(conn!=null) conn.close();
        }
        return check;
    }
    
    public boolean checkExist(String accountID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(CHECK_EXIST);
                ps.setString(1, accountID);
                rs = ps.executeQuery();
                if(rs.next()) {
                    String userName = rs.getString("accountID");
                    if(userName != null) {
                        check = true;
                    }
                }  
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(rs!=null) rs.close();
            if(ps!=null) ps.close();
            if(conn!=null) conn.close();
        }
        return check;
    }
    
}
