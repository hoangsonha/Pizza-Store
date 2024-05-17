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
public class ProductDAO {
    private final static String GET_ALL_PRODUCT = "select ProductID, ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, ProductImage from products";
    private final static String SEARCH_BY_NAME = "select productID, productName, supplierID, categoryID, quantityPerUnit, unitPrice, productImage from products where productName like ?";
    private final static String SEARCH_BY_ID = "select productName, supplierID, categoryID, quantityPerUnit, unitPrice, productImage from products where productID=?";
    private final static String SEARCH_BY_PRICE = "select productID, productName, supplierID, categoryID, quantityPerUnit, productImage from products where unitPrice=?";
    private final static String SEARCH_BY_ID_RECOM = "select productID, productName, supplierID, categoryID, quantityPerUnit, unitPrice, productImage from products where productID like ?";
    private final static String SEARCH_BY_PRICE_RECOM = "select productID, productName, supplierID, categoryID, quantityPerUnit, unitPrice, productImage from products where unitPrice > ? and unitPrice < ?";
    private final static String GET_CATEGORY = "select categoryID, categoryName, description from categories";
    private final static String GET_SUPPLIER = "select SupplierID, CompanyName, Address, Phone from suppliers";
    private final static String INSERT_PRODUCT = "insert into Products values (?,?,?,?,?,?,?)";
    private final static String GET_PRODUCT_BY_ID = "select productName, supplierID, categoryID, quantityPerUnit, unitPrice, productImage from products where productID=?";
    private final static String UPDATE_PRODUCT = "update Products set productName=?, supplierID=?, categoryID=?, quantityPerUnit=?, unitPrice=?, productImage=? where productID=?";
    private final static String DELETE_PRODUCT = "delete Products where productID=?";
    private final static String SEARCH_PRODUCT_BY_CATEGORY = "select p.ProductID, p.ProductName, p.SupplierID, p.CategoryID, p.QuantityPerUnit, p.UnitPrice, p.ProductImage from Products p, Categories c where c.CategoryName=? and c.CategoryID = p.CategoryID";
    private final static String UPDATE_QUANTITY = "update Products set QuantityPerUnit=? where ProductID=?";
    
