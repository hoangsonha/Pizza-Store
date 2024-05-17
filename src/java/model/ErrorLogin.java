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
public class ErrorLogin {
    private String errorID;
    private String errorName;

    public ErrorLogin() {
        this.errorID = "";
        this.errorName = "";
    }

    public ErrorLogin(String errorID, String errorName) {
        this.errorID = errorID;
        this.errorName = errorName;
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
    
}
