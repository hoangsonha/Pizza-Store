/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Pizza {
    private String productID;
    private String productName;
    private String supplierID;
    private String categoryID;
    private int quantity;
    private double price;
    private String img;

    public Pizza() {
    }

    public Pizza(String productID, String productName, String supplierID, String categoryID, int quantityt, double price, String img) {
        this.productID = productID;
        this.productName = productName;
        this.supplierID = supplierID;
        this.categoryID = categoryID;
        this.quantity = quantityt;
        this.price = price;
        this.img = img;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantityt) {
        this.quantity = quantityt;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
 
    public static void main(String[] args) {
        String s = "";
        String a = "";
        if(a.equals(s)) {
            System.out.println("bang nhau");
        } else {
            System.out.println("k bang nhau");
        }
    }
    
}