    public List<Product> getAllProduct() throws SQLException {
        List<Product> lists = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(GET_ALL_PRODUCT);
                rs = ps.executeQuery();
                while(rs.next()) {
                     String productID = rs.getString("ProductID");
                     String productName = rs.getString("ProductName");
                     String supplierID = rs.getString("SupplierID");
                     String categoryID = rs.getString("CategoryID");
                     int quantityPerUnit = rs.getInt("QuantityPerUnit");
                     double unitPrice = rs.getDouble("UnitPrice");
                     String productImg = rs.getString("ProductImage");
                     Product product = new Product(productID, productName, supplierID, categoryID, quantityPerUnit, unitPrice, productImg);
                     lists.add(product);
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
    
    public List<Product> getProductByName(String name) throws SQLException {
        List<Product> lists = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(SEARCH_BY_NAME);
                ps.setString(1, "%" + name + "%");
                rs = ps.executeQuery();
                while(rs.next()) {
                     String productID = rs.getString("ProductID");
                     String productName = rs.getString("ProductName");
                     String supplierID = rs.getString("SupplierID");
                     String categoryID = rs.getString("CategoryID");
                     int quantityPerUnit = rs.getInt("QuantityPerUnit");
                     double unitPrice = rs.getDouble("UnitPrice");
                     String productImg = rs.getString("ProductImage");
                     Product product = new Product(productID, productName, supplierID, categoryID, quantityPerUnit, unitPrice, productImg);
                     lists.add(product);
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
    
    public List<Product> getProductByID(String id) throws SQLException {
        List<Product> lists = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(SEARCH_BY_ID);
                ps.setString(1, id);
                rs = ps.executeQuery();
                while(rs.next()) {
                     String productName = rs.getString("ProductName");
                     String supplierID = rs.getString("SupplierID");
                     String categoryID = rs.getString("CategoryID");
                     int quantityPerUnit = rs.getInt("QuantityPerUnit");
                     double unitPrice = rs.getDouble("UnitPrice");
                     String productImg = rs.getString("ProductImage");
                     Product product = new Product(id, productName, supplierID, categoryID, quantityPerUnit, unitPrice, productImg);
                     lists.add(product);
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
    
    public List<Product> getProductByPrice(double price) throws SQLException {
        List<Product> lists = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(SEARCH_BY_PRICE);
                ps.setDouble(1, price);
                rs = ps.executeQuery();
                while(rs.next()) {
                     String productID = rs.getString("ProductID");
                     String productName = rs.getString("ProductName");
                     String supplierID = rs.getString("SupplierID");
                     String categoryID = rs.getString("CategoryID");
                     int quantityPerUnit = rs.getInt("QuantityPerUnit");
                     String productImg = rs.getString("ProductImage");
                     Product product = new Product(productID, productName, supplierID, categoryID, quantityPerUnit, price, productImg);
                     lists.add(product);
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
    
    public List<Product> getProductByIdRecom(String id) throws SQLException {
        List<Product> lists = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(SEARCH_BY_ID_RECOM);
                ps.setString(1, "%" + id + "%");
                rs = ps.executeQuery();
                while(rs.next()) {
                     String productID = rs.getString("ProductID");
                     String productName = rs.getString("ProductName");
                     String supplierID = rs.getString("SupplierID");
                     String categoryID = rs.getString("CategoryID");
                     int quantityPerUnit = rs.getInt("QuantityPerUnit");
                     double unitPrice = rs.getDouble("UnitPrice");
                     String productImg = rs.getString("ProductImage");
                     Product product = new Product(productID, productName, supplierID, categoryID, quantityPerUnit, unitPrice, productImg);
                     lists.add(product);
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
    
    public List<Product> getProductByPriceRecom(double price1, double price2) throws SQLException {
        List<Product> lists = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(SEARCH_BY_PRICE_RECOM);
                ps.setDouble(1, price1);
                ps.setDouble(2, price2);
                rs = ps.executeQuery();
                while(rs.next()) {
                     String productID = rs.getString("ProductID");
                     String productName = rs.getString("ProductName");
                     String supplierID = rs.getString("SupplierID");
                     String categoryID = rs.getString("CategoryID");
                     int quantityPerUnit = rs.getInt("QuantityPerUnit");
                     double unitPrice = rs.getDouble("UnitPrice");
                     String productImg = rs.getString("ProductImage");
                     Product product = new Product(productID, productName, supplierID, categoryID, quantityPerUnit, unitPrice, productImg);
                     lists.add(product);
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
    
    public List<Category> getAllCategory() throws SQLException {
        List<Category> lists = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(GET_CATEGORY);
                rs = ps.executeQuery();
                while(rs.next()) {
                     String categoryID = rs.getString("CategoryID");
                     String categoryName = rs.getString("CategoryName");
                     String sdescription = rs.getString("Description");
                     Category category = new Category(categoryID, categoryName, sdescription);
                     lists.add(category);
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
    
    public List<Supplier> getAllSuppliers() throws SQLException {
        List<Supplier> lists = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(GET_SUPPLIER);
                rs = ps.executeQuery();
                while(rs.next()) {
                     String supplierID = rs.getString("SupplierID");
                     String companyName = rs.getString("CompanyName");
                     String address = rs.getString("Address");
                     String phone = rs.getString("Phone");
                     Supplier supplier = new Supplier(supplierID, companyName, address, phone);
                     lists.add(supplier);
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

    public boolean insert(String productID, String productName, String categoryID, String supplierID, int quantity, double price, String productImg) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(INSERT_PRODUCT);
                ps.setString(1, productID);
                ps.setString(2, productName);
                ps.setString(3, supplierID);
                ps.setString(4, categoryID);
                ps.setInt(5, quantity);
                ps.setDouble(6, price);
                ps.setString(7, productImg);
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

    public Product getProductByProductID(String id) throws SQLException {
        Product lists = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(SEARCH_BY_ID);
                ps.setString(1, id);
                rs = ps.executeQuery();
                while(rs.next()) {
                     String productName = rs.getString("ProductName");
                     String supplierID = rs.getString("SupplierID");
                     String categoryID = rs.getString("CategoryID");
                     int quantityPerUnit = rs.getInt("QuantityPerUnit");
                     double unitPrice = rs.getDouble("UnitPrice");
                     String productImg = rs.getString("ProductImage");
                     lists = new Product(id, productName, supplierID, categoryID, quantityPerUnit, unitPrice, productImg);
                     
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

    public boolean update(String productID, String productName, String categoryID, String supplierID, int quantity, double price, String productImg) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(UPDATE_PRODUCT);
                ps.setString(1, productName);
                ps.setString(2, supplierID);
                ps.setString(3, categoryID);
                ps.setInt(4, quantity);
                ps.setDouble(5, price);
                ps.setString(6, productImg);
                ps.setString(7, productID);
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

    public boolean delete(String productID) throws SQLException {
       boolean check = false;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(DELETE_PRODUCT);
                ps.setString(1, productID);
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

    public List<Product> getProductByCategory(String categoryName) throws SQLException {
        List<Product> lists = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(SEARCH_PRODUCT_BY_CATEGORY);
                ps.setString(1, categoryName);
                rs = ps.executeQuery();
                while(rs.next()) {
                     String productID = rs.getString("ProductID");
                     String productName = rs.getString("ProductName");
                     String supplierID = rs.getString("SupplierID");
                     String categoryID = rs.getString("CategoryID");
                     int quantityPerUnit = rs.getInt("QuantityPerUnit");
                     double unitPrice = rs.getDouble("UnitPrice");
                     String productImg = rs.getString("ProductImage");
                     Product product = new Product(productID, productName, supplierID, categoryID, quantityPerUnit, unitPrice, productImg);
                     lists.add(product);
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
    
    public boolean update_quantity(String productID, int quantity) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null) {
                ps = conn.prepareStatement(UPDATE_QUANTITY);
                ps.setInt(1, quantity);
                ps.setString(2, productID);
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
}
