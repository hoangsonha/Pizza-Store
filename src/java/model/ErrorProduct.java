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
public class ErrorProduct {
    private String errorID;
    private String errorName;
    private String errorCategory;
    private String errorSupplier;
    private String errorPrice;
    private String errorQuantity;
    private String errorImg;

    public ErrorProduct() {
    }

    public ErrorProduct(String errorID, String errorName, String errorCategory, String errorSupplier, String errorPrice, String errorQuantity, String errorImg) {
        this.errorID = errorID;
        this.errorName = errorName;
        this.errorCategory = errorCategory;
        this.errorSupplier = errorSupplier;
        this.errorPrice = errorPrice;
        this.errorQuantity = errorQuantity;
        this.errorImg = errorImg;
    }

    public String getErrorID() {
        return errorID;
    }

    public void setErrorID(String errorID) {
        this.errorID = errorID;
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

    public String getErrorCategory() {
        return errorCategory;
    }

    public void setErrorCategory(String errorCategory) {
        this.errorCategory = errorCategory;
    }

    public String getErrorSupplier() {
        return errorSupplier;
    }

    public void setErrorSupplier(String errorSupplier) {
        this.errorSupplier = errorSupplier;
    }

    public String getErrorPrice() {
        return errorPrice;
    }

    public void setErrorPrice(String errorPrice) {
        this.errorPrice = errorPrice;
    }

    public String getErrorQuantity() {
        return errorQuantity;
    }

    public void setErrorQuantity(String errorQuantity) {
        this.errorQuantity = errorQuantity;
    }

    public String getErrorImg() {
        return errorImg;
    }

    public void setErrorImg(String errorImg) {
        this.errorImg = errorImg;
    }
    
    
}
