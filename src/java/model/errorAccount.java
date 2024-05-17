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
public class errorAccount {
    private String errorID;
    private String errorUserName;
    private String errorFullName;
    private String errorPassword;

    public errorAccount() {
    }

    public errorAccount(String errorID, String errorUserName, String errorFullName, String password) {
        this.errorID = errorID;
        this.errorUserName = errorUserName;
        this.errorFullName = errorFullName;
        this.errorPassword = password;
    }

    public String getErrorID() {
        return errorID;
    }

    public void setErrorID(String errorID) {
        this.errorID = errorID;
    }

    public String getErrorUserName() {
        return errorUserName;
    }

    public void setErrorUserName(String errorUserName) {
        this.errorUserName = errorUserName;
    }

    public String getErrorFullName() {
        return errorFullName;
    }

    public void setErrorFullName(String errorFullName) {
        this.errorFullName = errorFullName;
    }

    public String getErrorPassword() {
        return errorPassword;
    }

    public void setErrorPassword(String errorPassword) {
        this.errorPassword = errorPassword;
    }

    
    
}
